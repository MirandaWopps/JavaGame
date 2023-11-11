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
	
	public String atualJogador() {
		return tabuleiro.atualJogador().getCor();
	}
	
	public int getRecebimento() {
		Jogador jogador = tabuleiro.atualJogador();
		return jogador.getExerc();
	}

	public void colocaExerc(String nomeTerritorio, int qtdExerc) {
		Jogador jogador = tabuleiro.atualJogador();
		Territorio territorio = tabuleiro.getTerritorio(nomeTerritorio);
		jogador.colocaExerc(territorio, qtdExerc);
	}
	
	public List<String> territoriosJogador(String cor) {
		Jogador jogador = tabuleiro.getJogador(cor);
		if (jogador == null) {
			return null;
		}
		
		return new ArrayList<>(jogador.getTerritorios().keySet());
	}

	public List<String> territoriosJogadorAtacante() {
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
	
	public int qtdExerc(String nomeTerritorio) {
		Map<String, Territorio> territorios = tabuleiro.getTerritorios();
		return territorios.get(nomeTerritorio).getQtdExerc();
	}
}
