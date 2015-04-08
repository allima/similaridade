package br.com.ifsp.similaridade.modelo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArquivoTxt extends Arquivo {

	public ArquivoTxt(String caminho) {
		super(caminho);
		
	}

	@Override
	public void lerArquivo() {
		try {
			BufferedReader lerArq = new BufferedReader(new InputStreamReader(
					new FileInputStream(this.getCaminho()), "UTF-8"));
			String linha = lerArq.readLine();

			while (linha != null) {
				linha = Normalizer.normalize(linha, Normalizer.Form.NFD);
				linha = linha.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
				// System.out.println(linha);
				Pattern p = Pattern.compile("(\\d+)|([a-z]+)");
				Matcher m = p.matcher(linha);

				while (m.find()) {
					String palavra = m.group();
					Integer freq = getMapa().get(palavra);
					if (freq != null) {
						getMapa().put(palavra, freq + 1);
					} else {
						getMapa().put(palavra, 1);
					}
				}

				linha = lerArq.readLine();
			}
			for (Entry<String, Integer> entry : getMapa().entrySet()) {
				System.out.println(entry.getKey());
				System.out.println("--> freq=" + entry.getValue() + "\n");
			}

			lerArq.close();
			// arq.close();
		} catch (IOException e) {
			System.err
					.println("Erro na abertura do arquivo: " + e.getMessage());
		}
	}

	@Override
	public void PreecheMapa(String[] palavra) {
		for (String string : palavra) {
			System.out.println(string);
		}

	}
}
