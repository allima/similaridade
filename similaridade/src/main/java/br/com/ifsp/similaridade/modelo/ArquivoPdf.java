package br.com.ifsp.similaridade.modelo;

import java.io.IOException;
import java.text.Normalizer;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class ArquivoPdf extends Arquivo {
	
	public ArquivoPdf(String arquivo){
		super(arquivo);
	}
	
	@Override
	public void lerArquivo(){
		try{
			PdfReader filePdf = new PdfReader(this.getCaminho());
            int numPaginas = filePdf.getNumberOfPages() + 1;
            
            for(int i=1; i < numPaginas; i++){
                String pagina = PdfTextExtractor.getTextFromPage(filePdf, i);
                
                pagina = Normalizer.normalize(pagina, Normalizer.Form.NFD);
                pagina = pagina.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase(); 
				Pattern p = Pattern.compile("(\\d+)|([a-z]+)"); 
				Matcher m = p.matcher(pagina);
				
				while(m.find()) { 
					String token = m.group();
					Integer freq = getMapa().get(token);
					if (freq != null) { 
						getMapa().put(token, freq+1);
					} else { 
						getMapa().put(token,1); 
					} 
				} 
				 
		 	    
				for (Entry<String, Integer> entry : getMapa().entrySet()) {
					System.out.println(entry.getKey()); 
					System.out.println("--> freq=" + entry.getValue() + "\n");
				}
                
                //System.out.println(pagina);
            }
            


		}catch (IOException e) { 
			System.err.println("Erro na abertura do arquivo: " + e.getMessage()); 
		}
	}

	@Override
	public void PreecheMapa(String[] palavra) {
		// TODO Auto-generated method stub
		
	}
}
