package system;

import model.*;
import exceptions.ModelException;
import exceptions.SystemException;

import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

public class Sistema{
	
	private static Locadora locadora = new Locadora();
	
	public static Cliente cadastrarCliente(String nome, String cpf) throws SystemException{
		
		Cliente client = null;
		
		try{
			locadora.localizarCliente(cpf);
			throw new SystemException("Cliente já cadastrado!");
		}
		catch (ModelException e){
			client = new Cliente(nome, cpf);
			locadora.addCliente(nome, client);
		}

		return client;
	}
	
	public static ClienteFidelidade cadastrarClienteFidelidade(String cpf, String nome, int numeroCartao) 
			throws SystemException{
		
		ClienteFidelidade client = null;

		try{
			locadora.localizarCliente(cpf);			
			throw new SystemException("Cliente já cadastrado!");
		}
		catch (ModelException e){
			client = new ClienteFidelidade(numeroCartao, nome, cpf);
			locadora.addCliente(nome, client);
		}
		
		return client;
	}
	
	
	public static Carro cadastrarCarro(String placa, String modelo) throws SystemException{
		
		Carro car = null;

		try{
			locadora.localizarCarro(placa);
			throw new SystemException("Carro já cadastrado!");
		}
		catch (ModelException e){
			car = new Carro(placa, modelo);
			locadora.addCarro(placa, car);
		}
		
		return null;
	}
	

	public static Aluguel alugarCarro(String cpf, String placa, double diaria, Date datainicio, Date datafinal) 
																		throws SystemException{
		
		Aluguel result  = null;
		
		if(datafinal.getTime() > datainicio.getTime())
		{
			Cliente client = null;
			
			try{
				client = locadora.localizarCliente(cpf);
				boolean semAluguel = true;
				
				TreeMap<Integer, Aluguel> listAluguelCliente = client.getAlugueis();
				int key = 0;
				
				for(int i: listAluguelCliente.keySet()){
					key = i;
				}
				
				if(!listAluguelCliente.isEmpty())
					semAluguel = listAluguelCliente.get(key).isFinalizado();
				
				if(semAluguel){
				
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
				}
				else throw new SystemException("Existe Aluguel em andamento!");
			}
			catch(ModelException e){
				System.out.println(e.getMessage());
			}
		
		}else throw new SystemException("Data final menor que inicial!");
		
		return result;
	}
	
	
	public static void devolverCarro(String placa) throws SystemException{

			Carro car = null;
			
			try{
				
				car = locadora.localizarCarro(placa);
				
				if(car.isAlugado())
				{
					
					Date data = new Date();
					TreeMap<Integer, Aluguel> listAlugueis = car.getAlugueis();
					int key = 0;
					
					for(int i: listAlugueis.keySet()){
						key = i;
					}
					Aluguel aluguel = listAlugueis.get(key);
					
					long di = aluguel.getDatainicio().getTime()/86400000;
					long df = data.getTime()/86400000;
					double diaria = aluguel.getDiaria();
					
					double newValor = (df-di) <= 0 ?  (di-df)*diaria : (df-di)*2*diaria + aluguel.getValor();
					
					if(aluguel.getCliente() instanceof ClienteFidelidade)
						newValor-=newValor*0.1;
					
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
		
	}
	
	
	public static String listarClientes() throws SystemException{
		String ultimoAluguel = "";
		String stringClientes = "";
		String cartaoFidelidade = "";
		TreeMap<String, Cliente> listaClientes = locadora.getClientes();
		
		if(!listaClientes.isEmpty()){
			for(Cliente client: listaClientes.values()){
				TreeMap<Integer, Aluguel> listaAlugueis = client.getAlugueis();
				
				if(!listaAlugueis.isEmpty()){
					int key = 0;
					
					for(int i: listaAlugueis.keySet()){
						key = i;
					}
					
					Aluguel alug = listaAlugueis.get(key);
					
					ultimoAluguel = " Último aluguel: " + Util.formataData(alug.getDatainicio());
				}
				else ultimoAluguel = "";
				
				if(client instanceof ClienteFidelidade){
					ClienteFidelidade c = (ClienteFidelidade) client;
					cartaoFidelidade = " Cartão Fidelidade: " + c.getNumerocartao();
				}
				else cartaoFidelidade = "";
				
				stringClientes+=("CPF: " + client.getCpf() + " Nome: " + client.getNome() +  
						ultimoAluguel + cartaoFidelidade + ";" );
			}
		}
		else throw new SystemException("Não existem clientes cadastrados!");
		
		return stringClientes;
	}
	
	
	public static String listarCarros() throws SystemException{
		String stringCarros = "";
		TreeMap<String,Carro>listaCarros = locadora.getCarros();
		
		if(!listaCarros.isEmpty()){
			for(Carro car: listaCarros.values()){
				TreeMap<Integer, Aluguel> listaAlugueis = car.getAlugueis();
				int key = 0;
				
				for(int i: listaAlugueis.keySet()){
					key = i;
				}
				
				String nomeCliente = car.isAlugado() ? " Cliente: " + listaAlugueis.get(key).getCliente().getNome() : "";
				
				stringCarros+="Placa:" + car.getPlaca() + " Modelo:" + car.getModelo() + nomeCliente + ";";
			}
		}
		else throw new SystemException("Não existem carros cadastrados!");
		
		return stringCarros;
	}
	
	public static String listarAlugueisFinalizados() throws SystemException{
		String stringAlugueis = "";
		TreeMap<Integer, Aluguel> listaAlugueis = locadora.getAlugueis();
		int days = 0;
		
		if(!listaAlugueis.isEmpty()){
			for(Aluguel alug: listaAlugueis.values()){
				if(alug.isFinalizado()){
					String dataInit = Util.formataData(alug.getDatainicio());
					String dataFim = Util.formataData(alug.getDatafim());
					
					days += (int) Util.diffTime(alug.getDatainicio(), alug.getDatafim());
					
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
		TreeMap<Integer, Aluguel> listaAlugueis = locadora.getAlugueis();
		Date today = new Date();
		
		if(!listaAlugueis.isEmpty()){
			for(Aluguel alug: listaAlugueis.values()){
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
	
	public static void excluirCarro(String placa) throws SystemException{
		Carro car = null;
		
		try{
			car = locadora.localizarCarro(placa);
			
			if(!car.isAlugado()){
				TreeMap<Integer, Aluguel> alugueis = car.getAlugueis();
				if (alugueis != null)
				{
					for(Aluguel alug: alugueis.values()){
						int id = alug.getId();
							locadora.excluirAluguel(id);
							car.excluirAluguel(id);
							alug.getCliente().excluirAluguel(id);
					}
				}
				
				try{
					locadora.excluirCarro(placa);
				}
				catch (ModelException e){
					throw new SystemException(e.getMessage());
				}
			}
			else throw new SystemException("O carro está alugado!");
			
		}
		catch(ModelException e){
			throw new SystemException(e.getMessage());
		}
		
		
	}
	
}
