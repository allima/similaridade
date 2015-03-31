package br.com.ifsp.similaridade.modelo;

public class ArquivoDoc extends Arquivo {

	public ArquivoDoc(String caminho) {
		super(caminho);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void lerArquivo() {
		try {
			//só doc não docx 
			POIFSFileSystem poifs = new POIFSFileSystem(new FileInputStream(this.getCaminho()));  
    			WordExtractor extractor = new WordExtractor(poifs);  
			String wordText = extractor.getText();
			
		//	BufferedReader lerArq = new BufferedReader(new InputStreamReader(
		//			new FileInputStream(this.getCaminho()), "UTF-8"));
		//	String linha = lerArq.readLine();

		//	while (linha != null) {
				wordText = Normalizer.normalize(linha, Normalizer.Form.NFD);
				wordText = wordText.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
				// System.out.println(linha);
				Pattern p = Pattern.compile("(\\d+)|([a-z]+)");
				Matcher m = p.matcher(wordText);

				while (m.find()) {
					String palavra = m.group();
					Integer freq = getMapa().get(palavra);
					if (freq != null) {
						getMapa().put(palavra, freq + 1);
					} else {
						getMapa().put(palavra, 1);
					}
				}

			//	linha = lerArq.readLine();
			//}
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
		// TODO Auto-generated method stub
		
	}

}
