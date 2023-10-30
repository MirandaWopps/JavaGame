package View;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;

import Model.Fachada;


public class MenuInicial extends JFrame{
	
	JFrame frame;
	JLabel displayField;
	ImageIcon image;
	/*
	private void playMusic() {
		File file = new File(filePathField.getText());
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
		
	clip = AudioSystem.getClip();
	clip.open(audioIn);
	
	if(isLooping) {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	}
	*/
	
	
	public static void main (String[] args) {
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
                    
                    // Cria Jogo
                    //JFrame newFrame = new JFrame("Nova Janela");
                    //newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    //newFrame.setSize(400, 200);
                    //newFrame.setVisible(true);
            
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
            
            
            // drawning
            frame.add(button1);
            frame.add(button2);
            
            frame.add(imageLabel);

            frame.pack(); // Adjust the frame size to fit the image
            frame.setVisible(true);
        });
	}
	
	
}
