package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.Fachada;
import View.TerritorioView;
import View.WarFrame;

public class NovoController {
	
	// metodo main
	public static void main(String[] args) {
	
		javax.swing.SwingUtilities.invokeLater(() -> {
			ImageIcon ico = new ImageIcon("windowsIcon.Ico");
			// FRAME
			JFrame frame = new JFrame("War");
			frame.setResizable(false);
	        frame.setBounds(200,200,1200,700);  // diz onde a tela surgira e cria nas dimensoes desejadas
	        frame.setDefaultCloseOperation(3); // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE
	        frame.setIconImage(ico.getImage() ); // icone para janela
	        //frame.setLayout(null); // Use null layout for absolute positioning
			
	        // LABEL
	        JLabel imageLabel = new JLabel(); 
	        ImageIcon imageIcon = new ImageIcon("Imagens/menuImage.jpg"); 
	        Image image = imageIcon.getImage(); 
	        imageLabel.setIcon(imageIcon); // Set the image to the label
	        
	        JButton button1 = new JButton("Novo Jogo");
	        button1.setBounds(250, 150, 150, 40); // Set button position and size
	        	        
	        JButton button2 = new JButton("Carregar Arquivo");
	        button2.setBounds(250, 230, 150, 40); // Set button position and size
	        
	        // Add an action listener to button1
	        button1.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	System.out.println("Novo jogo !");
	            	// Fecha janela inicial
	            	frame.dispose();       
	        
	        		Fachada fachada = Fachada.getFachada();
	        		fachada.inicializaJogo();
	                WarFrame f = null;
	        		try { // faz assim
	        			f = new WarFrame("War", ImageIO.read(new File("Imagens/war_tabuleiro_mapa copy.png")), ImageIO.read(new File("Imagens/war_tabuleiro_fundo.png")));
	        		}
	        		catch(IOException e2) { // se der erro
	        			System.out.println(e2.getMessage()); // mostra erro
	        			System.exit(1); // finaliza com codigo 1
	        		}
	        		f.setVisible(true);
	            	
	            }
	        });
	

	        // Add an action listener to button2
	        button2.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Action to perform when button2 is clicked
	                System.out.println("Será carregado Arquivo...");
	            }
	        });
        
        
        // drawing
        frame.add(button1);
        frame.add(button2);
        
        frame.add(imageLabel);

        frame.pack(); // Adjust the frame size to fit the image
        frame.setVisible(true);
    });
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
	

	// COMBO BOX
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
