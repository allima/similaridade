package br.com.ifsp.similaridade.modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ArquivoDocx extends Arquivo {

	public ArquivoDocx(String caminho) {
		super(caminho);

	}

	@Override
	public void lerArquivo() {
		try {
			XWPFDocument fileDocx = new XWPFDocument(new FileInputStream(
					this.getCaminho()));
			XWPFWordExtractor arqWordx = new XWPFWordExtractor(fileDocx);
			String wordxText = arqWordx.getText();

			wordxText = Normalizer.normalize(wordxText, Normalizer.Form.NFD);
			wordxText = wordxText.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
			Pattern p = Pattern.compile("(\\d+)|([a-z]+)");
			Matcher m = p.matcher(wordxText);

			while (m.find()) {
				String token = m.group();
				Integer freq = getMapa().get(token);
				if (freq != null) {
					getMapa().put(token, freq + 1);
				} else {
					getMapa().put(token, 1);
				}
			}

			for (Entry<String, Integer> entry : getMapa().entrySet()) {
				System.out.println(entry.getKey());
				System.out.println("--> freq=" + entry.getValue() + "\n");
			}

			// System.out.println(wordxText);

			arqWordx.close();
		} catch (IOException e) {
			System.err
					.println("Erro na abertura do arquivo: " + e.getMessage());
		}

	}

	@Override
	public void PreecheMapa(String[] palavra) {
		// TODO Auto-generated method stub

	}

}
