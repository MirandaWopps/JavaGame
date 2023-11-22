package Model; // parte de logica 

import java.util.ArrayList;
import java.util.List;

class Territorio {
	private String nome; // nome do territorio
	private int qtdExerc; // qtd de exercitos em determinado territorio
	private List<String> vizinhos = new ArrayList<>(); // territorios vizinhos

	/* METODOS da class Territorio*/
	//Construtor
	Territorio(String nome, List<String> vizinhos) { // construtor = faz um territorio existir
		this.nome = nome;
		this.vizinhos = vizinhos;
		this.qtdExerc = 1;
	}
	
	
	// metodo para receber a lista de vizinhos de um territorio
	List<String> getVizinhos() { 
		return vizinhos;
	}

	// acrescenta exercito em qtdExerc 
	void ganhaExerc(int n) { 
		qtdExerc += n;
        Tabuleiro.getTabuleiro().notificaMudanca();
	}

	// diminiui qtdExerc em determinado territorio
	void perdeExerc(int n) { 
		qtdExerc -= n;
        Tabuleiro.getTabuleiro().notificaMudanca(); // por que tem 2 metodos aqui ? e para notificar o tabuleiro ?
	}

	// recebe o nome do territorio
	String getNome() { 
		return nome;
	}

	// recebe a qtdExerc de um territorio
	int getQtdExerc() { 
		return qtdExerc;
	}
}
