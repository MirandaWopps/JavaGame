package Controller;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;

import Model.Fachada;
import View.MenuFrame;
import View.TerritorioView;
import View.WarFrame;

public class Controller {
	private static String jogador;

	// metodo main
	public static void main(String[] args) {
		mainLoop();
	}

	public static void mainLoop() {
		Fachada fachada = Fachada.getFachada();
		fachada.inicializaJogo();
		WarFrame f = new WarFrame("War");
		f.setVisible(true);
		while (true) {
			jogador = fachada.proximoJogador();
			f.setFase(1);
			while (true);
		}
	}

	// Desenha as bolinhas
	public static void desenhaTerritorios(Map<String,TerritorioView> territoriosView, Graphics2D g2d)
	{
		Fachada fachada = Fachada.getFachada();
		List<String> territoriosJogador;
		
		// territorios branco
		territoriosJogador = fachada.territoriosJogador("branco");
		if (territoriosJogador!=null)
		{
			for (String territorio : territoriosJogador) {
				TerritorioView territorioView = territoriosView.get(territorio);
				territorioView.desenha(g2d, Color.WHITE, fachada.qtdExerc(territorio));
			}
		}
		
		// territorios preto
		territoriosJogador = fachada.territoriosJogador("preto");
		if (territoriosJogador!=null)
		{
			for (String territorio : territoriosJogador) {
				TerritorioView territorioView = territoriosView.get(territorio);
				territorioView.desenha(g2d, Color.BLACK, fachada.qtdExerc(territorio));
			}
		}
		
		// territorios vermelho
		territoriosJogador = fachada.territoriosJogador("vermelho");
		if (territoriosJogador!=null)
		{
			for (String territorio : territoriosJogador) {
				TerritorioView territorioView = territoriosView.get(territorio);
				territorioView.desenha(g2d, Color.RED, fachada.qtdExerc(territorio));
			}
		}
		
		// territorios azul
		territoriosJogador = fachada.territoriosJogador("azul");
		if (territoriosJogador!=null)
		{
			for (String territorio : territoriosJogador) {
				TerritorioView territorioView = territoriosView.get(territorio);
				territorioView.desenha(g2d, Color.BLUE, fachada.qtdExerc(territorio));
			}
		}
		
		// territorios amarelo
		territoriosJogador = fachada.territoriosJogador("amarelo");
		if (territoriosJogador!=null)
		{
			for (String territorio : territoriosJogador) {
				TerritorioView territorioView = territoriosView.get(territorio);
				territorioView.desenha(g2d, Color.YELLOW, fachada.qtdExerc(territorio));
			}
		}
		
		// territorios verde
		territoriosJogador = fachada.territoriosJogador("verde");
		if (territoriosJogador!=null)
		{
			for (String territorio : territoriosJogador) {
				TerritorioView territorioView = territoriosView.get(territorio);
				territorioView.desenha(g2d, Color.GREEN, fachada.qtdExerc(territorio));
			}
		}
	}
	
	public static void comboBoxRecebimento(JComboBox<String> cb1) {
		Fachada fachada = Fachada.getFachada();
		cb1.removeAllItems();
		for (String territorio : fachada.territoriosJogador(jogador)) {
			cb1.addItem(territorio);
		}
	}

	// COMBO BOX
	public static void comboBoxAtacante(JComboBox<String> cb1) {
		Fachada fachada = Fachada.getFachada();
		cb1.removeAllItems();
		for (String territorio : fachada.territoriosJogadorAtacante(jogador)) {
			cb1.addItem(territorio);
		}
	}

	public static void comboBoxDefensor(JComboBox<String> cb2, String territorioAtacante) {
		cb2.removeAllItems();
		Fachada fachada = Fachada.getFachada();
		for (String territorio : fachada.territoriosDefensor(jogador, territorioAtacante)) {
			cb2.addItem(territorio);
		}
	}
	
	// preciso por dados de cores 

	
	
	/*
	// DADOS DE ATAQUE
	public void paintComponentes(Graphics g) {
        
        Graphics2D g2dLUCAS=(Graphics2D) g;

        g2dLUCAS.drawImage(dadoVermelho1,0,0,1000,400,null);
        //g2dLUCAS.drawImage(mapa,0,-30,1000,700,null);
        

    }

	
	*/
	

}
