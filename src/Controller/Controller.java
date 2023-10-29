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
	// Dados       ps: dps colocar num enum q nem a classe objetivos ? 
	// Vermelhos
	public final String dadoVermelho1 = "Imagens/dadosVermelho/1.png";
	public final String dadoVermelho2= "Imagens/dadosVermelho/2.png";
	public final String dadoVermelho3= "Imagens/dadosVermelho/3.png";
	public final String dadoVermelho4= "Imagens/dadosVermelho/4.png";
	public final String dadoVermelho5= "Imagens/dadosVermelho/5.png";
	public final String dadoVermelho6 = "Imagens/dadosVermelho/6.png";
	
	// Verde
	public final String dadoVerde1= "Imagens/dadosVerde/1.png";
	public final String dadoVerde2= "Imagens/dadosVerde/2.png";
	public final String dadoVerde3= "Imagens/dadosVerde/3.png";
	public final String dadoVerde4= "Imagens/dadosVerde/4.png";
	public final String dadoVerde5= "Imagens/dadosVerde/5.png";
	public final String dadoVerde6= "Imagens/dadosVerde/6.png";
	
	// Azul
	public final String dadoAzul1= "Imagens/dadosAzul/1.png";
	public final String dadoAzul2= "Imagens/dadosAzul/2.png";
	public final String dadoAzul3= "Imagens/dadosAzul/3.png";
	public final String dadoAzul4= "Imagens/dadosAzul/4.png";
	public final String dadoAzul5= "Imagens/dadosAzul/5.png";
	public final String dadoAzul6= "Imagens/dadosAzul/6.png";
		
	// Amarelo
	public final String dadoAmarelo1= "Imagens/dadoAmarelo/1.png";
	public final String dadoAmarelo2= "Imagens/dadoAmarelo/2.png";
	public final String dadoAmarelo3= "Imagens/dadoAmarelo/3.png";
	public final String dadoAmarelo4= "Imagens/dadoAmarelo/4.png";
	public final String dadoAmarelo5= "Imagens/dadoAmarelo/5.png";
	public final String dadoAmarelo6= "Imagens/dadoAmarelo/6.png";
		
	// Branco
	public final String dadoBranco1= "Imagens/dadoBranco/1.png";
	public final String dadoBranco2= "Imagens/dadoBranco/2.png";
	public final String dadoBranco3= "Imagens/dadoBranco/3.png";
	public final String dadoBranco4= "Imagens/dadoBranco/4.png";
	public final String dadoBranco5= "Imagens/dadoBranco/5.png";
	public final String dadoBranco6= "Imagens/dadoBranco/6.png";
	
	// Preto
	public final String dadoPreto1= "Imagens/dadoPreto/1.png";
	public final String dadoPreto2= "Imagens/dadoPreto/2.png";
	public final String dadoPreto3= "Imagens/dadoPreto/3.png";
	public final String dadoPreto4= "Imagens/dadoPreto/4.png";
	public final String dadoPreto5= "Imagens/dadoPreto/5.png";
	public final String dadoPreto6= "Imagens/dadoPreto/6.png";

	private static String jogador;

	// metodo main
	public static void main(String[] args) {
		// FRAME: com tabuleiros impressos
		Fachada fachada = Fachada.getFachada();
		fachada.inicializaJogo();
		WarFrame f = null;
		try { // faz assim
			f = new WarFrame("War", ImageIO.read(new File("Imagens/war_tabuleiro_mapa copy.png")), ImageIO.read(new File("Imagens/war_tabuleiro_fundo.png")));
		}
		catch(IOException e) { // se der erro
			System.out.println(e.getMessage()); // mostra erro
			System.exit(1); // finaliza com codigo 1
		} 
		f.setVisible(true);

		while (true) {
			jogador = fachada.proximoJogador();
			f.setFase(1);
			while (true);
		}
	} // end

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
