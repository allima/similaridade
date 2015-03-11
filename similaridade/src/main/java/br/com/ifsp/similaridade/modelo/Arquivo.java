package br.com.ifsp.similaridade.modelo;

public class Arquivo {

	private String caminho;
	private String nome;

	public Arquivo(String caminho, String nome) {
		this.caminho = caminho;
		this.nome = nome;

	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
