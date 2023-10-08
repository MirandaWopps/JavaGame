package Model;

import java.util.HashMap;
import java.util.Map;

class Continente {
	private String nome;
	private Map<String, Territorio> territorios;
	private int exercBonus;
	
	Continente(String nome) {
		this.nome = nome;
		territorios = new HashMap<>();
	}

	String getNome() {
		return nome;
	}

	int getExercBonus() {
		return exercBonus;
	}

	Map<String, Territorio> getTerritorios() {
        return territorios;
	}
	
	 void adicionarTerritorio(Territorio territorio) {
	        territorios.put(territorio.getNome(), territorio);
	    }

	 void removerTerritorio(Territorio territorio) {
	        territorios.remove(territorio.getNome());
	    }
}
