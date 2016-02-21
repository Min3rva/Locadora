package app;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import exceptions.*;
import system.*;
import model.*;

/*
 * Classe para testar métodos do packet system
 */
public class TesteSystem {
	public static void main(String args[]){
		try{
			Sistema.cadastrarCarro("taa1010", "fusca");
			Sistema.cadastrarCarro("tal4155", "uno");
			
			try{
				Sistema.cadastrarCliente("Talita", "016.371.734-66");
				Sistema.cadastrarCliente("Levy", "016.371.734-64");
				System.out.println("Cadastro realizado!");
				
				try{
					GregorianCalendar data = new GregorianCalendar(2016, 1, 21, 20, 30);
					Sistema.alugarCarro("016.371.734-66", "taa1010", 15.2, data.getTime());
					Sistema.alugarCarro("016.371.734-64", "tal4155", 15.2, data.getTime());
					Sistema.devolverCarro("taa1010");
					String alug = Sistema.listarAlugueisFinalizados();
					System.out.println("Finalizados=" + alug);
					//Sistema.alugarCarro("016.371.734-64", "taa1010", 15.2, data.getTime());
					alug = Sistema.listarClientes();
					System.out.println(alug);
					alug = Sistema.listarCarros();
					System.out.println(alug);
					alug = Sistema.listarAlugueisHoje();
					System.out.println("Finalizar Hoje: " + alug);
				}
				catch (Exception e){
					System.out.println(e.getMessage());
				}
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
		
		}
		catch (SystemException e){
			System.out.println(e.getMessage());
		}
		
	}
}
