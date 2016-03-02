package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static boolean validarCPF(String cpf) {
		if(cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}") || cpf.matches("\\d{11}"))
			return true;
		
		return false;
	}
	
	public static boolean validarPlacaCarro(String placa){
		
		if (placa.matches("[A-Za-z]{3}\\d{4}")){
			return true;
		}
		
		return false;
	}
	
	public static String formataData(Date data){
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = fmt.format(data);
		
		return dataFormatada;
	}
	
	public static String formataDataDia(Date data){
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = fmt.format(data);
		
		return dataFormatada;
	}
	
}
