package system;

import model.*;
import exceptions.ModelException;
import exceptions.SystemException;

import java.util.Date;

public class Sistema{
	
	private static Locadora locadora = new Locadora();
	
	public static Cliente cadastrarCliente(String nome, String cpf) throws SystemException{
		
		Cliente client = null;
		
		if(Util.validarCPF(cpf)){
			client = new Cliente(nome, cpf);
			locadora.addCliente(client);
		}
		else throw new SystemException("CPF Inválido!");
		
		return client;
	}
	
	
	public static Carro cadastrarCarro(String placa, String modelo) throws SystemException{
		
		Carro car = null;
		
		if(Util.validarPlacaCarro(placa)){
			car = new Carro(placa, modelo);
			locadora.addCarro(car);
		}
		else throw new SystemException("Placa Inválida!");
		
		return null;
	}
	

	public static Aluguel alugarCarro(String cpf, String placa, Double diaria, Date datafinal) 
																		throws SystemException{
		
		Aluguel result  = null;
		
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
							result =  new Aluguel(new Date(), datafinal, diaria, car, client);
							car.addAluguel(result);
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
		
		return result;
	}
	
	
	public static void devolverCarro(){
		//TODO
	}
	
	
	public static String listarClientes(){
		//TODO
		return null;
	}
	
	
	public static String listarCarros(){
		//TODO
		return null;
	}
	
	public static String listarAlugueisFinalizados(){
		//TODO
		return null;
	}
	
	public static String listarAlugueisHoje(){
		//TODO
		return null;
	}
	
}
