package Model;

class Carta {
	private String tipo;
	private String territorio;
	
	Carta(String tipo, String territorio) {
		this.tipo = tipo;
		this.territorio = territorio;
	}

	String getTipo() {
		return tipo;
	}

	String getTerritorio() {
		return territorio;
	}
}
