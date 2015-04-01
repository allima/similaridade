package br.com.ifsp.similaridade.modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.Normalizer;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ArquivoPowerPoint extends Arquivo {

	public ArquivoPowerPoint(String arquivo) {
		super(arquivo);
		lerArquivo();
	}

	@Override
	public void lerArquivo() {
		try {
			POIFSFileSystem fileDoc = new POIFSFileSystem(new FileInputStream(
					this.getCaminho()));
			PowerPointExtractor arqWord = new PowerPointExtractor(fileDoc);

			String wordText = arqWord.getText();

			wordText = Normalizer.normalize(wordText, Normalizer.Form.NFD);
			wordText = wordText.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
			Pattern p = Pattern.compile("(\\d+)|([a-z]+)");
			Matcher m = p.matcher(wordText);

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

			// System.out.println(wordText);

			arqWord.close();

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
