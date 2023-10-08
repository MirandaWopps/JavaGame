package Model;

import java.util.Map;
import java.util.HashMap;

class Tabuleiro {
    private Map<String, Jogador> jogadores = new HashMap<>();
    private Map<String, Territorio> territorios = new HashMap<>();
    private Map<String, Continente> continentes = new HashMap<>();
    
    void adicionarJogador(Jogador jogador) {
        jogadores.put(jogador.getCor(), jogador);
    }

    void adicionarTerritorio(Territorio territorio) {
        territorios.put(territorio.getNome(), territorio);
    }
    
    void adicionarContinente(Continente continente) {
        continentes.put(continente.getNome(), continente);
    }
}
