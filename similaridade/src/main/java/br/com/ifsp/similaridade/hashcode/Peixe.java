package br.com.ifsp.similaridade.hashcode;

public class Peixe {

	private String ambiente;
	private String corDorso;

	public Peixe(String ambiente, String corDorso) {

		this.ambiente = ambiente;
		this.corDorso = corDorso;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public String getCorDorso() {
		return corDorso;
	}

	public void setCorDorso(String corDorso) {
		this.corDorso = corDorso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ambiente == null) ? 0 : ambiente.hashCode());
		result = prime * result
				+ ((corDorso == null) ? 0 : corDorso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peixe other = (Peixe) obj;
		if (ambiente == null) {
			if (other.ambiente != null)
				return false;
		} else if (!ambiente.equals(other.ambiente))
			return false;
		if (corDorso == null) {
			if (other.corDorso != null)
				return false;
		} else if (!corDorso.equals(other.corDorso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Peixe [ambiente=" + ambiente + ", corDorso=" + corDorso + "]";
	}

}
