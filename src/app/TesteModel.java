package app;

import exceptions.ModelException;
import model.*;
import java.util.Date;

/*
 * Classe para testar métodos do packet model
 */
public class TesteModel {
	public static void main(String args[]){
		
		Carro car = new Carro("AXD1526");
		Locadora l = new Locadora();
		
		l.addCarro(car);
		
		/**Testa o método localizarCarro da Locadora**/
		
		try{
			l.localizarCarro("AXD1526");
			System.out.println("Carro encontrado");
		}
		catch(ModelException me){
			System.out.println("Carro não encontrado");
		}
		
		try{
			l.localizarCarro("ABC1515");
			System.out.println("Carro encontrado");
		}
		catch(ModelException me){
			System.out.println("Carro não encontrado");
		}
		
		/*********************************************/

		
	}	
}
