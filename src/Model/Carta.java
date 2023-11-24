package Model;

class Carta {
    enum TipoCarta {
        circulo,triangulo,quadrado,coringa;  // tipo da carta    
    }                                        // circulo, triangulo,  quadrado, coringa
	
	private TipoCarta tipo;    // e algum daqueles ali em cima
	private Territorio territorio;  // territorio tem nome
	
	// Constroi carta
	Carta(TipoCarta tipo, Territorio territorio) {
		this.tipo = tipo;
		this.territorio = territorio;
	}

	// Adquire nome da carta
	Territorio getTerritorio() {
		return territorio;
	}
	
	// Adquire tipo carta
	TipoCarta getTipo() { 
		return tipo;
	}
}


