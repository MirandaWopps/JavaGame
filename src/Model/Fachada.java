package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Fachada {
	private static Fachada fachada;
	private Tabuleiro tabuleiro;

	private Fachada() {
	}

	public static Fachada getFachada() {
		if (fachada == null)
			fachada = new Fachada();
		return fachada;
	}

	public void inicializaJogo(String[][] jogadores) {
		tabuleiro = Tabuleiro.getTabuleiro();
		tabuleiro.inicializaTerritorios();
		tabuleiro.adicionaCoringas();
		tabuleiro.inicializaJogadores(jogadores);
		tabuleiro.sorteiaOrdem();
		tabuleiro.sorteiaTerritorios();
		tabuleiro.sorteiaObjetivos();
		tabuleiro.embaralhaCartas();
	}

	public void salvarJogo() {
		tabuleiro.salvarJogo();
	}

	public void recuperarJogo() {
		tabuleiro = Tabuleiro.getTabuleiro();
		tabuleiro.recuperarJogo();
	}

	public void register(Observer o) {
		tabuleiro.addObserver(o);
		Dado.getDado().addObserver(o);
	}

	public String atualJogador() {
		return tabuleiro.atualJogador().getCor();
	}

	public String nomeAtualJogador() {
		return tabuleiro.atualJogador().getNome();
	}

	public void proximoJogador() {
		tabuleiro.proximoJogador();
	}

	public ArrayList<String> cartasAtualJogador() {
		ArrayList<String> cartas = new ArrayList<>();
		for (Carta carta : tabuleiro.atualJogador().getCartas()) {
			cartas.add(carta.getTerritorio().getNome());
		}
		return cartas;
	}

	public String objetivoAtualJogador() {
		return tabuleiro.atualJogador().getObjetivo().getDescricao();
	}	

	public boolean verificaVencedor() {
		Jogador jogador = tabuleiro.atualJogador();
		return jogador.testaObjetivo();
	}

	public void terminaJogo() {
		tabuleiro.terminaJogo();
	}

	public void receberExerc() {
		tabuleiro.atualJogador().exercitoPorNumeroTerritorios();
	}

	public int getRecebimento() {
		Jogador jogador = tabuleiro.atualJogador();
		return jogador.getExerc();
	}

	public int getRecebimentoContinente(String nomeContinente) {
		Continente continente = tabuleiro.getContinente(nomeContinente);
		if (continente == null) {
			return 0;
		}
		return continente.getExercBonus() - continente.getExercPos();
	}

	public List<String> getContinentesJogador() {
		List<String> continentes = new ArrayList<>();
		Jogador jogador = tabuleiro.atualJogador();
		// Itera sobre os continentes do tabuleiro, conferindo se o jogador possui eles
    	for (Continente continente : Tabuleiro.getTabuleiro().getContinentes().values())
		{
			if (jogador.possuiContinente(continente)) {
				continentes.add(continente.getNome());
			}
		}
		return continentes;
	}

	public List<String> territoriosContinente(String nomeContinente) {
		Continente continente = tabuleiro.getContinente(nomeContinente);
		if (continente == null) {
			return null;
		}
		return new ArrayList<>(continente.getTerritorios().keySet());
	}

	public boolean posicionaExerc(String nomeTerritorio, int qtdExerc) {
		Jogador jogador = tabuleiro.atualJogador();
		Territorio territorio = tabuleiro.getTerritorio(nomeTerritorio);
		jogador.exercPosicionado(qtdExerc);
		territorio.ganhaExerc(qtdExerc);
		return jogador.getExerc() > 0;
	}

	public boolean posicionaExercContinente(String nomeContinente, String nomeTerritorio, int qtdExerc) {
		Continente continente = tabuleiro.getContinente(nomeContinente);
		if (continente == null) {
			return false;
		}
		Territorio territorio = continente.getTerritorios().get(nomeTerritorio);
		if (territorio == null) {
			return false;
		}
		continente.addExercPos(qtdExerc);
		territorio.ganhaExerc(qtdExerc);
		if (continente.getExercBonus() > continente.getExercPos()) {
			return false;
		}
		continente.setExercPos(0);
		return true;
	}

	public void atacaTerritorio(String nomeAtacante, String nomeDefensor) {
		Territorio atacante = tabuleiro.getTerritorio(nomeAtacante);
		Territorio defensor = tabuleiro.getTerritorio(nomeDefensor);

		// Quantidade de exercitos que podem atacar
		int exAtaque = atacante.getQtdExerc()-1;
		if (exAtaque > 3) {
			exAtaque = 3;
		}

		// Quantidade de exercitos que podem defender
		int exDefesa = defensor.getQtdExerc();
		if (exDefesa > 3) {
			exDefesa = 3;
		}

		// Sorteia os dados
		Dado dado = Dado.getDado();
		int[] dados = dado.sorteiaDados(exAtaque, exDefesa);

		// Realiza a batalha
		int perdaAtaque = 0;
		int perdaDefesa = 0;
		for (int i = 0; i < 3; i++) {
			if (dados[i] > 0 && dados[i+3] > 0) {
				if (dados[i] > dados[i+3])
					perdaDefesa++;
				else
					perdaAtaque++;
			}
			else
				break;
		}

		// Atualiza os exercitos
		atacante.perdeExerc(perdaAtaque);
		defensor.perdeExerc(perdaDefesa);
		
		if (defensor.getQtdExerc() == 0) {
			// Atualiza o dono do territorio
			Jogador jogadorAtacante = tabuleiro.atualJogador();
			Jogador jogadorDefensor = tabuleiro.getDono(defensor);
			jogadorDefensor.removerTerritorio(defensor);
			jogadorAtacante.adicionarTerritorio(defensor);
			atacante.perdeExerc(exAtaque);
			defensor.ganhaExerc(exAtaque);

			// Seta jogador para receber carta
			jogadorAtacante.setRecebeCarta(true);

			// Verifica se o jogador defensor foi eliminado
			if (jogadorDefensor.getTerritorios().isEmpty()) {
				jogadorDefensor.setEliminador(jogadorAtacante.getCor());
				tabuleiro.eliminarJogador(jogadorDefensor);
			}
		}
	}

	public void deslocaExerc(String nomeOrigem, String nomeDest, int qtdExerc) {
		Territorio origem = tabuleiro.getTerritorio(nomeOrigem);
		Territorio destino = tabuleiro.getTerritorio(nomeDest);
		origem.perdeExerc(qtdExerc);
		destino.ganhaExerc(qtdExerc);
	}

	public List<String> territoriosJogador(String cor) {
		Jogador jogador = tabuleiro.getJogador(cor);
		if (jogador == null) {
			return null;
		}
		
		return new ArrayList<>(jogador.getTerritorios().keySet());
	}

	public List<String> territoriosAtacante() {
		Jogador jogador = tabuleiro.atualJogador();
		List<String> territorios = new ArrayList<>();
		// Itera sobre os territorios do jogador, conferindo se ele possui exercitos suficientes para atacar
		for (Territorio territorio : jogador.getTerritorios().values()) {
			if (territorio.getQtdExerc() > 1) {
				territorios.add(territorio.getNome());
			}
		}
		
		return territorios;
	}

	public List<String> territoriosDefensor(String territorioAtacante) {
		Jogador jogador = tabuleiro.atualJogador();
		List<String> territorios = new ArrayList<>();
		// Itera sobre os territorios vizinhos do territorio atacante, conferindo se o jogador nao possui eles
		for (String territorio : tabuleiro.getTerritorio(territorioAtacante).getVizinhos()) {
			if (!jogador.getTerritorios().containsKey(territorio)) {
				territorios.add(territorio);
			}
		}
		
		return territorios;
	}

	public List<String> territoriosOrigem() {
		Jogador jogador = tabuleiro.atualJogador();
		List<String> territorios = new ArrayList<>();
		// Itera sobre os territorios do jogador, conferindo se ele possui exercitos suficientes para deslocar
		for (Territorio territorio : jogador.getTerritorios().values()) {
			if (territorio.getQtdExerc() > 1) {
				territorios.add(territorio.getNome());
			}
		}
		
		return territorios;
	}

	public List<String> territoriosDestino(String territorioOrigem) {
		Jogador jogador = tabuleiro.atualJogador();
		List<String> territorios = new ArrayList<>();
		// Itera sobre os territorios vizinhos do territorio origem, conferindo se o jogador possui eles
		for (String territorio : tabuleiro.getTerritorio(territorioOrigem).getVizinhos()) {
			if (jogador.getTerritorios().containsKey(territorio)) {
				territorios.add(territorio);
			}
		}

		return territorios;
	}

	public int qtdExerc(String nomeTerritorio) {
		Map<String, Territorio> territorios = tabuleiro.getTerritorios();
		return territorios.get(nomeTerritorio).getQtdExerc();
	}
}
