package model;

import java.util.ArrayList;

import exceptions.ModelException;

public class Carro {
	
	private String placa;
	private String modelo;
	private boolean alugado;
	private ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
	
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
	
	public ArrayList<Aluguel> getAlugueis() {
		return alugueis;
	}
	
	public void setAlugueis(ArrayList<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	public void addAluguel(Aluguel aluguel){
		alugueis.add(aluguel);
	}
	
	public Aluguel localizarAluguel(int id) throws ModelException{
		
		for(Aluguel aluguel: alugueis){
			if(aluguel.getId() == id)
				return aluguel;
		}
		
		throw new ModelException("Aluguel não cadastrado!");
	}

}
