package app;

import exceptions.ModelException;
import model.*;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * Classe para testar métodos do packet model
 */
public class TesteModel {
	public static void main(String args[]){
		String placa = "aBc12356";
		
//		if(Util.validarPlacaCarro("talq1010"))
//			System.out.println("Placa válida");
//		else System.out.println("Placa inválida");

		if (placa.matches("[A-Za-z]{3}\\d{4}"))
			System.out.println("Placa válida");
		
	}	
}
