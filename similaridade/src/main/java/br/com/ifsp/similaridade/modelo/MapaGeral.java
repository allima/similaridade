package br.com.ifsp.similaridade.modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapaGeral {

	private Map<String, Integer> mapageral = new HashMap<>();

	public void Lermapas(Map<String, Integer> mapa) {

		Set<String> keys = mapa.keySet();
		for (String key : keys) {
			// mapageral.get(key);
			Integer freq = mapageral.get(key);
			if (freq != null) {
				mapageral.put(key, freq + 1);
			} else {
				mapageral.put(key, 1);
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
