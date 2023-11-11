package Model;

import java.util.HashMap;
import java.util.Map;

class Continente {
	private String nome;
	private Map<String, Territorio> territorios = new HashMap<>();
	private int exercBonus;
	private int exercPos;
	
	Continente(String nome, int exercBonus) {
		this.nome = nome;
		this.exercBonus = exercBonus;
	}

	String getNome() {
		return nome;
	}

	int getExercBonus() {
		return exercBonus;
	}

	int getExercPos() {
		return exercPos;
	}

	void setExercPos(int exercPos) {
		this.exercPos = exercPos;
	}

	void addExercPos(int exercPos) {
		this.exercPos += exercPos;
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
	 
	 boolean possuiTerritorio(Territorio territorio) {
		 return territorios.containsKey(territorio.getNome());
	 }
}
