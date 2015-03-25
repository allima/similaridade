package br.com.ifsp.similaridade.modelo;

public class ArquivoFactory {

	// use getShape method to get object of type shape
	public Arquivo getArquivo(String ArquivoType, String caminho) {
		if (ArquivoType == null) {
			return null;
		}
		if (ArquivoType.equalsIgnoreCase("txt")) {
			return new ArquivoTxt(caminho);

		} else if (ArquivoType.equalsIgnoreCase("doc")) {
			return new ArquivoDoc(caminho);

		} else if (ArquivoType.equalsIgnoreCase("pdf")) {
			return new ArquivoPdf(caminho);
		}

		return null;
	}

}
