package model;

public class Util {
	
	public static boolean validarCPF(String cpf) {
		//TODO
		return false;
	}
	
	public static boolean validarPlacaCarro(String placa){
		
		if(placa.length() == 7){
			
			placa.toUpperCase();
			
			System.out.println(placa);
			
			for(int i=0; i<3; i++){
				if( !((placa.charAt(i) >= 'A') && (placa.charAt(i) <= 'Z')) ){
					return false;
				}
			}
			
			for(int i=3; i<7; i++){
				if( !((placa.charAt(i) >= '0') || (placa.charAt(i) <= '9')) ){
					return false;
				}
			}
		}
		else return false;
		
		return true;
	}
}
