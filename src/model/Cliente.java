package model;

import java.util.ArrayList;

import exceptions.ModelException;

public class Cliente {
	
	private String nome;
	private String cpf;
	private ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
	
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
	
	public ArrayList<Aluguel> getAlugueis() {
		return alugueis;
	}
	
	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	public void addAluguel(Aluguel aluguel){
		try{
			alugueis.add(aluguel);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public Aluguel localizarAluguel(int id) throws ModelException{
		
		for(Aluguel aluguel: alugueis){
			if(aluguel.getId() == id)
				return aluguel;
		}
		
		throw new ModelException("Aluguel não cadastrado!");
	}

}
