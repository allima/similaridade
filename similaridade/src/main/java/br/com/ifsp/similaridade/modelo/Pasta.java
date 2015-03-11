package br.com.ifsp.similaridade.modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pasta implements Runnable {

	private String caminho;
	private static int numeroThread;
	private Thread threadPasta;
	private List<Arquivo> arquivos;
	private List<Extensao> extensoes;

	public Pasta(String caminho, List<Extensao> extensoes) {
		this.arquivos = new ArrayList<>();
		this.caminho = caminho;
		this.extensoes = extensoes;
		Pasta.numeroThread++;
	}

	public Pasta(String caminho) {

		this.caminho = caminho;
		this.arquivos = new ArrayList<>();

	}

	public boolean isExtensao(File file) {

		String extensao = file.getName()
				.substring(file.getName().lastIndexOf(".") + 1).toLowerCase();

		for (Extensao extens : this.extensoes) {
			if (extens.getNome().equals(extensao)) {

				return true;

			} else {

			}

		}
		return false;

	}

	public void obterArquivos() {
		
		this.threadPasta = new Thread(this);
		this.threadPasta.start();
		
		Pasta.numeroThread--;
	}

	@Override
	public void run() {
		
		List<String> subpastas = new ArrayList<>();
		subpastas.add(caminho);

		while (subpastas.size() > 0) {
try{			
			File f = new File(subpastas.get(0));
			File[] faux = f.listFiles();

			for (File file : faux) {
				if (file.isDirectory()) {
					subpastas.add(file.getAbsolutePath());
					System.out.println(file.getAbsolutePath());

				}
				if (file.isFile()) {
					if (isExtensao(file)) {

						arquivos.add(new Arquivo(file.getAbsolutePath(), file
								.getName()));
					} else {

					}

					System.out.println(file.getAbsolutePath());
				}

			}

			subpastas.remove(0);
		}catch(NullPointerException e){
			
			
		}
		}
	}

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}

	public List<Extensao> getExtensoes() {
		return extensoes;
	}

	public void setExtensoes(List<Extensao> extensoes) {
		this.extensoes = extensoes;
	}

	public Thread getThreadPasta() {
		return threadPasta;
	}

	public void setThreadPasta(Thread threadPasta) {
		this.threadPasta = threadPasta;
	}

	public static int getNumeroThread() {
		return numeroThread;
	}

	public static void setNumeroThread(int numeroThread) {
		Pasta.numeroThread = numeroThread;
	}

}
