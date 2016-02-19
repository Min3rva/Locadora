package model;

import java.util.ArrayList;

public class Locadora {
	
	private String nome;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Carro> carros 	= new ArrayList<Carro>();
	private ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public ArrayList<Carro> getCarros() {
		return carros;
	}
	
	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
	}
	
	public ArrayList<Aluguel> getAlugueis() {
		return alugueis;
	}
	
	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
}
