package br.com.ifsp.similaridade.modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivoTxt extends Arquivo {

	public ArquivoTxt(String caminho) {
		super(caminho);
		// System.out.println("txt");

	}

	@Override
	public void lerArquivo() {
		// System.out.println("teste");
		try {
			// FileReader arq = new FileReader(this.getCaminho());

			BufferedReader lerArq = new BufferedReader(new InputStreamReader(
					new FileInputStream(this.getCaminho()), "UTF-8"));

			String linha = lerArq.readLine(); // lê a primeira linha
			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto
			while (linha != null) {
				// System.out.println(linha);
				linha.replaceAll("\\,|\\.|\t|", "");

				PreecheMapa(linha.split(" "));

				linha = lerArq.readLine(); // lê da segunda até a última linha
			}
			lerArq.close();
			// arq.close();
		} catch (IOException e) {
			System.err.println("Erro na abertura do arquivo:" + e.getMessage());
		}

	}

	@Override
	public void PreecheMapa(String[] palavra) {
		for (String string : palavra) {
			System.out.println(string);
		}

	}
}
