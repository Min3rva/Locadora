package model;

import java.util.ArrayList;
import java.util.TreeMap;

import exceptions.ModelException;

public class Cliente {
	
	private String nome;
	private String cpf;
	private TreeMap<Integer, Aluguel> alugueis = new TreeMap<Integer, Aluguel>();
	
	public Cliente(String nome, String cpf){
		this.nome = nome.toUpperCase();
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", alugueis=" + alugueis.size() + "]";
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public TreeMap<Integer, Aluguel> getAlugueis() {
		return alugueis;
	}
	
	public void setAlugueis(TreeMap<Integer, Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	public void addAluguel(Aluguel aluguel){
		try{
			alugueis.put(aluguel.getId(), aluguel);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public Aluguel localizarAluguel(int id) throws ModelException{
		
		Aluguel alug = alugueis.get(id);
		
		if(alug == null) 
			throw new ModelException("Aluguel não cadastrado!");
	
		return alug;
	}
	
	public void excluirAluguel(int id){
		alugueis.remove(id);
	}

}
