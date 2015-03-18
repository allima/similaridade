package br.com.ifsp.similaridade.modelo;

import java.util.HashMap;
import java.util.Map;

public abstract class Arquivo {

	private Map<String, Integer> map = new HashMap<>();
	private String nome;
	private String caminho;

	public Arquivo(String caminho) {

		this.caminho = caminho;
	}

	public abstract void lerArquivo();

	public abstract void PreecheMapa(String[] palavra);

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
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
