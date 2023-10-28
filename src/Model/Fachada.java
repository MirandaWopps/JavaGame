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
		tabuleiro = new Tabuleiro();
		tabuleiro.inicializaTerritorios();
	}
	
	public List<String> territoriosJogador(String cor) {
		Jogador jogador = tabuleiro.getJogador(cor);
		if (jogador == null) {
			return null;
		}
		
		return new ArrayList<>(jogador.getTerritorios().keySet());
	}
	
	public String getJogadorJogando() {
		return "branco";
	}
	
	public List<String> territoriosJogadorAtacante(String cor) {
		Jogador jogador = tabuleiro.getJogador(cor);
		List<String> territorios = new ArrayList<>();
		for (Territorio territorio : jogador.getTerritorios().values()) {
			if (territorio.getQtdExerc() > 1) {
				territorios.add(territorio.getNome());
			}
		}
		
		return territorios;
	}

	public List<String> territoriosDefensor(String cor, String territorioAtacante) {
		Jogador jogador = tabuleiro.getJogador(cor);
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
