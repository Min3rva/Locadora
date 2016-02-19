package system;

import model.*;
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
		else throw new SystemException("CPF Inválido");
		
		return client;
	}
	
	
	public static Carro cadastrarCarro(String placa, String modelo) throws SystemException{
		
		Carro car = null;
		
		if(Util.validarPlacaCarro(placa)){
			car = new Carro(placa, modelo);
			locadora.addCarro(car);
		}
		else throw new SystemException("Placa Inválida");
		
		return null;
	}
	
	
	//Issues: Validar cpf do cliente e placa
	public static Aluguel alugarCarro(String cpf, String placa, Double diaria, Date datafinal){
		return new Aluguel(datafinal, diaria);
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
