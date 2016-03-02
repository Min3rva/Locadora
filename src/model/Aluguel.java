package model;

import java.util.Date;

public class Aluguel {
	
	private int id;
	private Date datainicio;
	private Date datafim;
	private double valor;
	private double diaria;
	private boolean finalizado;
	private Carro carro;
	private Cliente cliente;
	

	public Aluguel(int id, Date inicio, Date fim, double valorDia, Carro car, Cliente client){
		double diffTime = (fim.getTime() - inicio.getTime())/86400000; 
		datainicio = inicio;
		datafim = fim;
		diaria = valorDia;
		valor = (valorDia*diffTime > 0 ? valorDia*diffTime : diaria);
		carro = car;
		cliente = client;
		finalizado = false;
	}
	
	@Override
	public String toString() {
		return "Aluguel [id=" + id + ", datainicio=" + datainicio + ", datafim=" + datafim + ", valor=" + valor
				+ ", diaria=" + diaria + ", finalizado=" + finalizado + ", carro=" + carro.getPlaca() + ", cliente=" + cliente.getNome()
				+ "]";
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
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	public double getDiaria() {
		return diaria;
	}

	public void setDiaria(double diaria) {
		this.diaria = diaria;
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
