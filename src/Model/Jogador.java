package Model;

import java.util.Map;
import java.util.HashMap;

class Jogador {
	private String cor;
	private String nome;
	private Map<String, Territorio> territorios = new HashMap<String, Territorio>();

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
}
