package Model;

import java.util.Map;
import java.util.Random;
import java.util.ArrayDeque;
import java.util.Deque;
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

	public Map<String, Jogador> getJogadores() {
		return jogadores;
	}

	public Map<String, Territorio> getTerritorios() {
		return territorios;
	}

	// Embaralha as cartas a partir do algoritmo de Fisher-Yates
    private static <T> void shuffleDeck(Deque<Integer> deck) {
        Integer[] cards = deck.toArray(new Integer[0]);
        Random random = new Random();

        for (int i = cards.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }

        deck.clear();

        for (int card : cards) {
            deck.add(card);
        }
    }

    // Retira primeira carta do monte
    private static Integer retiraSorteado(Deque<Integer> deck) {
        return deck.pollFirst();
    }

	static int[] sorteiaCartas() {
		Integer total = 44;
		Integer num = 1;
		int[] sorteados = new int[total];

		// Cria deque de tamanho total
		Deque<Integer> deck = new ArrayDeque<>();
		for (int i = 1; i <= total; i++) {
			deck.add(i);
    		}

		// Shuffle the deck (optional)
		shuffleDeck(deck);

		// Retira Sorteado
		for (int i = 1; i <= num; i++) {
            Integer retiraSorteado = retiraSorteado(deck);
            if (retiraSorteado != null) {
                sorteados[i-1] = retiraSorteado;
            } else {
                System.out.println("Fim da lista de Sorteio");
            }
        }

	    return sorteados;
	}
	

	static int[] sorteiaCores() {
		Integer total = 6;
		Integer num = 1;
		int[] sorteados = new int[total];

		// Cria deque de tamanho total
		Deque<Integer> deck = new ArrayDeque<>();
		for (int i = 1; i <= total; i++) {
			deck.add(i);
    		}

		// Shuffle the deck (optional)
		shuffleDeck(deck);

		// Retira Sorteado
		for (int i = 1; i <= num; i++) {
            Integer retiraSorteado = retiraSorteado(deck);
            if (retiraSorteado != null) {
                sorteados[i-1] = retiraSorteado;
            } else {
                System.out.println("Fim da lista de Sorteio");
            }
        }

	    return sorteados;
	}

	static int[] sorteiaOrdem(int QJogs) {
		Integer total = QJogs;
		Integer num = 1;
		int[] sorteados = new int[total];

		// Cria deque de tamanho total
		Deque<Integer> deck = new ArrayDeque<>();
		for (int i = 1; i <= total; i++) {
			deck.add(i);
    	}

		// Shuffle the deck (optional)
		shuffleDeck(deck);
		
		// Retira Sorteado
		for (int i = 1; i <= num; i++) {
            Integer retiraSorteado = retiraSorteado(deck);
            if (retiraSorteado != null) {
                sorteados[i-1] = retiraSorteado;
            } else {
                System.out.println("Fim da lista de Sorteio");
            }
        }

	    return sorteados;
	}
	
	static int[] sorteiaObjetivos(int total, int num) {
		int[] sorteados = new int[total];
		String[] objs = new String[total];

		// Cria deque de tamanho total
		Deque<Integer> deck = new ArrayDeque<>();
		for (int i = 1; i <= total; i++) {
			deck.add(i);
    		}

		// Shuffle the deck (optional)
		shuffleDeck(deck);

		// Retira Sorteado
		for (int i = 1; i <= num; i++) {
            Integer retiraSorteado = retiraSorteado(deck);
            if (retiraSorteado != null) {
                //System.out.println("Rodada: " + i);
                //System.out.println("Sorteado : " + retiraSorteado);
                sorteados[i-1] = retiraSorteado;
                //objs[i-1] = ListaObjetivos[retiraSorteado];
            } else {
                System.out.println("Fim da lista de Sorteio");
            }
        }

	    return sorteados;
	}
	
	void inicializaTerritorios() {
		territorios.put("ALASCA", new Territorio("ALASCA"));
		territorios.put("CALGARY", new Territorio("CALGARY"));
		territorios.put("GROENLÂNDIA", new Territorio("GROENLÂNDIA"));
		territorios.put("VANCOUVER", new Territorio("VANCOUVER"));
		territorios.put("QUEBEC", new Territorio("QUEBEC"));
		territorios.put("CALIFORNIA", new Territorio("CALIFORNIA"));
		territorios.put("TEXAS", new Territorio("TEXAS"));
		territorios.put("NOVA YORK", new Territorio("NOVA YORK"));
		territorios.put("MEXICO", new Territorio("MEXICO"));
		territorios.put("VENEZUELA", new Territorio("VENEZUELA"));
		territorios.put("PERU", new Territorio("PERU"));
		territorios.put("BRASIL", new Territorio("BRASIL"));
		territorios.put("ARGENTINA", new Territorio("ARGENTINA"));
		territorios.put("PERTH", new Territorio("PERTH"));
		territorios.put("AUSTRALIA", new Territorio("AUSTRALIA"));
		territorios.put("NOVA ZELÂNDIA", new Territorio("NOVA ZELÂNDIA"));
		territorios.put("INDONÉSIA", new Territorio("INDONÉSIA"));
		territorios.put("ARGÉLIA", new Territorio("ARGÉLIA"));
		territorios.put("EGITO", new Territorio("EGITO"));
		territorios.put("NIGÉRIA", new Territorio("NIGÉRIA"));
		territorios.put("SOMÁLIA", new Territorio("SOMÁLIA"));
		territorios.put("ANGOLA", new Territorio("ANGOLA"));
		territorios.put("ÁFRICA DO SUL", new Territorio("ÁFRICA DO SUL"));
		territorios.put("REINO UNIDO", new Territorio("REINO UNIDO"));
		territorios.put("ESPANHA", new Territorio("ESPANHA"));
		territorios.put("FRANÇA", new Territorio("FRANÇA"));
		territorios.put("SUÉCIA", new Territorio("SUÉCIA"));
		territorios.put("POLÔNIA", new Territorio("POLÔNIA"));
		territorios.put("ITÁLIA", new Territorio("ITÁLIA"));
		territorios.put("ROMÊNIA", new Territorio("ROMÊNIA"));
		territorios.put("UCRÂNIA", new Territorio("UCRÂNIA"));
		territorios.put("ESTÔNIA", new Territorio("ESTÔNIA"));
		territorios.put("LETÔNIA", new Territorio("LETÔNIA"));
		territorios.put("TURQUIA", new Territorio("TURQUIA"));
		territorios.put("SÍRIA", new Territorio("SÍRIA"));
		territorios.put("JORDÂNIA", new Territorio("JORDÂNIA"));
		territorios.put("ARÁBIA SAUDITA", new Territorio("ARÁBIA SAUDITA"));
		territorios.put("IRAQUE", new Territorio("IRAQUE"));
		territorios.put("IRÃ", new Territorio("IRÃ"));
		territorios.put("PAQUISTÃO", new Territorio("PAQUISTÃO"));
		territorios.put("RÚSSIA", new Territorio("RÚSSIA"));
		territorios.put("SIBÉRIA", new Territorio("SIBÉRIA"));
		territorios.put("CAZAQUISTÃO", new Territorio("CAZAQUISTÃO"));
		territorios.put("MONGÓLIA", new Territorio("MONGÓLIA"));
		territorios.put("CHINA", new Territorio("CHINA"));
		territorios.put("COREIA DO NORTE", new Territorio("COREIA DO NORTE"));
		territorios.put("COREIA DO SUL", new Territorio("COREIA DO SUL"));
		territorios.put("ÍNDIA", new Territorio("ÍNDIA"));
		territorios.put("BANGLADESH", new Territorio("BANGLADESH"));
		territorios.put("TAILÂNDIA", new Territorio("TAILÂNDIA"));
		territorios.put("JAPÃO", new Territorio("JAPÃO"));
		Jogador jogador = new Jogador("branco","a");
		for (Territorio territorio : territorios.values()) {
			jogador.adicionarTerritorio(territorio);
		}
		adicionarJogador(jogador);
	}
}
