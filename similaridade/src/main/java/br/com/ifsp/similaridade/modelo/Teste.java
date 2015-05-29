package br.com.ifsp.similaridade.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Teste {

	public static void main(String[] args) {
		Extensao ex = new Extensao("txt".toLowerCase());
		Extensao ex1 = new Extensao("pdf".toLowerCase());
		Extensao ex2 = new Extensao("doc".toLowerCase());
		Extensao ex3 = new Extensao("docx".toLowerCase());
		List<Extensao> extensoes = new ArrayList<>();
		extensoes.add(ex);
		extensoes.add(ex1);
		extensoes.add(ex2);
		extensoes.add(ex3);
		MapaGeral mgeral = new MapaGeral();

		Pasta p = new Pasta("C:\\Users\\aluno\\Desktop\\Nova pasta\\",
				extensoes);

		//
		p.obterArquivos();

		while (Pasta.getNumeroThread() > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

		List<Arquivo> listArquivos = p.getListaArquivos();

		for (Arquivo arquivo : listArquivos) {

			arquivo.lerArquivo();

		}

		for (Arquivo arquivo : listArquivos) {

			mgeral.Lermapas(arquivo.getMapa());

		}

		mgeral.IDF(listArquivos.size());

//		Set<String> keys = mgeral.getMapageral().keySet();
//		for (final String key : keys) {
//			// System.out.println("Key: " + key);
//			Integer value = mgeral.getMapageral().get(key);
//			System.out.println(key + " = " + value);
//		}

	}

}
