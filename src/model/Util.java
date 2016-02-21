package model;

public class Util {
	
	public static boolean validarCPF(String cpf) {
		//TODO
		return true;
	}
	
	public static boolean validarPlacaCarro(String placa){
		
		if (placa.matches("[A-Za-z]{3}\\d{4}")){
			return true;
		}
		
		return false;
	}
}
