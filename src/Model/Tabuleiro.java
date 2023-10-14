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
}
