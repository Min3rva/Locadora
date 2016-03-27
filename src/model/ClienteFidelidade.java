package model;

public class ClienteFidelidade {
	private int numerocartao;
	private String nome;
	private String cpf;
	
	public ClienteFidelidade(int id, String nome, String cpf) {
		numerocartao = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	public int getNumerocartao() {
		return numerocartao;
	}

	public void setNumerocartao(int numerocartao) {
		this.numerocartao = numerocartao;
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

	@Override
	public String toString() {
		return "ClienteFidelidade [numerocartao=" + numerocartao + ", nome=" + nome + ", cpf=" + cpf + "]";
	}



}
