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
	private String eliminador = null;
	private Objetivo objetivo;
	private int exerc = 0;
	private Map<String, Territorio> territorios = new HashMap<>();
	private List<Carta> cartas = new ArrayList<>();
	private boolean recebeCarta = false;

	private static int trocasCarta = 0;

	Jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

	static Jogador CriaJogs(String cor, String nome) {
		if (qtdeJogadores >= limiteJogadores) {
			return null;
        }
		qtdeJogadores++;
        Jogador jog = new Jogador(cor, nome);
        return jog;
	}

	 static int qtdeJogs() {
	    return qtdeJogadores;
	 }

    void adicionarTerritorio(Territorio territorio) {
        territorios.put(territorio.getNome(), territorio);
        Tabuleiro.getTabuleiro().notificaMudanca();
    }

    void removerTerritorio(Territorio territorio) {
        territorios.remove(territorio.getNome());
        Tabuleiro.getTabuleiro().notificaMudanca();
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

	String getEliminador() {
		return eliminador;
	}
	
	Objetivo getObjetivo() {
		return objetivo;
	}

	// pega cartas
	List<Carta> getCartas() {
        return cartas;
    }

	boolean getRecebeCarta() {
		return recebeCarta;
	}

	void setRecebeCarta(boolean recebeCarta) {
		this.recebeCarta = recebeCarta;
	}

	int getExerc() {
		return exerc;
	}

	void setEliminador(String cor) {
		eliminador = cor;
	}
	
	void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}
	
	boolean testaObjetivo() {
		return objetivo.concluido(this);
	}
    
    boolean possuiTerritorio(Territorio territorio) {
    	return territorios.containsKey(territorio.getNome());
    }

    void exercitoPorNumeroTerritorios() {
    	exerc += territorios.size()/2;
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

    void exercitoPorCartas(int carta1, int carta2, int carta3) {
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

		// Aumenta o número de trocas de cartas
		trocasCarta++;

		// Aumenta o número de exércitos do jogador
		exerc += 4 + 2 * trocasCarta;
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

	void exercPosicionado(int qtdExerc) {
		exerc -= qtdExerc;
	}
}
