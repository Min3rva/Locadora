package model;

import java.util.Date;

public class Aluguel {
	
	private int id;
	private Date datainicio;
	private Date datafim;
	private Double valor;
	private boolean finalizado;
	private Carro carro;
	private Cliente cliente;
	
	
	public Aluguel(Date inicio, Date fim, Double diaria, Carro car, Cliente client){
		datainicio = inicio;
		datafim = fim;
		valor = diaria;
		carro = car;
		cliente = client;
	}
	
	@Override
	public String toString() {
		return "Aluguel [id=" + id + ", datainicio=" + datainicio + ", datafim=" + datafim + ", valor=" + valor
				+ ", finalizado=" + finalizado + ", carro=" + carro + ", cliente=" + cliente + "]";
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDatainicio() {
		return datainicio;
	}
	
	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}
	
	public Date getDatafim() {
		return datafim;
	}
	
	public void setDatafim(Date datafim) {
		this.datafim = datafim;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	public Carro getCarro() {
		return carro;
	}
	
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
