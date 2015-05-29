package br.com.ifsp.similaridade.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapaGeral {

	private Map<String, Integer> mapageral = new HashMap<>();
//http://introcs.cs.princeton.edu/java/home/
	public void IDF(int numeroAquivos) {
		// Set<String> keys = this.mapageral.keySet();
		for (String key : this.mapageral.keySet()) {
			Integer freq = this.mapageral.get(key);
			System.out.println("palavras = " + key + " n = "
					+ this.mapageral.get(key) + " numero IDF ="
					+ Math.log(numeroAquivos / freq));
			System.out.println(numeroAquivos);
		}
	}

	public void Lermapas(Map<String, Integer> mapa) {

		Set<String> keys = mapa.keySet();
		for (String key : keys) {
			// mapageral.get(key);
			Integer freq = this.mapageral.get(key);
			if (freq != null) {
				this.mapageral.put(key, freq + 1);
			} else {
				this.mapageral.put(key, 1);
			}
			// System.out.println("Key: " + key);
		}

	}

	public Map<String, Integer> getMapageral() {
		return mapageral;
	}

	public void setMapageral(Map<String, Integer> mapageral) {
		this.mapageral = mapageral;
	}

}
