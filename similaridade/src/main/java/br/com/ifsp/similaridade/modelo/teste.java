package br.com.ifsp.similaridade.modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class teste {

	public static void fileTreePrinter(File initialPath, int initialDepth) {
		initialDepth++;
		if (initialPath.exists()) {
			File[] contents = initialPath.listFiles();
			for (int i = 0; i < contents.length; i++) {
				if (contents[i].isDirectory()) {
					fileTreePrinter(contents[i], initialDepth + 1);
				} else {
					char[] dpt = new char[initialDepth];
					for (int j = 0; j < initialDepth; j++) {
						dpt[j] = '+';
					}
					System.out.println(new String(dpt) + contents[i].getName());
					System.out.println(contents[i].getAbsolutePath());
				}
			}
		}
	}

	public static int fatorial(int numero) {
		System.out.println(numero);
		if (numero == 1) {
			return 1;
		}
		return numero * fatorial(numero - 1);
	}

	// Exemplo de uso:
	public static void main(String[] args) {
		Extensao ex = new Extensao("txt".toLowerCase());
		Extensao ex1 = new Extensao("pdf".toLowerCase());
		List<Extensao> extensoes = new ArrayList<>();
		extensoes.add(ex1);
		extensoes.add(ex);
		// Bibliotecas\Documentos
		Pasta p = new Pasta("C:\\Users\\aluno\\Desktop\\Nova pasta", extensoes);
		p.obterArquivos();
		// Pasta p1 = new Pasta("C:\\Users\\aluno\\", extensoes);
		// p1.obterArquivos();
		Pasta p2 = new Pasta("C:\\Users\\aluno\\Pictures", extensoes);
		p2.obterArquivos();

		while (Pasta.getNumeroThread() > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

		List<String> lista = p.getArquivos();

		for (String string : lista) {
			ArquivoTxt arqui = new ArquivoTxt(string);
			arqui.lerArquivo();
		}

	}

}
