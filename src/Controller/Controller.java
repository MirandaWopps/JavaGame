package Controller;

import Model.Fachada;
import View.MenuFrame;
import View.WarFrame;

public class Controller {
	private static WarFrame f;
	
	public static void main(String[] args) {
		MenuFrame mf = new MenuFrame("War");
		mf.setVisible(true);
	}

	public static void inicioJogo() {
		Fachada fachada = Fachada.getFachada();
		fachada.inicializaJogo();
		f = new WarFrame("War");
		f.setVisible(true);
		recebimento();
	}
	
	public static void recebimento() {
		f.setFase(1);
	}
	
	public static void ataque() {
		f.setFase(2);
	}
}
