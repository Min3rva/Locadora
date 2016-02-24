package app;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import system.*;
import model.*;

/*
 * Classe que implementa a aplicação da locadora
 */
public class Application {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		flow00();
		
		int op = 1;
		
		while(op != 0){
			showMenu();
			op = sc.nextInt();
			
			flow01();
			
//			switch(op){
//			case 1:
//				
//			}
			
		}
		
		System.out.println("saiu");
		
	}
	
	public static void showMenu(){
		
		System.out.println("0. Sair");
		System.out.println("1. Alugar carro");
		System.out.println("2. Devolver carro");
		System.out.println("3. Listar clientes");
		System.out.println("4. Listar carros");
		System.out.println("5. Listar alugueis finalizados");
		System.out.println("6. Listar alugueis a serem finalizados hoje");
		
	}
	
	public static void flow01(){
		Scanner cs = new Scanner(System.in);
		String cpf, placa, di, df, hi, hf;;
		double diaria;
		
		System.out.print("CPF (nnn.nnn.nnn-nn): ");
		cpf = cs.next();
		System.out.print("Placa do carro (AAANNNN): ");
		placa = cs.next();
		System.out.print("Valor da diária: ");
		diaria = cs.nextDouble();
		System.out.print("Data início (dd/MM/yyyy): ");
		di = cs.next();
		System.out.print("Hora inicio (HH:mm:ss): ");
		hi = cs.next();
		System.out.print("Data fim (dd/MM/yyyy): ");
		df = cs.next();
		System.out.print("Hora fim (HH:mm:ss): ");
		hf = cs.next();
		
		String[] dataInit  = di.split("/");
		String[] dataFinal = df.split("/");
		String[] horaInit  = hi.split(":");
		String[] horaFinal = hf.split(":");
		
		if((dataInit.length + horaInit.length == 6) && ( dataFinal.length + horaFinal.length == 6)){
			GregorianCalendar calendarInit = new GregorianCalendar(Integer.parseInt(dataInit[2]), Integer.parseInt(dataInit[1])-1, 
					Integer.parseInt(dataInit[0]), Integer.parseInt(horaInit[0]), Integer.parseInt(horaInit[1]));
			GregorianCalendar calendarFinal = new GregorianCalendar(Integer.parseInt(dataFinal[2]), Integer.parseInt(dataFinal[1])-1, 
					Integer.parseInt(dataFinal[0]), Integer.parseInt(horaFinal[0]), Integer.parseInt(horaFinal[1]));

			try{
				Aluguel alug = Sistema.alugarCarro(cpf, placa, diaria, calendarInit.getTime(), calendarFinal.getTime());
				System.out.println("Aluguel realizado com sucesso!\nValor: " + alug.getValor());
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			}
			
			
			
		}
		
		
//		try{
//			
//		}
//		catch (Exception e){
//			System.out.println(e.getMessage());
//		}
	}
	
	public static void flow00(){
		try{
			Sistema.cadastrarCliente("Joãozinho", "016.123.753-10");
			Sistema.cadastrarCliente("Mariazinha", "016.123.753-11");
			Sistema.cadastrarCliente("Zezinho", "016.123.753-12");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			Sistema.cadastrarCarro("ABC0000", "Gol");
			Sistema.cadastrarCarro("ABC0001", "Uno");
			Sistema.cadastrarCarro("ABC0002", "Palio");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
}
