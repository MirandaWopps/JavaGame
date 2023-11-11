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
	
	public void inicializaJogo() {
		tabuleiro = Tabuleiro.getTabuleiro();
		tabuleiro.inicializaTerritorios();
	}

	public void register(Observer o) {
		tabuleiro.addObserver(o);
	}

	public String atualJogador() {
		return tabuleiro.atualJogador().getCor();
	}
	
	public void proximoJogador() {
		tabuleiro.proximoJogador();
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

	public void deslocaExerc(String territorioOrigem, String territorioDest, int qtdExerc) {
		Territorio origem = tabuleiro.getTerritorio(territorioOrigem);
		Territorio destino = tabuleiro.getTerritorio(territorioDest);
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
