package br.com.ifsp.similaridade.hashcode;

public class Cadeira {

	private int qtdPerna;
	private int color;
	private String material;

	public Cadeira(int qtdPerna, int color, String material) {

		this.qtdPerna = qtdPerna;
		this.color = color;
		this.material = material;
	}

	public int getQtdPerna() {
		return qtdPerna;
	}

	public void setQtdPerna(int qtdPerna) {
		this.qtdPerna = qtdPerna;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Cadeira [qtdPerna=" + qtdPerna + ", color=" + color
				+ ", material=" + material + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + color;
		result = prime * result
				+ ((material == null) ? 0 : material.hashCode());
		result = prime * result + qtdPerna;
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
		Cadeira other = (Cadeira) obj;
		if (color != other.color)
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (qtdPerna != other.qtdPerna)
			return false;
		return true;
	}

}
