package br.com.ifsp.similaridade.modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoTxt extends Arquivo {

	public ArquivoTxt(String caminho) {
		super(caminho);
		//System.out.println("txt");

	}

	@Override
	public void lerArquivo() {
		//System.out.println("teste");
		try {
			FileReader arq = new FileReader(this.getCaminho());
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha
			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto
			while (linha != null) {
				System.out.printf("%s\n", linha);

				linha = lerArq.readLine(); // lê da segunda até a última linha
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

	}
}
