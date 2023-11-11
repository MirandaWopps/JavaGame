package Model;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Territorio {
	private String nome;
	private int qtdExerc;
	private List<String> vizinhos = new ArrayList<>();

	Territorio(String nome, List<String> vizinhos) {
		this.nome = nome;
		this.vizinhos = vizinhos;
		this.qtdExerc = 1;
	}
	
	List<String> getVizinhos() {
		return vizinhos;
	}

	void ganhaExerc(int n) {
		qtdExerc += n;
        Tabuleiro.getTabuleiro().notificaMudanca();
	}

	void perdeExerc(int n) {
		qtdExerc -= n;
        Tabuleiro.getTabuleiro().notificaMudanca();
	}

	String getNome() {
		return nome;
	}

	int getQtdExerc() {
		return qtdExerc;
	}
}
