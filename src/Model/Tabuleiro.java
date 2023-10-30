package Model;

import java.util.Map;
import java.util.Random;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class Tabuleiro {
    private Map<String, Jogador> jogadores = new HashMap<>();
    private LinkedList<Jogador> ordemJogadores = new LinkedList<>();
    private Map<String, Territorio> territorios = new HashMap<>();
    private Map<String, Continente> continentes = new HashMap<>();
    
    private	HashMap<Integer, String> Objetivos = new HashMap<>();
    private String[] cores = new String[6];
    

    void adicionarJogador(Jogador jogador) {
        jogadores.put(jogador.getCor(), jogador);
        ordemJogadores.add(jogador);
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
	
	Jogador proximoJogador() {
		Jogador proximo = ordemJogadores.poll();
		ordemJogadores.add(proximo);
		return proximo;
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

    //
    // Sorteia Territórios
    //
    void sorteiaTerritorios() {
		int totalTerritorios = territorios.size();
				
		int[] sorteados = new int[totalTerritorios];
		Territorio[] arrayTerritorios = territorios.values().toArray(new Territorio[0]);
		
		// Cria deque de tamanho total
		Deque<Integer> deck = new ArrayDeque<>();
		for (int i = 0; i < totalTerritorios; i++) {
			deck.add(i);
    	}
    
		// Embaralha o deque
		shuffleDeck(deck);
		
		// Retira Sorteado
		for (int i = 0; i < totalTerritorios; i++) {
            Integer retiraSorteado = retiraSorteado(deck);
            sorteados[i] = retiraSorteado;
            proximoJogador().adicionarTerritorio(arrayTerritorios[retiraSorteado]);
        }
	}
	
    //
    // Sorteia Cores
    //
    public int[] sorteiaCores() {
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

    //
    // Sorteia Ordem dos jogadores
    //
    public int[] sorteiaOrdem(int total, int num) {
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
    
    //
    // Sorteia Objetivos
    //
    public String[] sorteiaObjetivos(int total, int num) {
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
                sorteados[i-1] = retiraSorteado;
                objs[i-1] = Objetivos.get(retiraSorteado);
            } else {
                System.out.println("Fim da lista de Sorteio");
            }
        }
		
	    return objs;
	}
	
    //
    // Sorteia Cores - Não será usado
    //
    static String[] sorteiaCores(int total, int num) {
		int[] sorteados = new int[total];
		String[] sortcores = new String[6];
		
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
                //sortcores[i-1] = cores[retiraSorteado-1];
            } else {
                System.out.println("Fim da lista de Sorteio");
            }
        }	
	    return sortcores;
	}
    
    //
    // Sorteia Dados
    //
    public int[] sorteiaDados() {
    	Random random = new Random();
    	int[] sorteados = new int[6];
    	
    	for (int i = 0; i < 6; i++) {
    		int randomNumber = random.nextInt(6) + 1;
    		sorteados[i] = randomNumber;
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

		Jogador jogador1 = new Jogador("branco");
		Jogador jogador2 = new Jogador("vermelho");
		Jogador jogador3 = new Jogador("preto");
		Jogador jogador4 = new Jogador("azul");
		adicionarJogador(jogador1);
		adicionarJogador(jogador2);
		adicionarJogador(jogador3);
		adicionarJogador(jogador4);
		sorteiaTerritorios();
	}
	{	// Bloco de Inicialização
		// Cores
		cores[0] = "Azul";
		cores[1] = "Verde";
		cores[2] = "Amarelo";
		cores[3] = "Vermelho";
		cores[4] = "Preto";
		cores[5] = "Branco";
		
		// Objetivos
		Objetivos.put(1,"Conquistar na totalidade a EUROPA, a OCEANIA e mais um terceiro.");
		Objetivos.put(2,"Conquistar na totalidade a ÁSIA e a AMÉRICA DO SUL.");
		Objetivos.put(3,"Conquistar na totalidade a EUROPA, a AMÉRICA DO SUL e mais um terceiro.");
		Objetivos.put(4,"Conquistar 18 TERRITÓRIOS e ocupar cada um deles com pelo menos dois exércitos.");
		Objetivos.put(5,"Conquistar na totalidade a ÁSIA e a ÁFRICA.");
		Objetivos.put(6,"Conquistar na totalidade a AMÉRICA DO NORTE e a ÁFRICA.");
		Objetivos.put(7,"Conquistar 24 TERRITÓRIOS à sua escolha.");
		Objetivos.put(8,"Conquistar na totalidade a AMÉRICA DO NORTE e a OCEANIA.");
		Objetivos.put(9,"Destruir totalmente OS EXÉRCITOS AZUIS.");
		Objetivos.put(10,"Destruir totalmente OS EXÉRCITOS AMARELOS.");
		Objetivos.put(11,"Destruir totalmente OS EXÉRCITOS VERMELHOS.");
		Objetivos.put(12,"Destruir totalmente OS EXÉRCITOS PRETOS.");
		Objetivos.put(13,"Destruir totalmente OS EXÉRCITOS BRANCOS.");
		Objetivos.put(14,"Destruir totalmente OS EXÉRCITOS VERDES.");
				
		
	}
}
