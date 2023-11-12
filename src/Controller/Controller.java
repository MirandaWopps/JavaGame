package Controller;

import Model.Fachada;
import View.MenuFrame;
import View.WarFrame;

public class Controller {
	private static WarFrame f;
	private static String primeiroJogador;
	private static boolean inicio = false;
	private static int fase;
	private static boolean mudouJogador = true;
	
	public static void main(String[] args) {
		MenuFrame mf = new MenuFrame("War");
		mf.setVisible(true);
	}

	public static void inicioJogo() {
		Fachada.getFachada().inicializaJogo();
		f = new WarFrame("War");
		f.setVisible(true);
		inicio = true;
		primeiroJogador = Fachada.getFachada().atualJogador();
		recebimentoInicial();
	}

	public static void recebimentoInicial() {
		if (inicio) {
			inicio = false;
		}
		else {
			Fachada.getFachada().proximoJogador();
			if (primeiroJogador.equals(Fachada.getFachada().atualJogador())) {
				Fachada.getFachada().receberExerc();
				fase = 1;
				return;
			}
		}
		mudouJogador = true;
		Fachada.getFachada().receberExerc();
		fase = 0;
	}
	
	public static void recebimento() {
		Fachada.getFachada().receberExerc();
		fase = 1;
	}
	
	public static void posicionaExerc(String nomeTerritorio, int qtdExerc) {
		if (!Fachada.getFachada().posicionaExerc(nomeTerritorio, qtdExerc)) {
			if (fase == 1)
				mudaFase();
			else
				recebimentoInicial();
		}
	}

	public static boolean posicionaExercContinente(String nomeContinente, String nomeTerritorio, int qtdExerc) {
		return Fachada.getFachada().posicionaExercContinente(nomeContinente, nomeTerritorio, qtdExerc);
	}

	public static void atacaTerritorio(String territorioAtacante, String territorioDefensor) {
		Fachada.getFachada().atacaTerritorio(territorioAtacante, territorioDefensor);
	}

	public static void deslocaExerc(String territorioOrigem, String territorioDest, int qtdExerc) {
		Fachada.getFachada().deslocaExerc(territorioOrigem, territorioDest, qtdExerc);
	}
	
	public static int getFase() {
		return fase;
	}

	public static void mudaFase() {
		switch (fase) {
		case 1:
			fase = 2;
			break;
		case 2:
			fase = 3;
			break;
		case 3:
			Fachada.getFachada().proximoJogador();
			recebimento();
			break;
		}
	}
	
	public static boolean mudouFase(int faseView) {
		return fase != faseView;
	}

	public static boolean mudouJogador() {
        if (mudouJogador) {
        	mudouJogador = false;
            return true;
        }
        return false;
    }
}
