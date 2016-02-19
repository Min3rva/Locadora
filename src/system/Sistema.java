package system;

import model.*;
import java.util.Date;

public class Sistema {
	
	//zézis
	public static Cliente cadastrarCliente() {
		//TODO
		return null;
	}
	
	//zézis
	public static Carro cadastrarCarro(){
		//TODO
		return null;
	}
	
	//talitis
	//Issues: Validar cpf do cliente e placa
	public static Aluguel alugarCarro(String cpf, String placa, Double diaria, Date datafinal){
		return new Aluguel(datafinal, diaria);
	}
	
	//talitis
	public static void devolverCarro(){
		//TODO
	}
	
	//zézis
	public static String listarClientes(){
		//TODO
		return null;
	}
	
	//zézis
	public static String listarCarros(){
		//TODO
		return null;
	}
	
	//talitis
	public static String listarAlugueisFinalizados(){
		//TODO
		return null;
	}
	
	//talitis
	public static String listarAlugueisHoje(){
		//TODO
		return null;
	}
	
}
