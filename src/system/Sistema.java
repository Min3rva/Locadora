package system;

import model.*;
import exceptions.ModelException;
import exceptions.SystemException;

import java.util.ArrayList;
import java.util.Date;

public class Sistema{
	
	private static Locadora locadora = new Locadora();
	
	public static Cliente cadastrarCliente(String nome, String cpf) throws SystemException{
		
		Cliente client = null;
		
		if(Util.validarCPF(cpf)){
			try{
				locadora.localizarCliente(cpf);
				throw new SystemException("Cliente já cadastrado!");
			}
			catch (ModelException e){
				client = new Cliente(nome, cpf);
				locadora.addCliente(client);
			}
		}
		else throw new SystemException("CPF Inválido!");
		
		return client;
	}
	
	
	public static Carro cadastrarCarro(String placa, String modelo) throws SystemException{
		
		Carro car = null;
		
		if(Util.validarPlacaCarro(placa)){
			try{
				locadora.localizarCarro(placa);
				throw new SystemException("Carro já cadastrado!");
			}
			catch (ModelException e){
				car = new Carro(placa, modelo);
				locadora.addCarro(car);
			}
		}
		else throw new SystemException("Placa Inválida!");
		
		return null;
	}
	

	public static Aluguel alugarCarro(String cpf, String placa, double diaria, Date datainicio, Date datafinal) 
																		throws SystemException{
		
		Aluguel result  = null;
		
		if(datafinal.getTime() > datainicio.getTime())
		{
			if(Util.validarCPF(cpf))
			{
				Cliente client = null;
				
				try{
					client = locadora.localizarCliente(cpf);
				
					if(Util.validarPlacaCarro(placa)){
						Carro car = null;
						
						try{
							car = locadora.localizarCarro(placa);
							
							if(!car.isAlugado()){
								int id = locadora.getAlugueis().size();
								result =  new Aluguel(id, datainicio, datafinal, diaria, car, client);
								locadora.addAluguel(result);
	
								car.addAluguel(result);
								client.addAluguel(result);
								car.setAlugado(true);
							}
							else throw new SystemException("Carro está alugado!");
						}
						catch (ModelException e){
							System.out.println(e.getMessage());
						}
						
					}else throw new SystemException("Placa Inválida!");
					
				}
				catch(ModelException e){
					System.out.println(e.getMessage());
				}
					
			}else throw new SystemException("CPF Inválido!");
		}else throw new SystemException("Data final menor que inicial!");
		
		return result;
	}
	
	
	public static void devolverCarro(String placa) throws SystemException{
		
		if(Util.validarPlacaCarro(placa)){
			
			Carro car = null;
			
			try{
				
				car = locadora.localizarCarro(placa);
				
				if(car.isAlugado())
				{
					
					Date data = new Date();
					ArrayList<Aluguel> listAlugueis = car.getAlugueis();
					Aluguel aluguel = listAlugueis.get(listAlugueis.size()-1);
					
					long di = aluguel.getDatainicio().getTime()/86400000;
					long df = data.getTime()/86400000;
					double diaria = aluguel.getDiaria();
					
					double newValor = (df-di) <= 0 ?  (di-df)*diaria : (df-di)*2*diaria + aluguel.getValor();
					
					/* Paga no minimo uma diária caso o carro seja devolvido antes de 24h
					 * Preço mínimo do aluguel
					 */
					aluguel.setValor(newValor > 0 ? newValor : diaria);
					aluguel.setFinalizado(true);
					car.setAlugado(false);
				}
				else throw new SystemException("Carro não está alugado!");
				
			}
			catch (ModelException e){
				throw new SystemException(e.getMessage());
			}
			
		}else throw new SystemException("Placa inválida!");
		
	}
	
	
	public static String listarClientes() throws SystemException{
		String ultimoAluguel = "";
		String stringClientes = "";
		ArrayList<Cliente> listaClientes = locadora.getClientes();
		
		if(!listaClientes.isEmpty()){
			for(Cliente client: listaClientes){
				ArrayList<Aluguel> listaAlugueis = client.getAlugueis();
				
				if(!listaAlugueis.isEmpty()){
					Aluguel alug = listaAlugueis.get(listaAlugueis.size()-1);
					ultimoAluguel = " Último aluguel: " + Util.formataData(alug.getDatainicio());
				}
				else ultimoAluguel = "";
				
				stringClientes+=("CPF: " + client.getCpf() + " Nome: " + client.getNome() +  ultimoAluguel + ";" );
			}
		}
		else throw new SystemException("Não existem clientes cadastrados!");
		
		return stringClientes;
	}
	
	
	public static String listarCarros() throws SystemException{
		String stringCarros = "";
		ArrayList<Carro> listaCarros = locadora.getCarros();
		
		if(!listaCarros.isEmpty()){
			for(Carro car: listaCarros){
				ArrayList<Aluguel> listaAlugueis = car.getAlugueis();
				String nomeCliente = car.isAlugado() ? " Cliente: " + listaAlugueis.get(listaAlugueis.size()-1).getCliente().getNome() : "";
				stringCarros+="Placa:" + car.getPlaca() + " Modelo:" + car.getModelo() + nomeCliente + ";";
			}
		}
		else throw new SystemException("Não existem carros cadastrados!");
		
		return stringCarros;
	}
	
	public static String listarAlugueisFinalizados() throws SystemException{
		String stringAlugueis = "";
		ArrayList<Aluguel> listaAlugueis = locadora.getAlugueis();
		int days = 0;
		
		if(!listaAlugueis.isEmpty()){
			for(Aluguel alug: listaAlugueis){
				if(alug.isFinalizado()){
					String dataInit = Util.formataData(alug.getDatainicio());
					String dataFim = Util.formataData(alug.getDatafim());
					
					days += Integer.parseInt(dataFim.split("/")[0]) - Integer.parseInt(dataInit.split("/")[0]);
					
					stringAlugueis+="ID:" + alug.getId() + " Carro:" + alug.getCarro().getPlaca() + " Cliente:" + 
							alug.getCliente().getNome()  + " Valor:" + alug.getValor() + " Inicio: " + 
							dataInit + " Fim: "  + dataFim + " Quantidade de dias de todos os alugueis: " + days + ";";
				}
			}
			
			if(stringAlugueis == "") throw new SystemException("Não existem alugueis finalizados!");
		}
		else throw new SystemException("Não exisem alugueis cadastrados!");
		
		return stringAlugueis;
	}
	
	public static String listarAlugueisHoje() throws SystemException{
		String alugueisHoje = "";
		ArrayList<Aluguel> listaAlugueis = locadora.getAlugueis();
		Date today = new Date();
		
		if(!listaAlugueis.isEmpty()){
			for(Aluguel alug: listaAlugueis){
				Date fim = alug.getDatafim();
				
				if( Util.formataDataDia(today).equals(Util.formataDataDia(fim) ) && !alug.isFinalizado()){
					alugueisHoje+="ID:" + alug.getId() + " Carro: " + alug.getCarro().getPlaca() + " Cliente:" + 
							alug.getCliente().getNome();
				}
			}
			
			if(alugueisHoje.equals("")) 
				throw new SystemException("Não existem alugueis a serem finalizados hoje!");
			
		}else throw new SystemException("Não existem alugueis cadastrados!");
		
		return alugueisHoje;
	}
	
}
