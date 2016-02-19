package app;

import exceptions.ModelException;
import model.*;
import java.util.Date;

/*
 * Classe para testar métodos do packet model
 */
public class TesteModel {
	public static void main(String args[]){
		
		if(Util.validarPlacaCarro("talq1010"))
			System.out.println("Placa válida");
		else System.out.println("Placa inválida");

		
	}	
}
