package Model;

import java.util.Map;
import java.util.Random;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

class Tabuleiro {
    private Map<String, Jogador> jogadores = new HashMap<>();
    private Map<String, Territorio> territorios = new HashMap<>();
    private Map<String, Continente> continentes = new HashMap<>();

    void adicionarJogador(Jogador jogador) {
        jogadores.put(jogador.getCor(), jogador);
    }

    void adicionarTerritorio(Territorio territorio, Continente continente) {
        territorios.put(territorio.getNome(), territorio);
		continente.adicionarTerritorio(territorio);
    }

    void adicionarContinente(Continente continente) {
        continentes.put(continente.getNome(), continente);
    }

	Map<String, Jogador> getJogadores() {
		return jogadores;
	}

	Map<String, Territorio> getTerritorios() {
		return territorios;
	}
	
	Jogador getJogador(String cor) {
		return jogadores.get(cor);
	}
	
	Territorio getTerritorio(String territorio) {
		return territorios.get(territorio);
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
		// América do Norte	
		Continente americaDoNorte = new Continente("AMÉRICA DO NORTE", 5);
		adicionarContinente(americaDoNorte);
		adicionarTerritorio(new Territorio("ALASCA", new ArrayList<>(Arrays.asList("CALGARY", "VANCOUVER", "SIBÉRIA"))), americaDoNorte);
		adicionarTerritorio(new Territorio("CALGARY", new ArrayList<>(Arrays.asList("ALASCA", "VANCOUVER", "GROENLÂNDIA"))), americaDoNorte);
		adicionarTerritorio(new Territorio("GROENLÂNDIA", new ArrayList<>(Arrays.asList("CALGARY", "QUEBEC", "REINO UNIDO"))), americaDoNorte);
		adicionarTerritorio(new Territorio("VANCOUVER", new ArrayList<>(Arrays.asList("CALIFORNIA", "TEXAS", "QUEBEC", "CALGARY", "ALASCA"))), americaDoNorte);
		adicionarTerritorio(new Territorio("QUEBEC", new ArrayList<>(Arrays.asList("TEXAS", "NOVA YORK", "VANCOUVER", "GROENLÂNDIA"))), americaDoNorte);
		adicionarTerritorio(new Territorio("CALIFORNIA", new ArrayList<>(Arrays.asList("TEXAS", "MÉXICO", "VANCOUVER"))), americaDoNorte);
		adicionarTerritorio(new Territorio("TEXAS", new ArrayList<>(Arrays.asList("MÉXICO", "CALIFORNIA", "NOVA YORK", "VANCOUVER", "QUEBEC"))), americaDoNorte);
		adicionarTerritorio(new Territorio("NOVA YORK", new ArrayList<>(Arrays.asList("TEXAS", "QUEBEC"))), americaDoNorte);
		adicionarTerritorio(new Territorio("MEXICO", new ArrayList<>(Arrays.asList("VENEZUELA", "CALIFORNIA", "TEXAS"))), americaDoNorte);

		// América do Sul
		Continente americaDoSul = new Continente("AMÉRICA DO SUL", 2);
		adicionarContinente(americaDoSul);
		adicionarTerritorio(new Territorio("VENEZUELA", new ArrayList<>(Arrays.asList("BRASIL", "PERU", "MÉXICO"))), americaDoSul);
		adicionarTerritorio(new Territorio("PERU", new ArrayList<>(Arrays.asList("BRASIL", "ARGENTINA", "VENEZUELA"))), americaDoSul);
		adicionarTerritorio(new Territorio("BRASIL", new ArrayList<>(Arrays.asList("ARGENTINA", "VENEZUELA", "PERU", "NIGÉRIA"))), americaDoSul);
		adicionarTerritorio(new Territorio("ARGENTINA", new ArrayList<>(Arrays.asList("PERU", "BRASIL"))), americaDoSul);

		// Oceania
		Continente oceania = new Continente("OCEANIA", 2);
		adicionarContinente(oceania);
		adicionarTerritorio(new Territorio("PERTH", new ArrayList<>(Arrays.asList("AUSTRALIA"))), oceania);
		adicionarTerritorio(new Territorio("AUSTRALIA", new ArrayList<>(Arrays.asList("PERTH", "INDONÉSIA", "NOVA ZELÂNDIA"))), oceania);
		adicionarTerritorio(new Territorio("NOVA ZELÂNDIA", new ArrayList<>(Arrays.asList("AUSTRALIA", "INDONÉSIA"))), oceania);
		adicionarTerritorio(new Territorio("INDONÉSIA", new ArrayList<>(Arrays.asList("ÍNDIA", "BANGLADESH", "AUSTRÁLIA", "NOVA ZELÂNDIA"))), oceania);

		// África
		Continente africa = new Continente("ÁFRICA", 3);
		adicionarContinente(africa);
		adicionarTerritorio(new Territorio("ARGÉLIA", new ArrayList<>(Arrays.asList("NIGÉRIA", "ESPANHA", "ITÁLIA", "EGITO"))), africa);
		adicionarTerritorio(new Territorio("EGITO", new ArrayList<>(Arrays.asList("ARGÉLIA", "NIGÉRIA", "SOMÁLIA", "JORDÂNIA", "ROMÊNIA"))), africa);
		adicionarTerritorio(new Territorio("NIGÉRIA", new ArrayList<>(Arrays.asList("ARGÉLIA", "EGITO", "SOMÁLIA", "ANGOLA", "BRASIL"))), africa);
		adicionarTerritorio(new Territorio("SOMÁLIA", new ArrayList<>(Arrays.asList("ÁFRICA DO SUL", "ANGOLA", "NIGÉRIA", "EGITO"))), africa);
		adicionarTerritorio(new Territorio("ANGOLA", new ArrayList<>(Arrays.asList("NIGÉRIA", "SOMÁLIA", "ÁFRICA DO SUL"))), africa);
		adicionarTerritorio(new Territorio("ÁFRICA DO SUL", new ArrayList<>(Arrays.asList("ANGOLA", "SOMÁLIA"))), africa);

		// Europa
		Continente europa = new Continente("EUROPA", 5);
		adicionarContinente(europa);
		adicionarTerritorio(new Territorio("REINO UNIDO", new ArrayList<>(Arrays.asList("FRANÇA", "GROENLÂNDIA"))), europa);
		adicionarTerritorio(new Territorio("ESPANHA", new ArrayList<>(Arrays.asList("ARGÉLIA", "FRANÇA"))), europa);
		adicionarTerritorio(new Territorio("FRANÇA", new ArrayList<>(Arrays.asList("ESPANHA", "ITÁLIA", "REINO UNIDO", "SUÉCIA"))), europa);
		adicionarTerritorio(new Territorio("SUÉCIA", new ArrayList<>(Arrays.asList("FRANÇA", "ITÁLIA", "ESTÔNIA", "LETÔNIA"))), europa);
		adicionarTerritorio(new Territorio("POLÔNIA", new ArrayList<>(Arrays.asList("ITÁLIA", "ROMÊNIA", "UCRÂNIA", "LETÔNIA"))), europa);
		adicionarTerritorio(new Territorio("ITÁLIA", new ArrayList<>(Arrays.asList("ARGÉLIA", "FRANÇA", "SUÉCIA", "POLÔNIA", "ROMÊNIA"))), europa);
		adicionarTerritorio(new Territorio("ROMÊNIA", new ArrayList<>(Arrays.asList("ITÁLIA", "EGITO", "UCRÂNIA", "POLÔNIA"))), europa);
		adicionarTerritorio(new Territorio("UCRÂNIA", new ArrayList<>(Arrays.asList("POLÔNIA", "ROMÊNIA", "LETÔNIA", "TURQUIA"))), europa);

		// Ásia
		Continente asia = new Continente("ÁSIA", 7);
		adicionarContinente(asia);
		adicionarTerritorio(new Territorio("ESTÔNIA", new ArrayList<>(Arrays.asList("SUÉCIA", "LETÔNIA", "RÚSSIA"))), asia);
		adicionarTerritorio(new Territorio("LETÔNIA", new ArrayList<>(Arrays.asList("ESTÔNIA", "RÚSSIA", "CAZAQUISTÃO", "TURQUIA", "UCRÂNIA", "POLÔNIA", "SUÉCIA"))), asia);
		adicionarTerritorio(new Territorio("TURQUIA", new ArrayList<>(Arrays.asList("LETÔNIA", "CAZAQUISTÃO", "PAQUISTÃO", "SÍRIA", "UCRÂNIA", "CHINA"))), asia);
		adicionarTerritorio(new Territorio("SÍRIA", new ArrayList<>(Arrays.asList("TURQUIA", "PAQUISTÃO", "IRÃ", "IRAQUE", "JORDÂNIA"))), asia);
		adicionarTerritorio(new Territorio("JORDÂNIA", new ArrayList<>(Arrays.asList("EGITO", "SÍRIA", "IRAQUE", "ARÁBIA SAUDITA"))), asia);
		adicionarTerritorio(new Territorio("ARÁBIA SAUDITA", new ArrayList<>(Arrays.asList("SOMÁLIA", "JORDÂNIA", "IRAQUE"))), asia);
		adicionarTerritorio(new Territorio("IRAQUE", new ArrayList<>(Arrays.asList("JORDÂNIA", "ARÁBIA SAUDITA", "IRÃ", "SÍRIA"))), asia);
		adicionarTerritorio(new Territorio("IRÃ", new ArrayList<>(Arrays.asList("SÍRIA", "PAQUISTÃO", "IRAQUE"))), asia);
		adicionarTerritorio(new Territorio("PAQUISTÃO", new ArrayList<>(Arrays.asList("TURQUIA", "CHINA", "ÍNDIA", "IRÃ", "SÍRIA"))), asia);
		adicionarTerritorio(new Territorio("RÚSSIA", new ArrayList<>(Arrays.asList("ESTÔNIA", "SIBÉRIA", "CAZAQUISTÃO"))), asia);
		adicionarTerritorio(new Territorio("SIBÉRIA", new ArrayList<>(Arrays.asList("RÚSSIA", "ALASCA", "CAZAQUISTÃO"))), asia);
		adicionarTerritorio(new Territorio("CAZAQUISTÃO", new ArrayList<>(Arrays.asList("RÚSSIA", "SIBÉRIA", "MONGÓLIA", "JAPÃO", "CHINA", "TURQUIA", "LETÔNIA"))), asia);
		adicionarTerritorio(new Territorio("MONGÓLIA", new ArrayList<>(Arrays.asList("CAZAQUISTÃO", "JAPÃO", "CHINA"))), asia);
		adicionarTerritorio(new Territorio("CHINA", new ArrayList<>(Arrays.asList("CAZAQUISTÃO", "MONGÓLIA", "CORÉIA DO NORTE", "CORÉIA DO SUL", "ÍNDIA", "PAQUISTÃO", "TURQUIA"))), asia);
		adicionarTerritorio(new Territorio("COREIA DO NORTE", new ArrayList<>(Arrays.asList("CHINA", "JAPÃO", "COREIA DO SUL"))), asia);
		adicionarTerritorio(new Territorio("COREIA DO SUL", new ArrayList<>(Arrays.asList("CHINA", "COREIA DO NORTE", "BANGLADESH", "TAILÂNDIA", "ÍNDIA"))), asia);
		adicionarTerritorio(new Territorio("ÍNDIA", new ArrayList<>(Arrays.asList("PAQUISTÃO", "CHINA", "COREIA DO SUL", "BANGLADESH", "INDONÉSIA"))), asia);
		adicionarTerritorio(new Territorio("BANGLADESH", new ArrayList<>(Arrays.asList("COREIA DO SUL", "TAILÂNDIA", "INDONÉSIA", "ÍNDIA"))), asia);
		adicionarTerritorio(new Territorio("TAILÂNDIA", new ArrayList<>(Arrays.asList("COREIA DO SUL", "BANGLADESH"))), asia);
		adicionarTerritorio(new Territorio("JAPÃO", new ArrayList<>(Arrays.asList("CAZAQUISTÃO", "MONGÓLIA", "COREIA DO NORTE"))), asia);

		Jogador jogador = new Jogador("branco","a");
		for (Territorio territorio : territorios.values()) {
			jogador.adicionarTerritorio(territorio);
		}
		adicionarJogador(jogador);
	}
}
