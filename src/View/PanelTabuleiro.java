package View;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.Controller;
import Model.Fachada;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe sendo usada no "WarFrame.java"
public class PanelTabuleiro extends JPanel {    
	private Image mapa;   //
	private Image fundo;  //
	private int fase = 1;
	private Map<String,TerritorioView> territorios = new HashMap<>();
	private JComboBox<String> cb1 = new JComboBox<>();
	private JComboBox<String> cb2 = new JComboBox<>();
	private JComboBox<Integer> cb3 = new JComboBox<>();
	private JButton button1 = new JButton("Colocar");
	private JButton button2 = new JButton("Atacar");
	
	public PanelTabuleiro() {
		try {
			mapa = ImageIO.read(new File("Imagens/war_tabuleiro_mapa copy.png"));
			fundo = ImageIO.read(new File("Imagens/war_tabuleiro_fundo.png"));
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
        add(cb1);
        add(cb2);
		add(cb3);

		cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println(fase);
            	if (fase == -2 || fase == 2) {
            		cb2.removeAllItems();
                    String selected = (String) cb1.getSelectedItem();
                    comboBoxDefensor(cb2, selected);
            	}   
            }
        });
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String territorio = (String) cb1.getSelectedItem();
				int qtdExerc = (int) cb3.getSelectedItem();
				Fachada.getFachada().colocaExerc(territorio, qtdExerc);
			}
		});
		
		instanciaTerritoriosView();
	}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;
        
        // desenha as imagens de fundo
        g2d.drawImage(fundo,0,0,1000,700,null);
        g2d.drawImage(mapa,0,-30,1000,700,null);
        
        // desenha os territorios
        desenhaTerritorios(territorios, g2d);

        // desenha sidebar
        Rectangle2D sideBar = new Rectangle2D.Double(1000,0,200,700);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(sideBar);
        g2d.draw(sideBar);
		switch (fase) {
			// recebimento
			case 1:
				comboBoxRecebimento(cb1);
				comboBoxExerc(cb3);
				cb3.setVisible(true);
				cb2.setVisible(false);
				button1.setVisible(true);
				fase = -1;
				break;
			// ataque
			case 2:
				comboBoxAtacante(cb1);
				cb2.setVisible(true);
				cb3.setVisible(false);
				fase = -2;
				break;
		}
		cb1.setLocation(1010, 30);
		cb2.setLocation(1010, 70);
		cb3.setLocation(1010, 70);
    }

	public void setFase(int fase) {
		this.fase = fase;
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
	
	public static void comboBoxRecebimento(JComboBox<String> cb1) {
		Fachada fachada = Fachada.getFachada();
		cb1.removeAllItems();
		List<String> territorios = fachada.territoriosJogador(Fachada.getFachada().atualJogador());
		Collections.sort(territorios);
		for (String territorio : territorios) {
			cb1.addItem(territorio);
		}
	}
	
	public static void comboBoxExerc(JComboBox<Integer> cb3) {
		Fachada fachada = Fachada.getFachada();
		cb3.removeAllItems();
		int numExerc = fachada.getRecebimento();
		while (numExerc > 0) {
			cb3.addItem(numExerc);
			numExerc--;
		}
	}

	public static void comboBoxAtacante(JComboBox<String> cb1) {
		Fachada fachada = Fachada.getFachada();
		cb1.removeAllItems();
		List<String> territorios = fachada.territoriosJogadorAtacante();
		Collections.sort(territorios);
		for (String territorio : territorios) {
			cb1.addItem(territorio);
		}
	}

	public static void comboBoxDefensor(JComboBox<String> cb2, String territorioAtacante) {
		cb2.removeAllItems();
		Fachada fachada = Fachada.getFachada();
		List<String> territorios = fachada.territoriosDefensor(territorioAtacante);
		Collections.sort(territorios);
		for (String territorio : territorios) {
			cb2.addItem(territorio);
		}
	}

    private void instanciaTerritoriosView() {
    	// América do Norte
    	territorios.put("ALASCA", new TerritorioView(95,104,82,90,"ALASCA"));
    	territorios.put("CALGARY", new TerritorioView(190,110,170,94,"CALGARY"));
    	territorios.put("GROENLÂNDIA", new TerritorioView(321,80,285,65,"GROENLÂNDIA"));
    	territorios.put("VANCOUVER", new TerritorioView(160,153,132,140,"VANCOUVER"));
    	territorios.put("QUEBEC", new TerritorioView(270,150,270,135,"QUEBEC"));
    	territorios.put("CALIFORNIA", new TerritorioView(106,230,80,213,"CALIFORNIA"));
    	territorios.put("TEXAS", new TerritorioView(175,200,170,185,"TEXAS"));
    	territorios.put("NOVA YORK", new TerritorioView(205,222,210,207,"NOVA YORK"));
    	territorios.put("MEXICO", new TerritorioView(150,315,120,298,"MEXICO"));
    	
    	// América do Sul
    	territorios.put("VENEZUELA", new TerritorioView(192,375,165,360,"VENEZUELA"));
    	territorios.put("PERU", new TerritorioView(230,425,218,407,"PERU"));
    	territorios.put("BRASIL", new TerritorioView(289,397,268,380,"BRASIL"));
    	territorios.put("ARGENTINA", new TerritorioView(279,495,250,472,"ARGENTINA"));
    	
    	// Oceania
    	territorios.put("PERTH", new TerritorioView(788,528,770,513,"PERTH"));
    	territorios.put("AUSTRALIA", new TerritorioView(844,551,820,535,"AUSTRALIA"));
    	territorios.put("NOVA ZELÂNDIA", new TerritorioView(903,572,900,557,"NOVA ZELÂNDIA"));
    	territorios.put("INDONÉSIA", new TerritorioView(841,422,860,430,"INDONÉSIA"));
    	
    	// África
    	territorios.put("ARGÉLIA", new TerritorioView(441,315,420,300,"ARGÉLIA"));
    	territorios.put("EGITO", new TerritorioView(560,325,545,308,"EGITO"));
    	territorios.put("NIGÉRIA", new TerritorioView(500,357,439,360,"NIGÉRIA"));
    	territorios.put("SOMÁLIA", new TerritorioView(603,420,584,400,"SOMÁLIA"));
    	territorios.put("ANGOLA", new TerritorioView(544,443,525,425,"ANGOLA"));
    	territorios.put("ÁFRICA DO SUL", new TerritorioView(565,495,530,477,"ÁFRICA DO SUL"));
    	
    	// Europa
    	territorios.put("REINO UNIDO", new TerritorioView(457,140,425,125,"REINO UNIDO"));
    	territorios.put("ESPANHA", new TerritorioView(432,233,410,216,"ESPANHA"));
    	territorios.put("FRANÇA", new TerritorioView(480,195,460,178,"FRANÇA"));
    	territorios.put("SUÉCIA", new TerritorioView(528,110,510,92,"SUÉCIA"));
    	territorios.put("POLÔNIA", new TerritorioView(565,161,545,145,"POLÔNIA"));
    	territorios.put("ITÁLIA", new TerritorioView(520,210,508,194,"ITÁLIA"));
    	territorios.put("ROMÊNIA", new TerritorioView(573,214,555,236,"ROMÊNIA"));
    	territorios.put("UCRÂNIA", new TerritorioView(590,185,587,205,"UCRÂNIA"));
    	
    	// Ásia
    	territorios.put("ESTÔNIA", new TerritorioView(670,106,650,91,"ESTÔNIA"));
    	territorios.put("LETÔNIA", new TerritorioView(652,152,630,137,"LETÔNIA"));
    	territorios.put("TURQUIA", new TerritorioView(710,203,686,187,"TURQUIA"));
    	territorios.put("SÍRIA", new TerritorioView(670,234,628,238,"SÍRIA"));
    	territorios.put("JORDÂNIA", new TerritorioView(611,290,585,275,"JORDÂNIA"));
    	territorios.put("ARÁBIA SAUDITA", new TerritorioView(660,350,620,335,"ARÁBIA SAUDITA"));
    	territorios.put("IRAQUE", new TerritorioView(663,282,643,266,"IRAQUE"));
    	territorios.put("IRÃ", new TerritorioView(705,291,695,276,"IRÃ"));
    	territorios.put("PAQUISTÃO", new TerritorioView(725,257,695,242,"PAQUISTÃO"));
    	territorios.put("RÚSSIA", new TerritorioView(765,117,748,100,"RÚSSIA"));
    	territorios.put("SIBÉRIA", new TerritorioView(877,107,857,92,"SIBÉRIA"));
    	territorios.put("CAZAQUISTÃO", new TerritorioView(785,168,799,172,"CAZAQUISTÃO"));
    	territorios.put("MONGÓLIA", new TerritorioView(810,204,824,208,"MONGÓLIA"));
    	territorios.put("CHINA", new TerritorioView(780,245,765,230,"CHINA"));
    	territorios.put("COREIA DO NORTE", new TerritorioView(835,252,853,257,"COREIA DO NORTE"));
    	territorios.put("COREIA DO SUL", new TerritorioView(817,273,834,278,"COREIA DO SUL"));
    	territorios.put("ÍNDIA", new TerritorioView(777,330,765,315,"ÍNDIA"));
    	territorios.put("BANGLADESH", new TerritorioView(829,314,794,299,"BANGLADESH"));
    	territorios.put("TAILÂNDIA", new TerritorioView(883,304,895,309,"TAILÂNDIA"));
    	territorios.put("JAPÃO", new TerritorioView(923,220,924,205,"JAPÃO"));
    }
}
