package model;

import java.util.ArrayList;
import java.util.TreeMap;

import exceptions.ModelException;

public class Carro {
	
	private String placa;
	private String modelo;
	private boolean alugado;
	private TreeMap<Integer, Aluguel> alugueis = new TreeMap<Integer, Aluguel>();
	
	public Carro(String placa, String modelo){
		this.placa = placa.toUpperCase();
		this.modelo = modelo;
		alugado = false;
	}
	
	@Override
	public String toString() {
		return "Carro [placa=" + placa + ", modelo=" + modelo + ", alugado=" + alugado + ", alugueis=" + alugueis.size() + "]";
	}
	

	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa.toUpperCase();
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public boolean isAlugado() {
		return alugado;
	}
	
	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
	
	public TreeMap<Integer, Aluguel> getAlugueis() {
		return alugueis;
	}
	
	public void setAlugueis(TreeMap<Integer, Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	public void addAluguel(Aluguel aluguel){
		alugueis.put(aluguel.getId(), aluguel);
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
