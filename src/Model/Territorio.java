package Model; // parte de logica 

import java.util.ArrayList;
import java.util.List;

class Territorio {
	private String nome; // nome do territorio
	private int qtdExerc; // qtd de exercitos em determinado territorio
	private int qtdExercDesloc; // qtd de exercitos para deslocar
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

	// seta a quantidade de exercitos no territorio
	void setExerc(int n) { 
		qtdExerc = n;
	}

	// reseta a quantidade de exercitos para deslocar
	void resetDesloc() { 
		qtdExercDesloc = qtdExerc - 1;
	}

	// acrescenta exercito em qtdExerc 
	void ganhaExerc(int n) { 
		qtdExerc += n;
        Tabuleiro.getTabuleiro().notificaMudanca(false);
	}

	// diminiui qtdExerc em determinado territorio
	void perdeExerc(int n) { 
		qtdExerc -= n;
        Tabuleiro.getTabuleiro().notificaMudanca(false);
	}

	// diminiui qtdExercDesloc em determinado territorio
	void perdeExercDesloc(int n) { 
		qtdExercDesloc -= n;
	}

	// recebe o nome do territorio
	String getNome() { 
		return nome;
	}

	// recebe a qtdExerc de um territorio
	int getQtdExerc() { 
		return qtdExerc;
	}

	// recebe a qtdExercDesloc de um territorio
	int getQtdExercDesloc() { 
		return qtdExercDesloc;
	}
}
