package model;

public class ClienteFidelidade extends Cliente{
	private int numerocartao;
	
	public ClienteFidelidade(int id, String nome, String cpf) {
		super(nome, cpf);
		numerocartao = id;
	}

	public int getNumerocartao() {
		return numerocartao;
	}

	public void setNumerocartao(int numerocartao) {
		this.numerocartao = numerocartao;
	}

	@Override
	public String toString() {
		return "ClienteFidelidade [numerocartao=" + numerocartao + "]";
	}

}
