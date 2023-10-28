package Controller;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;

import Model.Fachada;
import View.TerritorioView;
import View.WarFrame;

public class Controller {

	public static void main(String[] args) {
		Fachada fachada = Fachada.getFachada();
		fachada.inicializaJogo();
		WarFrame f = null;
		try {
			f = new WarFrame("War", ImageIO.read(new File("Imagens/war_tabuleiro_mapa copy.png")), ImageIO.read(new File("Imagens/war_tabuleiro_fundo.png")));
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		f.setVisible(true);

	}
	
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
	
	public static void comboBoxAtacante(JComboBox<String> cb1) {
		Fachada fachada = Fachada.getFachada();
		String cor = "branco";
		for (String territorio : fachada.territoriosJogadorAtacante(cor)) {
			cb1.addItem(territorio);
		}
	}

	public static void comboBoxDefensor(JComboBox<String> cb2, String territorioAtacante) {
		Fachada fachada = Fachada.getFachada();
		String cor = "branco";
		for (String territorio : fachada.territoriosDefensor(cor, territorioAtacante)) {
			cb2.addItem(territorio);
		}
	}

}
