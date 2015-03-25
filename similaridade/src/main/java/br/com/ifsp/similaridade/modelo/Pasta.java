package br.com.ifsp.similaridade.modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pasta implements Runnable {

	private String caminho;
	private static int numeroThread;
	private Thread threadPasta;
	private List<String> arquivos;
	private List<Extensao> extensoes;

	public Pasta(String caminho, List<Extensao> extensoes) {
		this.arquivos = new ArrayList<>();
		this.caminho = caminho;
		this.extensoes = extensoes;
		Pasta.numeroThread++;
	}

	public boolean isExtensao(File file) {

		for (Extensao extens : this.extensoes) {
			if (file.getName().toLowerCase()
					.endsWith(extens.getNome().toLowerCase())) {

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
			try {
				File f = new File(subpastas.get(0));
				File[] faux = f.listFiles();

				for (File file : faux) {
					if (file.isDirectory()) {
						subpastas.add(file.getAbsolutePath());
						// System.out.println(file.getAbsolutePath());

					}
					if (file.isFile()) {
						if (isExtensao(file)) {
							arquivos.add(file.getPath().toLowerCase());

							Arquivo arq = new ArquivoFactory().getArquivo(
									file.getName()
											.substring(
													file.getName().lastIndexOf(
															".") + 1)
											.toLowerCase(), file.getPath()
											.toLowerCase());
							arq.lerArquivo();
						} else {

						}

						// System.out.println(file.getAbsolutePath());
					}

				}

				subpastas.remove(0);
			} catch (NullPointerException e) {

			}
		}

		for (String ar : arquivos) {
			System.out.println(ar);

		}
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

	public List<String> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<String> arquivos) {
		this.arquivos = arquivos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caminho == null) ? 0 : caminho.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Pasta other = (Pasta) obj;
		if (caminho == null) {
			if (other.caminho != null)
				return false;
		} else if (!caminho.equals(other.caminho))
			return false;
		return true;
	}

}
