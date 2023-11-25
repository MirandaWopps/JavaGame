package Model;

abstract class Objetivo {
	private String descricao;

	Objetivo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	abstract boolean concluido(Jogador jogador);
}

class Objetivo1 extends Objetivo {
	Objetivo1() {
		super("Conquistar na totalidade a EUROPA, a OCEANIA e mais um terceiro.");
	}
	
	boolean concluido(Jogador jogador) {
		if (jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("EUROPA")) && jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("OCEANIA"))) {
			int qtd = 0;
			for (Continente continente : Tabuleiro.getTabuleiro().getContinentes().values()) {
				if (jogador.possuiContinente(continente)) {
					qtd++;
				}
			}
			return qtd >= 3;
		}
		return false;
	}
}

class Objetivo2 extends Objetivo {
	Objetivo2() {
		super("Conquistar na totalidade a ÁSIA e a AMÉRICA DO SUL.");
	}
	
	boolean concluido(Jogador jogador) {
		return jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("ÁSIA")) && jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("AMÉRICA DO SUL"));
	}
}

class Objetivo3 extends Objetivo {
	Objetivo3() {
		super("Conquistar na totalidade a EUROPA, a AMÉRICA DO SUL e mais um terceiro.");
	}
	
	boolean concluido(Jogador jogador) {
		if (jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("EUROPA")) && jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("AMÉRICA DO SUL"))) {
			int qtd = 0;
			for (Continente continente : Tabuleiro.getTabuleiro().getContinentes().values()) {
				if (jogador.possuiContinente(continente)) {
					qtd++;
				}
			}
			return qtd >= 3;
		}
		return false;
	}
}

class Objetivo4 extends Objetivo {
	Objetivo4() {
		super("Conquistar 18 TERRITÓRIOS e ocupar cada um deles com pelo menos dois exércitos.");
	}
	
	boolean concluido(Jogador jogador) {
		int qtd = 0;
		for (Territorio territorio : jogador.getTerritorios().values()) {
			if (territorio.getQtdExerc() >= 2) {
				qtd++;
			}
		}
		return qtd >= 18;
	}
}

class Objetivo5 extends Objetivo {
	Objetivo5() {
		super("Conquistar na totalidade a ÁSIA e a ÁFRICA.");
	}
	
	boolean concluido(Jogador jogador) {
		return jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("ÁSIA")) && jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("ÁFRICA"));
	}
}

class Objetivo6 extends Objetivo {
	Objetivo6() {
		super("Conquistar na totalidade a AMÉRICA DO NORTE e a ÁFRICA.");
	}
	
	boolean concluido(Jogador jogador) {
		return jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("AMÉRICA DO NORTE")) && jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("ÁFRICA"));
	}
}

class Objetivo7 extends Objetivo {
	Objetivo7() {
		super("Conquistar 24 TERRITÓRIOS à sua escolha.");
	}
	
	boolean concluido(Jogador jogador) {
		return jogador.getTerritorios().size() >= 24;
	}
}

class Objetivo8 extends Objetivo {
	Objetivo8() {
		super("Conquistar na totalidade a AMÉRICA DO NORTE e a OCEANIA.");
	}
	
	boolean concluido(Jogador jogador) {

		return jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("AMÉRICA DO NORTE")) && jogador.possuiContinente(Tabuleiro.getTabuleiro().getContinente("OCEANIA"));
	}
}

class Objetivo9 extends Objetivo {
	Objetivo9() {
		super("Destruir totalmente OS EXÉRCITOS AZUIS, se você quem possui os exércitos azuis ou se quem possui já foi eliminado ou não existe, seu objetivo passa a ser conquistar 24 TERRITÓRIOS.");
	}
	
	boolean concluido(Jogador jogador) {
		if (jogador.getCor().equals("azul") || Tabuleiro.getTabuleiro().getJogador("azul") == null) {
			return jogador.getTerritorios().size() >= 24;
		}

		if (Tabuleiro.getTabuleiro().getJogador("azul").getTerritorios().size() == 0) {
			if (Tabuleiro.getTabuleiro().getJogador("azul").getEliminador().equals(jogador.getCor())) {
				return true;
			}
			return jogador.getTerritorios().size() >= 24;
		}
		return false;
	}
}

class Objetivo10 extends Objetivo {
	Objetivo10() {
		super("Destruir totalmente OS EXÉRCITOS AMARELOS, se você quem possui os exércitos amarelos ou se quem possui já foi eliminado ou não existe, seu objetivo passa a ser conquistar 24 TERRITÓRIOS.");
	}
	
	boolean concluido(Jogador jogador) {
		if (jogador.getCor().equals("amarelo") || Tabuleiro.getTabuleiro().getJogador("amarelo") == null) {
			return jogador.getTerritorios().size() >= 24;
		}

		if (Tabuleiro.getTabuleiro().getJogador("amarelo").getTerritorios().size() == 0) {
			if (Tabuleiro.getTabuleiro().getJogador("amarelo").getEliminador().equals(jogador.getCor())) {
				return true;
			}
			return jogador.getTerritorios().size() >= 24;
		}
		return false;
	}
}

class Objetivo11 extends Objetivo {
	Objetivo11() {
		super("Destruir totalmente OS EXÉRCITOS VERMELHOS, se você quem possui os exércitos vermelhos ou se quem possui já foi eliminado ou não existe, seu objetivo passa a ser conquistar 24 TERRITÓRIOS.");
	}
	
	boolean concluido(Jogador jogador) {
		if (jogador.getCor().equals("vermelho") || Tabuleiro.getTabuleiro().getJogador("vermelho") == null) {
			return jogador.getTerritorios().size() >= 24;
		}

		if (Tabuleiro.getTabuleiro().getJogador("vermelho").getTerritorios().size() == 0) {
			if (Tabuleiro.getTabuleiro().getJogador("vermelho").getEliminador().equals(jogador.getCor())) {
				return true;
			}
			return jogador.getTerritorios().size() >= 24;
		}
		return false;
	}
}

class Objetivo12 extends Objetivo {
	Objetivo12() {
		super("Destruir totalmente OS EXÉRCITOS PRETOS, se você quem possui os exércitos pretos ou se quem possui já foi eliminado ou não existe, seu objetivo passa a ser conquistar 24 TERRITÓRIOS.");
	}
	
	boolean concluido(Jogador jogador) {
		if (jogador.getCor().equals("preto") || Tabuleiro.getTabuleiro().getJogador("preto") == null) {
			return jogador.getTerritorios().size() >= 24;
		}

		if (Tabuleiro.getTabuleiro().getJogador("preto").getTerritorios().size() == 0) {
			if (Tabuleiro.getTabuleiro().getJogador("preto").getEliminador().equals(jogador.getCor())) {
				return true;
			}
			return jogador.getTerritorios().size() >= 24;
		}
		return false;
	}
}

class Objetivo13 extends Objetivo {
	Objetivo13() {
		super("Destruir totalmente OS EXÉRCITOS BRANCOS, se você quem possui os exércitos brancos ou se quem possui já foi eliminado ou não existe, seu objetivo passa a ser conquistar 24 TERRITÓRIOS.");
	}
	
	boolean concluido(Jogador jogador) {
		if (jogador.getCor().equals("branco") || Tabuleiro.getTabuleiro().getJogador("branco") == null) {
			return jogador.getTerritorios().size() >= 24;
		}

		if (Tabuleiro.getTabuleiro().getJogador("branco").getTerritorios().size() == 0) {
			if (Tabuleiro.getTabuleiro().getJogador("branco").getEliminador().equals(jogador.getCor())) {
				return true;
			}
			return jogador.getTerritorios().size() >= 24;
		}
		return false;
	}
}

class Objetivo14 extends Objetivo {
	Objetivo14() {
		super("Destruir totalmente OS EXÉRCITOS VERDES, se você quem possui os exércitos verdes ou se quem possui já foi eliminado ou não existe, seu objetivo passa a ser conquistar 24 TERRITÓRIOS.");
	}

	boolean concluido(Jogador jogador) {
		if (jogador.getCor().equals("verde") || Tabuleiro.getTabuleiro().getJogador("verde") == null) {
			return jogador.getTerritorios().size() >= 24;
		}

		if (Tabuleiro.getTabuleiro().getJogador("verde").getTerritorios().size() == 0) {
			if (Tabuleiro.getTabuleiro().getJogador("verde").getEliminador().equals(jogador.getCor())) {
				return true;
			}
			return jogador.getTerritorios().size() >= 24;
		}
		return false;
	}
}
