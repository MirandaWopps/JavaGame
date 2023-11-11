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
		this.qtdExerc = 2;
	}
	
	List<String> getVizinhos() {
		return vizinhos;
	}

	Integer ganhaExerc(Integer n) {
		return qtdExerc = qtdExerc + n;
	}

	Integer perdeExerc(Integer n) {
		return qtdExerc = qtdExerc - n;
	}

	String getNome() {
		return nome;
	}

	int getQtdExerc() {
		return qtdExerc;
	}

	void adicionaVizinho(String viz) {
		vizinhos.add(viz);
	}
}
