package model;

import java.util.ArrayList;
import exceptions.ModelException;

public class Locadora {

	private String nome;
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Carro> carros 	= new ArrayList<Carro>();
	private ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();
	
	public Locadora(){
		
	}
	
	@Override
	public String toString() {
		return "Locadora [nome=" + nome + ", clientes=" + clientes + ", carros=" + carros + ", alugueis=" + alugueis
				+ "]";
	}
	
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
	
	public void addCarro(Carro car){
		carros.add(car);
	}
	
	public Carro localizarCarro(String placa) throws ModelException{
		
		for(Carro car: carros){
			if(car.getPlaca().equals(placa.toUpperCase()))
				return car;
		}
		
		throw new ModelException("Carro não cadastrado!");
	}
	
	public void addCliente(Cliente client){
		clientes.add(client);
	}
	
	
	public Cliente localizarCliente(String cpf) throws ModelException{
		
		for(Cliente client: clientes){
			if(client.getCpf().equals(cpf.toUpperCase()))
				return client;
		}
		
		throw new ModelException("Cliente não cadastrado!");
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
