package Model;

import java.util.Map;
import java.util.Random;

import Model.Carta.TipoCarta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Tabuleiro implements Observable {
    private Map<String, Jogador> jogadores = new HashMap<>(); // 
    private LinkedList<Jogador> ordemJogadores = new LinkedList<>(); // grava a ordem dos jogadores 
    private Map<String, Territorio> territorios = new HashMap<>(); //
    private Map<String, Continente> continentes = new HashMap<>(); //
	private Deque<Carta> cartas = new ArrayDeque<>();  //
	List<Observer> lob = new ArrayList<Observer>(); //
	private static Tabuleiro tabuleiro; // 

	private Tabuleiro() { 
	}

	static Tabuleiro getTabuleiro() {
		if (tabuleiro == null)
			tabuleiro = new Tabuleiro();
		return tabuleiro;
	}

    void adicionarJogador(Jogador jogador) {
        jogadores.put(jogador.getCor(), jogador);
        ordemJogadores.add(jogador);
    }

    void adicionarTerritorio(Territorio territorio, Continente continente, TipoCarta tipo) {
		// Adiciona o território ao tabuleiro
        territorios.put(territorio.getNome(), territorio);
		// Adiciona o território ao continente
		continente.adicionarTerritorio(territorio);
		// Adiciona a carta ao tabuleiro
		adicionarCarta(new Carta(tipo, territorio));
    }

    void adicionarContinente(Continente continente) {
        continentes.put(continente.getNome(), continente);
    }

	void adicionarCarta(Carta carta) {
		cartas.add(carta);
	}

	Carta retirarCarta() {
		return cartas.pop();
	}

	Map<String, Jogador> getJogadores() {
		return jogadores;
	}

	Map<String, Territorio> getTerritorios() {
		return territorios;
	}

	Map<String, Continente> getContinentes() {
		return continentes;
	}

	Jogador getJogador(String cor) {
		return jogadores.get(cor);
	}

	Territorio getTerritorio(String territorio) {
		return territorios.get(territorio);
	}

	Continente getContinente(String continente) {
		return continentes.get(continente);
	}

	Jogador getDono(Territorio territorio) {
		for (Jogador jogador : jogadores.values()) {
			if (jogador.possuiTerritorio(territorio))
				return jogador;
		}
		return null;
	}

	Jogador atualJogador() {
		return ordemJogadores.element();
	}

	void proximoJogador() {
		// Remove o jogador do inicio da fila
		Jogador proximo = ordemJogadores.poll();

		// Se o jogador puder receber carta, ele recebe
		if (proximo.getRecebeCarta()) {
			proximo.adicionarCarta(retirarCarta());
			proximo.setRecebeCarta(false);
		}

		// Adiciona o jogador no final da fila
		ordemJogadores.add(proximo);
	}

	void eliminarJogador(Jogador jogador) {
		ordemJogadores.remove(jogador);
	}

	public void addObserver(Observer o) {
		lob.add(o);
	}

	public void removeObserver(Observer o) {
		lob.remove(o);
	}

	public Object get() {
		return null;
	}

	void notificaMudanca() {
		for (Observer o : lob) {
			o.notify(this);
		}
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
            proximoJogador();
            atualJogador().adicionarTerritorio(arrayTerritorios[retiraSorteado]);
        }
	}

	void embaralhaCartas() {
		int totalCartas = cartas.size();

		int[] sorteados = new int[totalCartas];
		Carta[] arrayCartas = cartas.toArray(new Carta[0]);

		// Cria deque de tamanho total
		Deque<Integer> deck = new ArrayDeque<>();
		for (int i = 0; i < totalCartas; i++) {
			deck.add(i);
    	}

		// Embaralha o deque
		shuffleDeck(deck);

		// Remove elementos do deque de cartas
		cartas.clear();

		// Retira Sorteado
		for (int i = 0; i < totalCartas; i++) {
            Integer retiraSorteado = retiraSorteado(deck);
            sorteados[i] = retiraSorteado;
			Carta carta = arrayCartas[retiraSorteado];
			cartas.add(carta);
        }
	}

	void sorteiaOrdem() {
		Collections.shuffle(ordemJogadores);
	}
	
	void sorteiaObjetivos() {
		// Cria lista de objetivos
		ArrayList<Class<? extends Objetivo>> objetivos = new ArrayList<>();
		objetivos.add(Objetivo1.class);
		objetivos.add(Objetivo2.class);
		objetivos.add(Objetivo3.class);
		objetivos.add(Objetivo4.class);
		objetivos.add(Objetivo5.class);
		objetivos.add(Objetivo6.class);
		objetivos.add(Objetivo7.class);
		objetivos.add(Objetivo8.class);
		objetivos.add(Objetivo9.class);
		objetivos.add(Objetivo10.class);
		objetivos.add(Objetivo11.class);
		objetivos.add(Objetivo12.class);
		objetivos.add(Objetivo13.class);
		objetivos.add(Objetivo14.class);

		// Embaralha objetivos
		Collections.shuffle(objetivos);

		// Atribui objetivo a cada jogador
		for (Jogador jogador : ordemJogadores) {
			try {
				jogador.setObjetivo(objetivos.get(0).getDeclaredConstructor().newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
			objetivos.remove(0);
		}

		for (Jogador jogador : ordemJogadores) {
			System.out.println(jogador.getObjetivo().getClass().getSimpleName());
		}
	}
	
	// Iniciamos todos os territorios do arquivo.
	// qnd criamos um territorio ele está anexado a um continente, entao criamos o continente POR CAUSA DOS OBJETIVOS
	// e colocamos o nome do territorio, os vizinhos, continente pertencente, e por algum motivo o tipo dele na carta
	void inicializaTerritorios() {
		// América do Norte	
		Continente americaDoNorte = new Continente("AMÉRICA DO NORTE", 5);
		adicionarContinente(americaDoNorte);
		adicionarTerritorio(new Territorio("ALASCA", new ArrayList<>(Arrays.asList("CALGARY", "VANCOUVER", "SIBÉRIA"))), americaDoNorte, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("CALGARY", new ArrayList<>(Arrays.asList("ALASCA", "VANCOUVER", "GROENLÂNDIA"))), americaDoNorte, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("GROENLÂNDIA", new ArrayList<>(Arrays.asList("CALGARY", "QUEBEC", "REINO UNIDO"))), americaDoNorte, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("VANCOUVER", new ArrayList<>(Arrays.asList("CALIFORNIA", "TEXAS", "QUEBEC", "CALGARY", "ALASCA"))), americaDoNorte, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("QUEBEC", new ArrayList<>(Arrays.asList("TEXAS", "NOVA YORK", "VANCOUVER", "GROENLÂNDIA"))), americaDoNorte, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("CALIFORNIA", new ArrayList<>(Arrays.asList("TEXAS", "MÉXICO", "VANCOUVER"))), americaDoNorte, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("TEXAS", new ArrayList<>(Arrays.asList("MÉXICO", "CALIFORNIA", "NOVA YORK", "VANCOUVER", "QUEBEC"))), americaDoNorte, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("NOVA YORK", new ArrayList<>(Arrays.asList("TEXAS", "QUEBEC"))), americaDoNorte, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("MÉXICO", new ArrayList<>(Arrays.asList("VENEZUELA", "CALIFORNIA", "TEXAS"))), americaDoNorte, TipoCarta.quadrado);

		// América do Sul
		Continente americaDoSul = new Continente("AMÉRICA DO SUL", 2);
		adicionarContinente(americaDoSul);
		adicionarTerritorio(new Territorio("VENEZUELA", new ArrayList<>(Arrays.asList("BRASIL", "PERU", "MÉXICO"))), americaDoSul, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("PERU", new ArrayList<>(Arrays.asList("BRASIL", "ARGENTINA", "VENEZUELA"))), americaDoSul, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("BRASIL", new ArrayList<>(Arrays.asList("ARGENTINA", "VENEZUELA", "PERU", "NIGÉRIA"))), americaDoSul, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("ARGENTINA", new ArrayList<>(Arrays.asList("PERU", "BRASIL"))), americaDoSul, TipoCarta.quadrado);

		// Oceania
		Continente oceania = new Continente("OCEANIA", 2);
		adicionarContinente(oceania);
		adicionarTerritorio(new Territorio("PERTH", new ArrayList<>(Arrays.asList("AUSTRALIA"))), oceania, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("AUSTRALIA", new ArrayList<>(Arrays.asList("PERTH", "INDONÉSIA", "NOVA ZELÂNDIA"))), oceania, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("NOVA ZELÂNDIA", new ArrayList<>(Arrays.asList("AUSTRALIA", "INDONÉSIA"))), oceania, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("INDONÉSIA", new ArrayList<>(Arrays.asList("ÍNDIA", "BANGLADESH", "AUSTRÁLIA", "NOVA ZELÂNDIA"))), oceania, TipoCarta.triangulo);

		// África
		Continente africa = new Continente("ÁFRICA", 3);
		adicionarContinente(africa);
		adicionarTerritorio(new Territorio("ARGÉLIA", new ArrayList<>(Arrays.asList("NIGÉRIA", "ESPANHA", "ITÁLIA", "EGITO"))), africa, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("EGITO", new ArrayList<>(Arrays.asList("ARGÉLIA", "NIGÉRIA", "SOMÁLIA", "JORDÂNIA", "ROMÊNIA"))), africa, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("NIGÉRIA", new ArrayList<>(Arrays.asList("ARGÉLIA", "EGITO", "SOMÁLIA", "ANGOLA", "BRASIL"))), africa, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("SOMÁLIA", new ArrayList<>(Arrays.asList("ÁFRICA DO SUL", "ANGOLA", "NIGÉRIA", "EGITO","ARÁBIA SAUDITA"))), africa, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("ANGOLA", new ArrayList<>(Arrays.asList("NIGÉRIA", "SOMÁLIA", "ÁFRICA DO SUL"))), africa, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("ÁFRICA DO SUL", new ArrayList<>(Arrays.asList("ANGOLA", "SOMÁLIA"))), africa, TipoCarta.triangulo);

		// Europa
		Continente europa = new Continente("EUROPA", 5);
		adicionarContinente(europa);
		adicionarTerritorio(new Territorio("REINO UNIDO", new ArrayList<>(Arrays.asList("FRANÇA", "GROENLÂNDIA"))), europa, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("ESPANHA", new ArrayList<>(Arrays.asList("ARGÉLIA", "FRANÇA"))), europa, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("FRANÇA", new ArrayList<>(Arrays.asList("ESPANHA", "ITÁLIA", "REINO UNIDO", "SUÉCIA"))), europa, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("SUÉCIA", new ArrayList<>(Arrays.asList("FRANÇA", "ITÁLIA", "ESTÔNIA", "LETÔNIA"))), europa, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("POLÔNIA", new ArrayList<>(Arrays.asList("ITÁLIA", "ROMÊNIA", "UCRÂNIA", "LETÔNIA"))), europa, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("ITÁLIA", new ArrayList<>(Arrays.asList("ARGÉLIA", "FRANÇA", "SUÉCIA", "POLÔNIA", "ROMÊNIA"))), europa, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("ROMÊNIA", new ArrayList<>(Arrays.asList("ITÁLIA", "EGITO", "UCRÂNIA", "POLÔNIA"))), europa, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("UCRÂNIA", new ArrayList<>(Arrays.asList("POLÔNIA", "ROMÊNIA", "LETÔNIA", "TURQUIA"))), europa, TipoCarta.circulo);

		// Ásia
		Continente asia = new Continente("ÁSIA", 7);
		adicionarContinente(asia);
		adicionarTerritorio(new Territorio("ESTÔNIA", new ArrayList<>(Arrays.asList("SUÉCIA", "LETÔNIA", "RÚSSIA"))), asia, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("LETÔNIA", new ArrayList<>(Arrays.asList("ESTÔNIA", "RÚSSIA", "CAZAQUISTÃO", "TURQUIA", "UCRÂNIA", "POLÔNIA", "SUÉCIA"))), asia, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("TURQUIA", new ArrayList<>(Arrays.asList("LETÔNIA", "CAZAQUISTÃO", "PAQUISTÃO", "SÍRIA", "UCRÂNIA", "CHINA"))), asia, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("SÍRIA", new ArrayList<>(Arrays.asList("TURQUIA", "PAQUISTÃO", "IRÃ", "IRAQUE", "JORDÂNIA"))), asia, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("JORDÂNIA", new ArrayList<>(Arrays.asList("EGITO", "SÍRIA", "IRAQUE", "ARÁBIA SAUDITA"))), asia, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("ARÁBIA SAUDITA", new ArrayList<>(Arrays.asList("SOMÁLIA", "JORDÂNIA", "IRAQUE"))), asia, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("IRAQUE", new ArrayList<>(Arrays.asList("JORDÂNIA", "ARÁBIA SAUDITA", "IRÃ", "SÍRIA"))), asia, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("IRÃ", new ArrayList<>(Arrays.asList("SÍRIA", "PAQUISTÃO", "IRAQUE"))), asia, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("PAQUISTÃO", new ArrayList<>(Arrays.asList("TURQUIA", "CHINA", "ÍNDIA", "IRÃ", "SÍRIA"))), asia, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("RÚSSIA", new ArrayList<>(Arrays.asList("ESTÔNIA", "SIBÉRIA", "CAZAQUISTÃO", "LETÔNIA"))), asia, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("SIBÉRIA", new ArrayList<>(Arrays.asList("RÚSSIA", "ALASCA", "CAZAQUISTÃO"))), asia, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("CAZAQUISTÃO", new ArrayList<>(Arrays.asList("RÚSSIA", "SIBÉRIA", "MONGÓLIA", "JAPÃO", "CHINA", "TURQUIA", "LETÔNIA"))), asia, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("MONGÓLIA", new ArrayList<>(Arrays.asList("CAZAQUISTÃO", "JAPÃO", "CHINA"))), asia, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("CHINA", new ArrayList<>(Arrays.asList("CAZAQUISTÃO", "MONGÓLIA", "COREIA DO NORTE", "COREIA DO SUL", "ÍNDIA", "PAQUISTÃO", "TURQUIA"))), asia, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("COREIA DO NORTE", new ArrayList<>(Arrays.asList("CHINA", "JAPÃO", "COREIA DO SUL"))), asia, TipoCarta.quadrado);
		adicionarTerritorio(new Territorio("COREIA DO SUL", new ArrayList<>(Arrays.asList("CHINA", "COREIA DO NORTE", "BANGLADESH", "TAILÂNDIA", "ÍNDIA"))), asia, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("ÍNDIA", new ArrayList<>(Arrays.asList("PAQUISTÃO", "CHINA", "COREIA DO SUL", "BANGLADESH", "INDONÉSIA"))), asia, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("BANGLADESH", new ArrayList<>(Arrays.asList("COREIA DO SUL", "TAILÂNDIA", "INDONÉSIA", "ÍNDIA"))), asia, TipoCarta.circulo);
		adicionarTerritorio(new Territorio("TAILÂNDIA", new ArrayList<>(Arrays.asList("COREIA DO SUL", "BANGLADESH"))), asia, TipoCarta.triangulo);
		adicionarTerritorio(new Territorio("JAPÃO", new ArrayList<>(Arrays.asList("CAZAQUISTÃO", "MONGÓLIA", "COREIA DO NORTE"))), asia, TipoCarta.circulo);
	}

	void adicionaCoringas() {
		adicionarCarta(new Carta(TipoCarta.coringa, null));
		adicionarCarta(new Carta(TipoCarta.coringa, null));
	}

	void inicializaJogadores(String[][] jogadores) {
		for (String[] jogador : jogadores) {
			if (jogador[1] == null)
				break;
			adicionarJogador(new Jogador(jogador[0],jogador[1]));
		}
		System.out.println("Jogadores Inicializados");
		for (Jogador jogador : ordemJogadores) {
			System.out.println(jogador.getNome());
		}
	}

	// destroi o construtor
	void terminaJogo() {
		tabuleiro = null;
	}

	// METODO para salvar o jogo
	void salvarJogo(String caminho_nome)  {
		PrintWriter outputStream = null;

		// Prepara Arquivo para salvamento
		//  Usamos como caractere  separador o ";"

		ArrayList<String> PosicaoJogo = new ArrayList<>();

		// Recebe a ordem dos jogadores com o atual no final, pois o salvamento é no deslocamento
		ArrayList<String> ListaJogadores = new ArrayList<>();
		for (int i = 1; i < ordemJogadores.size(); i++) {
			ListaJogadores.add(ordemJogadores.get(i).getCor());
		}
		Jogador jogadorAtual = atualJogador();
		ListaJogadores.add(jogadorAtual.getCor());

		// Confere se o jogador atual pode receber carta
		if (jogadorAtual.getRecebeCarta()) {
			jogadorAtual.adicionarCarta(retirarCarta());
			jogadorAtual.setRecebeCarta(false);
		}

		PosicaoJogo.add("Inicia Salvamento do Jogo");
		// Lista as cores dos jogadores da partida
		for (String key : ListaJogadores) {
			// Recebe Obj do Jogador
			String ObjJogador = getJogador(key).getObjetivo().getClass().getName();

			// Recebe Nome do Jogador
			String NomeJogador = getJogador(key).getNome();

			PosicaoJogo.add("Cor_Objetivo_Nome");

			// Guarda Informações
			PosicaoJogo.add(key + ";" + ObjJogador + ";"+ NomeJogador);

			PosicaoJogo.add("Territorio_QtdeExercitos");
			// Recebe territórios do jogador e qtde de exxercitos por território
			List<String> ListaTerritorios = new ArrayList<>(getJogador(key).getTerritorios().keySet());
			for (String key2 : ListaTerritorios) {
				int qtde = getTerritorio(key2).getQtdExerc();
				// Guarda informações
				PosicaoJogo.add(key2 + ";" + qtde);
			}
			PosicaoJogo.add("INÍCIO_CARTAS");
			List<Carta> ListaCartas = new ArrayList<>(getJogador(key).getCartas());
			for (Carta key3 : ListaCartas) {
				String tipo = key3.getTipo().name(); 
				String NomeTerritorio = key3.getTerritorio().getNome();
				// Guarda informações
				PosicaoJogo.add(tipo +";"+ NomeTerritorio);
			}
			PosicaoJogo.add("FIM_CARTAS");
		}

		PosicaoJogo.add("CARTAS_MONTE");
		// Iterator
		Iterator<Carta> itr = cartas.iterator();

	    while (itr.hasNext()) {
	    	Carta cartaMonte = itr.next();
	    	String tipo = cartaMonte.getTipo().name(); 
			String NomeTerritorio = "coringa";
			if(tipo != "coringa") {
				NomeTerritorio = cartaMonte.getTerritorio().getNome();
			}
			System.out.println(NomeTerritorio);
			// Guarda informações
			PosicaoJogo.add(tipo +";"+ NomeTerritorio);
		}

		PosicaoJogo.add("FIM_ARQUIVO");

		try {
			outputStream = new PrintWriter(new FileWriter(caminho_nome));
			for (int i = 0; i< PosicaoJogo.size(); i++) {
				System.out.printf("%s\n",PosicaoJogo.get(i));
				outputStream.println(PosicaoJogo.get(i));
				}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		finally {
			outputStream.close();
		}	
	}

	List<ArrayList<String>> recuperarJogo(String caminho_nome) {
		List<ArrayList<String>> listadeArrayLists = new ArrayList<>();

		BufferedReader inputStream = null;
		ArrayList<String> listaJogadores = new ArrayList<>();
		ArrayList<String> listaObjetivos = new ArrayList<>();
		ArrayList<String> listaTerritorios = new ArrayList<>();
		ArrayList<String> listaCartas = new ArrayList<>();
		ArrayList<String> listaMonte = new ArrayList<>();
		String[] sub_strings = new String[3];
		String cor_atual = "";

		try {
			inputStream = new BufferedReader(new FileReader(caminho_nome));
			String l;
			int tipo_linha = 0;
			while ((l = inputStream.readLine()) != null) {
				//System.out.printf("%s\n",l);

				// Identifica o separador das informações no arquivo
				if (l.equals("Cor_Objetivo_Nome")) {
					tipo_linha = 1; 
				}
				if (l.equals("Territorio_QtdeExercitos")) {
					tipo_linha = 2; 
				}
				if (l.equals("INÍCIO_CARTAS")) {
					tipo_linha = 3; 
				}
				if (l.equals("CARTAS_MONTE")) {
					tipo_linha = 4; 
				}

				// Leitura das linhas para  as estruturas do Jogo
				if (tipo_linha == 1) {
					if(!l.equals("Cor_Objetivo_Nome")) {
						sub_strings = l.split("\\;", 0);
				        listaJogadores.add(sub_strings[2] + "," + sub_strings[0]);
				        listaObjetivos.add(sub_strings[1]);
				        cor_atual  =  sub_strings[0];
					}
				}
				if (tipo_linha == 2) {
					if(!l.equals("Territorio_QtdeExercitos")) {
						sub_strings = l.split("\\;", 0);
				        listaTerritorios.add(cor_atual + "," + sub_strings[0] + "," + sub_strings[1]);
					}
				}

				if (tipo_linha == 3) {
					if(!l.equals("INÍCIO_CARTAS") && !l.equals("FIM_CARTAS")) {
						sub_strings = l.split("\\;", 0);
				      listaCartas.add(cor_atual + "," + sub_strings[0] + "," + sub_strings[1]);
					}
				}
				if (tipo_linha == 4) {
					if(!l.equals("CARTAS_MONTE") && !l.equals("FIM_ARQUIVO")){
						sub_strings = l.split("\\;", 0);
				        listaMonte.add("Monte" + "," +sub_strings[0] + "," + sub_strings[1]);
					}
				}
			}
			inputStream.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}

		finally { 
			//inputStream.close();
			System.out.println("Processo Terminado");
			for (String elemento : listaJogadores) {
	            System.out.println(elemento);
	        }
	           
			for (String elemento : listaObjetivos) {
	            System.out.println(elemento);
	        }
			
			for (String elemento : listaTerritorios) {
	            System.out.println(elemento);
	        }
	        
			for (String elemento : listaCartas) {
	            System.out.println(elemento);
	        }
			for (String elemento : listaMonte) {
	            System.out.println(elemento);
	        }
		}
		listadeArrayLists.add(listaJogadores);
		listadeArrayLists.add(listaObjetivos);
		listadeArrayLists.add(listaTerritorios);
		listadeArrayLists.add(listaCartas);
		listadeArrayLists.add(listaMonte);
		
		return listadeArrayLists;
	}

	String[][] organizaJogadores(ArrayList<String> AList){
		String[] sub_strings = new String[2];
		int tam = AList.size();
		String[][] jogadores = new String[tam][tam];
		for (int i = 0; i < tam; i++) {
            sub_strings = AList.get(i).split("\\,", 0);
            jogadores[i][0] = sub_strings[0];
            jogadores[i][1] = sub_strings[1];
        }

		return jogadores;
	}

	void recuperaObjetivos(ArrayList<String> AList){
		int tam = AList.size();
		String[] objetivos = new String[tam];
		for (int i = 0; i < tam; i++) {
			objetivos[i] = AList.get(i);
		}
		for (int i = 0; i < tam; i++) {
			try {
				jogadores.get(ordemJogadores.get(i).getCor()).setObjetivo((Objetivo) Class.forName(objetivos[i]).getDeclaredConstructor().newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (Jogador jogador : ordemJogadores) {
			System.out.println(jogador.getObjetivo().getClass().getSimpleName());
		}
	}

	void recuperaTerritorios(ArrayList<String> ALterritorios){
		String[] sub_strings = new String[2];
		int tam = ALterritorios.size();
		for (int i = 0; i < tam; i++) {
            sub_strings = ALterritorios.get(i).split("\\,", 0);
            String corJogador = sub_strings[0];
            String nomeTerritorio = sub_strings[1];
            int QtdeExerc = Integer.parseInt(sub_strings[2]);
            jogadores.get(corJogador).adicionarTerritorio(territorios.get(nomeTerritorio));
            territorios.get(nomeTerritorio).setExerc(QtdeExerc);
		}
	}

	void recuperaCartas(ArrayList<String> ALista){
		String[] sub_strings = new String[2];
		int tam = ALista.size();
		System.out.println("Recuperando Cartas");

		for (int i = 0; i < tam; i++) {
            sub_strings = ALista.get(i).split("\\,", 0);
            String corJogador = sub_strings[0];
            //String tipoCarta = sub_strings[1];
            String nomeTerritorio = sub_strings[2];

            Iterator<Carta> iterator = cartas.iterator();

            while (iterator.hasNext()) {
                Carta estaCarta = iterator.next();
                if (estaCarta.getTerritorio().equals(territorios.get(nomeTerritorio)) ) {
                    jogadores.get(corJogador).adicionarCarta(estaCarta);
                    iterator.remove(); 
                	System.out.println("Carta adicionada ao jogador");
                    break; 
                }
            }     
        }
		System.out.println("Termina a recuperação das Cartas");
	}

	void recuperaMonte(ArrayList<String> ALista){
		String[] sub_strings = new String[2];
		int tam = ALista.size();
		System.out.println("Recuperando MONTE");

		// Limpa monte
		cartas.clear();
		for (int i = 0; i < tam; i++) {
            sub_strings = ALista.get(i).split("\\,", 0);
            //String corJogador = sub_strings[0];
            String tipo_Carta = sub_strings[1];
            String nomeTerritorio = sub_strings[2];

            if (tipo_Carta.equals("coringa")) {
            	Carta carta = new Carta(TipoCarta.coringa, null);
            	cartas.add(carta);
            }

            if (tipo_Carta.equals("circulo")) {
            	Carta carta = new Carta(TipoCarta.circulo, territorios.get(nomeTerritorio));
            	cartas.add(carta);
            }

            if (tipo_Carta.equals("triangulo")) {
            	Carta carta = new Carta(TipoCarta.triangulo, territorios.get(nomeTerritorio));
            	cartas.add(carta);
            }

            if (tipo_Carta.equals("quadrado")) {
            	Carta carta = new Carta(TipoCarta.quadrado, territorios.get(nomeTerritorio));
            	cartas.add(carta);
            }
        }
		System.out.println("Termina a recuperação do MONTE de Cartas");
	}
}
