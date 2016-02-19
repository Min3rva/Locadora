package app;

import java.util.Date;
import exceptions.*;
import system.*;
import model.*;

/*
 * Classe para testar métodos do packet system
 */
public class TesteSystem {
	public static void main(String args[]){
		try{
			Sistema.cadastrarCarro("AXD1010", "fusca");
			Sistema.cadastrarCarro("tal4155", "uno");
			Sistema.cadastrarCliente("Talita", "0123345678955");
			try{
				Aluguel al = Sistema.alugarCarro("0123345678955", "tal4155", 15.2, new Date());
				System.out.println(al);
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
