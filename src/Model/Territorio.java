package Model;

import java.util.Map;
import java.util.HashMap;

class Territorio {
	private String nome;
	private int qtdExerc;
	private Map<String, Territorio> vizinhos;

	Territorio(String nome) {
		this.nome = nome;
		this.qtdExerc = 0;
		vizinhos = new HashMap<>();
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

	void adicionaVizinho(Territorio viz) {
		vizinhos.put(viz.getNome(), viz);
	}

	boolean ehVizinho(Territorio territorio) {
		return vizinhos.containsValue(territorio);
	}
}
