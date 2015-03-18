package br.com.ifsp.similaridade.modelo;

import java.util.HashMap;
import java.util.Map;

public abstract class Arquivo {

private Map<String, Integer>map=new HashMap<>(); 

public abstract void lerArquivo();

public Map<String, Integer> getMap() {
	return map;
}

public void setMap(Map<String, Integer> map) {
	this.map = map;
}

	
}
