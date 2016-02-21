package model;

import java.util.ArrayList;

public class Cliente {
	
	private String nome;
	private String cpf;
	private ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
	
	public Cliente(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", alugueis=" + alugueis + "]";
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public ArrayList<Aluguel> getAlugueis() {
		return alugueis;
	}
	
	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

}
