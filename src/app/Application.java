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
		System.out.print("Data início (dd/MM/yyyy)");
		di = cs.next();
		System.out.print("Hora inicio (HH:mm:ss): ");
		hi = cs.next();
		System.out.print("Data fim (dd/MM/yyyy): ");
		df = cs.next();
		System.out.print("Hora fim (HH:mm:ss): ");
		hf = cs.next();
		
//		try{
//			
//		}
//		catch (Exception e){
//			System.out.println(e.getMessage());
//		}
	}
	
}
