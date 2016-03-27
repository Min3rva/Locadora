package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import exceptions.ModelException;

public class Locadora {

	private String nome;
	private TreeMap<String,Cliente> clientes = new TreeMap<String,Cliente>();
	private TreeMap<String,Carro> carros = new TreeMap<String,Carro>();
	private TreeMap<Integer, Aluguel> alugueis = new TreeMap<Integer, Aluguel>();
	
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
	
	public TreeMap<String,Cliente> getClientes() {
		return clientes;
	}
	
	public void setClientes(TreeMap<String,Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public TreeMap<String,Carro> getCarros() {
		return carros;
	}
	
	public void setCarros(TreeMap<String,Carro> carros) {
		this.carros = carros;
	}
	
	public TreeMap<Integer, Aluguel> getAlugueis() {
		return alugueis;
	}
	
	public void setAlugueis(TreeMap<Integer, Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	
	public void addCarro(String placa, Carro car){
		carros.put(placa.toUpperCase(), car);
	}
	
	public Carro localizarCarro(String placa) throws ModelException{
		
		Carro car = carros.get(placa.toUpperCase());
		
		if(car != null) return car;
		else throw new ModelException("Carro não cadastrado!");
	}
	
	public void addCliente(String nome, Cliente client){
		clientes.put(nome.toUpperCase(),client);
	}
	
	
	public Cliente localizarCliente(String cpf) throws ModelException{
		
		for(Cliente client: clientes.values()){
			if(client.getCpf().equals(cpf.toUpperCase()))
				return client;
		}
		
		throw new ModelException("Cliente não cadastrado!");
	}
	
	public void excluirAluguel(int id){
		alugueis.remove(id);
	}
	
	public void excluirCarro(String placa)throws ModelException{
		
		if (localizarCarro(placa) == null)
			throw new ModelException("Carro não encontrando!");
		
		carros.remove(placa.toUpperCase());
			
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
}
