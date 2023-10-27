package Model;

import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Jogador {
	private static int qtdeJogadores = 0;
    private static final int limiteJogadores = 6; 
	
	private String cor;
	private String nome;
	private Map<String, Territorio> territorios = new HashMap<>();
	private List<Carta> cartas = new ArrayList<>();

	private static int trocasCarta = 0;

	Jogador(String cor, String nome) {
        this.cor = cor;
        this.nome = nome;
    }

	static Jogador CriaJogs(String cor, String nome) {
		if (qtdeJogadores >= limiteJogadores) {
			//System.out.println("Quantidade máxima de jogadores atingida: " + limiteJogadores);
			return null;
        }
		qtdeJogadores++;
        Jogador jog = new Jogador(cor, nome);
        //System.out.println("Nome: " + nome + "  Cor: " + cor + "  Qtde Jogadores: "+ qtdeJogadores);
        return jog;
	}

	 static int qtdeJogs() {
	    	return qtdeJogadores;
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
    
    boolean possuiTerritorio(Territorio territorio) {
    	return territorios.containsKey(territorio.getNome());
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
    
    boolean precisaTrocarCartas() {
    	if (cartas.size() < 5) {
    		return false;
    	}
    	return true;
    }

    boolean podeTrocarCartas(int carta1, int carta2, int carta3) {
        Carta.TipoCarta tipo1 = cartas.get(carta1).getTipo();
        Carta.TipoCarta tipo2 = cartas.get(carta2).getTipo();
        Carta.TipoCarta tipo3 = cartas.get(carta3).getTipo();
        
        // Pode trocar porque pelo menos uma carta é um coringa
        if (tipo1 == Carta.TipoCarta.coringa || tipo2 == Carta.TipoCarta.coringa || tipo3 == Carta.TipoCarta.coringa) {
        	return true;
        }
        
    	// Pode trocar porque todas as cartas têm o mesmo tipo
    	if (tipo1 == tipo2 && tipo1 == tipo3) {
    		return true;
    	}

    	// Pode trocar porque todas as cartas têm tipos diferentes
    	if (tipo1 != tipo2 && tipo1 != tipo3 && tipo2 != tipo3) {
    		return true;
    	}
    	
    	return false;
    }

    int exercitoPorCartas(int carta1, int carta2, int carta3) {
    	Territorio territorio1 = cartas.get(carta1).getTerritorio();
    	Territorio territorio2 = cartas.get(carta2).getTerritorio();
    	Territorio territorio3 = cartas.get(carta3).getTerritorio();
    	List<Carta> cartasTrocadas = new ArrayList<>(Arrays.asList(cartas.get(carta1),cartas.get(carta2),cartas.get(carta3)));
    	
    	// Verifica se o jogador possui o território correspondente à carta 1
		if (territorio1 != null && territorios.containsKey(territorio1.getNome())) {
			// Se o jogador possuir o território correspondente à carta 1, adiciona 2 exércitos a esse território
			territorios.get(territorio1.getNome()).ganhaExerc(2);
		}

		// Verifica se o jogador possui o território correspondente à carta 2
		if (territorio2 != null && territorios.containsKey(territorio2.getNome())) {
			// Se o jogador possuir o território correspondente à carta 2, adiciona 2 exércitos a esse território
			territorios.get(territorio2.getNome()).ganhaExerc(2);
		}
		
		// Verifica se o jogador possui o território correspondente à carta 3
		if (territorio3 != null && territorios.containsKey(territorio3.getNome())) {
			// Se o jogador possuir o território correspondente à carta 3, adiciona 2 exércitos a esse território
			territorios.get(territorio3.getNome()).ganhaExerc(2);
		}
		
		// Remove as cartas usadas na troca
		cartas.removeAll(cartasTrocadas);

		return 4 + 2*trocasCarta++;
    }

    boolean possuiContinente(Continente continente) {
    	// Itera sobre os territórios do continente, conferindo se o jogador possui eles
    	for (String territorio : continente.getTerritorios().keySet()) {
    		if (!territorios.containsKey(territorio)) {
    			return false;
    		}
    	}
    	return true;
    }
}
