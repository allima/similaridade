package br.com.ifsp.similaridade.modelo;

public class ArquivoFactory {

	// use getArquivo method to get object of type shape
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

		} else if (ArquivoType.equalsIgnoreCase("docx")) {
			return new ArquivoDocx(caminho);

		} else if (ArquivoType.equalsIgnoreCase("ppt")) {
			return new ArquivoPowerPoint(caminho);

		} else if (ArquivoType.equalsIgnoreCase("exl")) {
			return new ArquivoExcel(caminho);
		}

		return null;
	}

}
