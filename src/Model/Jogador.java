package Model;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Jogador {
	private String cor;
	private String nome;
	private Map<String, Territorio> territorios = new HashMap<String, Territorio>();
	private List<Carta> cartas = new ArrayList<>();

	private static int trocasCarta = 0;

	Jogador(String cor, String nome) {
        this.cor = cor;
        this.nome = nome;
    }

    void adicionarTerritorio(Territorio territorio) {
        territorios.put(territorio.getNome(), territorio);
    }

    void removerTerritorio(Territorio territorio) {
        territorios.remove(territorio.getNome());
    }

    Map<String, Territorio> getTerritorios() {
        return territorios;
    }

    String getCor() {
    	return cor;
    }
    
    String getNome() {
    	return nome;
    }
    
    int exercitoPorNumeroTerritorios() {
    	return territorios.size() / 2;
    }
    
    void adicionarCarta(Carta carta) {
    	cartas.add(carta);
    }
    
    void removeCarta(int carta) {
    	cartas.remove(carta);
    }
    
    boolean podeTrocarCartas(int carta1, int carta2, int carta3) {
    	// Confere se as cartas tem o mesmo tipo
    	if (cartas.get(carta1).getTipo().equals(cartas.get(carta2).getTipo()) && cartas.get(carta1).getTipo().equals(cartas.get(carta3).getTipo())) {
    		return true;
    	}
    	
    	//Confere se todas as cartas tem tipos diferentes
    	if (!cartas.get(carta1).getTipo().equals(cartas.get(carta2).getTipo()) && !cartas.get(carta1).getTipo().equals(cartas.get(carta3).getTipo()) && !cartas.get(carta2).getTipo().equals(cartas.get(carta3).getTipo())) {
    		return true;
    	}
    	
    	return false;
    }
    
    int exercitoPorCartas(int carta1, int carta2, int carta3) {
    	// confere se possui território da carta 1
		if (territorios.containsKey(cartas.get(carta1).getTerritorio())) {
			// se possuir adiciona 2 exércitos nesse território
			territorios.get(cartas.get(carta1).getTerritorio()).ganhaExerc(2);
		}
		
    	// confere se possui território da carta 2
		if (territorios.containsKey(cartas.get(carta2).getTerritorio())) {
			// se possuir adiciona 2 exércitos nesse território
			territorios.get(cartas.get(carta2).getTerritorio()).ganhaExerc(2);
		}
		
    	// confere se possui território da carta 3
		if (territorios.containsKey(cartas.get(carta3).getTerritorio())) {
			// se possuir adiciona 2 exércitos nesse território
			territorios.get(cartas.get(carta3).getTerritorio()).ganhaExerc(2);
		}
		
		return 4 + 2*trocasCarta;
    }
    
    boolean possuiContinente(Continente continente) {
    	for (String territorio : continente.getTerritorios().keySet()) {
    		if (!territorios.containsKey(territorio)) {
    			return false;
    		}
    	}
    	return true;
    }
}
