package br.com.ifsp.similaridade.modelo;

import java.util.HashMap;
import java.util.Map;

public abstract class Arquivo {
				//key   //value
	private Map<String, Integer> mapa = new HashMap<>();
	private String nome;
	private String caminho;

	public Arquivo(String caminho) {

		this.caminho = caminho;
	}

	public abstract void lerArquivo();

	public abstract void PreecheMapa(String[] palavra);

	public Map<String, Integer> getMapa() {
		return mapa;
	}

	public void setMapa(Map<String, Integer> mapa) {
		this.mapa = mapa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

}
