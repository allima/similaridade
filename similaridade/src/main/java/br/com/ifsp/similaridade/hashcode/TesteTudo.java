package br.com.ifsp.similaridade.hashcode;

import java.util.HashSet;
import java.util.Iterator;

public class TesteTudo {

	public static void main(String[] args) {

		HashSet<Peixe> peixaria = new HashSet<Peixe>();
		peixaria.add(new Peixe("Atlantico", "Azul"));
		peixaria.add(new Tubarao("Atlantico", "Azul", "Branco"));
		peixaria.add(new Peixe("Atlantico", "Azul"));
		peixaria.add(new Tubarao("Atlantico", "Azul", "Branco"));
		peixaria.add(new Peixe("Mar Atriatico","Amarelo"));
		//Interator<Peixe> interator= peixaria.iterator();
		Iterator<Peixe> iterator = peixaria.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}

	}
}
