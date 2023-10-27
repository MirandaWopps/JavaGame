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
		Map<String, Jogador> jogadores = tabuleiro.getJogadores();
		Jogador jogador = jogadores.get(cor);
		if (jogador == null) {
			return null;
		}
		
		return new ArrayList<>(jogador.getTerritorios().keySet());
	}
	
	public int qtdExerc(String nomeTerritorio) {
		Map<String, Territorio> territorios = tabuleiro.getTerritorios();
		return territorios.get(nomeTerritorio).getQtdExerc();
	}
}
