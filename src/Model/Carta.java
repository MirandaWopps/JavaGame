package Model;

class Carta {
    enum TipoCarta {
        circulo,triangulo,quadrado,coringa;
    }
	
	private TipoCarta tipo;
	private Territorio territorio;
	
	Carta(TipoCarta tipo, Territorio territorio) {
		this.tipo = tipo;
		this.territorio = territorio;
	}

	TipoCarta getTipo() {
		return tipo;
	}

	Territorio getTerritorio() {
		return territorio;
	}
}
