package model;

import java.util.ArrayList;

public class Carro {
	
	private String placa;
	private String modelo;
	private boolean alugado;
	private ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
	
	
	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
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

}
