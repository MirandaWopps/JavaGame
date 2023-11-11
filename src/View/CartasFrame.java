package View;

import java.awt.Color;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


// JANELA ABRINDO MOSTRANDO AS CARTAS
class CartasFrame {
	// 52 CARTAS
	//Africa
	public final String war_carta_af_africadosul = "Imagens/war_carta_af_africadosul.png"; //1
	public final String war_carta_af_angola = "Imagens/war_carta_af_angola.png"; //2
	public final String war_carta_af_argelia = "Imagens/war_carta_af_argelia.png"; //3
	public final String war_carta_af_egito = "Imagens/war_carta_af_egito.png"; //4
	public final String war_carta_af_nigeria = "Imagens/war_carta_af_nigeria.png";//5
	public final String war_carta_af_somalia = "Imagens/war_carta_af_somalia.png";	//6
	
	//America do Norte
	public final String war_carta_an_alasca = "Imagens/war_carta_an_alasca.png";	//7
	public final String war_carta_an_calgary = "Imagens/war_carta_an_calgary.png";//8
	public final String war_carta_an_california = "Imagens/war_carta_an_california.png";//9
	public final String war_carta_an_groelandia = "Imagens/war_carta_an_groelandia.png";//10
	public final String war_carta_an_mexico = "Imagens/war_carta_an_mexico.png";//11
	public final String war_carta_an_novayork = "Imagens/war_carta_an_novayork.png";//12
	public final String war_carta_an_quebec = "Imagens/war_carta_an_quebec.png";//13
	public final String war_carta_an_texas = "Imagens/war_carta_an_texas.png";//14
	public final String war_carta_an_vancouver = "Imagens/war_carta_an_vancouver.png";// 15
	
	//ASIA
	public final String war_carta_as_arabiasaudita = "Imagens/war_carta_as_arabiasaudita.png";//16
	public final String war_carta_as_bangladesh = "Imagens/war_carta_as_bangladesh.png";//171
	public final String war_carta_as_cazaquistao = "Imagens/war_carta_as_cazaquistao.png";//18
	public final String war_carta_as_china = "Imagens/war_carta_as_china.png";//19
	public final String war_carta_as_coreiadonorte = "Imagens/war_carta_as_coreiadonorte.png";//20
	public final String war_carta_as_coreiadosul = "Imagens/war_carta_as_coreiadosul.png";//21
	public final String war_carta_as_estonia = "Imagens/war_carta_as_estonia.png";//22
	public final String war_carta_as_india = "Imagens/war_carta_as_india.png";//23
	public final String war_carta_as_ira = "Imagens/war_carta_as_ira.png";//24
	public final String war_carta_as_iraque = "Imagens/war_carta_as_iraque.png";//25
	public final String war_carta_as_japao = "Imagens/war_carta_as_japao.png";//27
	public final String war_carta_as_jordania = "Imagens/war_carta_as_jordania.png";//28
	public final String war_carta_as_letonia = "Imagens/war_carta_as_letonia.png";//29
	public final String war_carta_as_mongolia = "Imagens/war_carta_as_mongolia.png";//30
	public final String war_carta_as_paquistao = "Imagens/war_carta_as_paquistao.png";//31
	public final String war_carta_as_russia = "Imagens/war_carta_as_russia.png";//32
	public final String war_carta_as_siberia = "war_carta_as_siberia.png";//33
	public final String war_carta_as_siria = "Imagens/war_carta_as_siria.png";//34
	public final String war_carta_as_tailandia = "Imagens/war_carta_as_tailandia.png";//35
	public final String war_carta_as_turquia = "Imagens/war_carta_as_turquia.png";//36
	
	//AMRICA DO SUL
	public final String war_carta_asl_argentina = "Imagens/war_carta_asl_argentina.png";//37
	public final String war_carta_asl_brasil = "Imagens/war_carta_asl_brasil.png";//38
	public final String war_carta_asl_peru = "Imagens/war_carta_asl_peru.png";//39
	public final String war_carta_asl_venezuela = "Imagens/war_carta_asl_venezuela.png";//40
	
	//CORINGA
	//public final String war_carta_coringa = "Imagens/dadosVermelho/1.png";//41
	
	//EUROPA
	public final String war_carta_eu_espanha = "Imagens/war_carta_eu_espanha.png";//42
	public final String war_carta_eu_franca = "Imagens/war_carta_eu_franca.png";//43
	public final String war_carta_eu_italia = "Imagens/war_carta_eu_italia.png";//44
	public final String war_carta_eu_polonia = "Imagens/war_carta_eu_polonia.png";//45
	public final String war_carta_eu_reinounido = "Imagens/war_carta_eu_reinounido.png";//46
	public final String war_carta_eu_romenia = "Imagens/war_carta_eu_romenia.png";//47
	public final String war_carta_eu_suecia = "Imagens/war_carta_eu_suecia.png";//48
	public final String war_carta_eu_ucrania = "Imagens/war_carta_eu_ucrania.png";//49
	
	//OCEANIA
	//public final String war_carta_oc_australia = "Imagens/war_carta_oc_australia.png";//50
	//public final String war_carta_oc_indonesia = "Imagens/war_carta_oc_indonesia.png";//51
	//public final String war_carta_oc_novazelandia = "Imagens/war_carta_oc_novazelandia.png";//52
	//public final String war_carta_oc_perth = "Imagens/war_carta_oc_perth.png";//53

	/*
	void CartasObjetivo(){
		setLayout(new FlowLayout());
		
	}*/
	
	// Botoes
	private static JButton buttonCarta1;  
	private static JButton buttonCarta2;     
	private static JButton buttonCarta3;  
	private static JButton buttonCarta4;  
	private static JButton buttonCarta5;  
	private static JButton buttonConfirmar;  
	
	private static int[] btnPressed = new int[5];
	private static int qtdBotoesSelecionados;
	
	
	public static void main(String[] args) {
		String war_carta_coringa = "Imagens/war_carta_coringa.png";//41
		String war_carta_oc_australia = "Imagens/war_carta_oc_australia.png";//50
		String war_carta_oc_indonesia = "Imagens/war_carta_oc_indonesia.png";//51
		String war_carta_oc_novazelandia = "Imagens/war_carta_oc_novazelandia.png";//52
		String war_carta_oc_perth = "Imagens/war_carta_oc_perth.png";//53
        javax.swing.SwingUtilities.invokeLater(() -> {
        	
            JFrame frame = new JFrame("Cartas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());
             /*
            ImageIcon static image1 = new ImageIcon(getClass().getResource(war_carta_oc_perth)); // Provide the path to your image file
            frame.add(image1);
            ImageIcon image2 = new ImageIcon(war_carta_oc_indonesia); // Provide the path to your image file
            frame.setIcon(image2);*/
            
            // Label
            JLabel labelObjetivos1 = new JLabel();
            JLabel labelObjetivos2 = new JLabel();
            JLabel labelObjetivos3 = new JLabel();
            JLabel labelObjetivos4 = new JLabel();
            JLabel labelObjetivos5 = new JLabel();
            

            ImageIcon image1 = new ImageIcon(war_carta_oc_australia); // Provide the path to your image file
            labelObjetivos1.setIcon(image1);
            ImageIcon image2 = new ImageIcon(war_carta_oc_indonesia); // Provide the path to your image file
            labelObjetivos2.setIcon(image2);
            ImageIcon image3 = new ImageIcon(war_carta_oc_novazelandia); // Provide the path to your image file
            labelObjetivos3.setIcon(image3);
            ImageIcon image4 = new ImageIcon(war_carta_oc_perth); // Provide the path to your image file
            labelObjetivos4.setIcon(image4);
            ImageIcon image5 = new ImageIcon(war_carta_coringa); // Provide the path to your image file
            labelObjetivos5.setIcon(image5);
            
            
            
            
            
            // Botoes na tela
            // b1
            buttonCarta1 = new JButton("Carta 1 ");
            buttonCarta1.setBounds(120,10,200,40);
            buttonCarta1.setBackground(Color.lightGray ); // a cor do botao
            buttonCarta1.setBorder(BorderFactory.createEtchedBorder() );//o tipo da borda
            buttonCarta1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	if (qtdBotoesSelecionados < 3) {
                		if (btnPressed[0] == 0) {
                			buttonCarta1.setBackground(Color.blue ); // SELECIONADO
                			btnPressed[0] = 1;
                			qtdBotoesSelecionados++;
                		} else {
                			buttonCarta1.setBackground(Color.lightGray ); // VOLTA ao normal
                			btnPressed[0] = 0 ;
                			qtdBotoesSelecionados--;
                		}
                		System.out.println("Button Carta 1 clicked");
                	} else {// limita botoes
                		if (btnPressed[0] == 1) {
                			buttonCarta1.setBackground(Color.lightGray ); // VOLTA ao normal
            				btnPressed[0] = 0 ;
            				qtdBotoesSelecionados--;
                		}
                	}
                 
                }
            });
            
            //b2
            buttonCarta2 = new JButton("Carta 2 ");
            buttonCarta2.setBounds(120,10,200,40);
            buttonCarta2.setBackground(Color.lightGray ); // a cor do botao
            buttonCarta2.setBorder(BorderFactory.createEtchedBorder() );//o tipo da borda
            buttonCarta2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	if (qtdBotoesSelecionados < 3) {
                		if (btnPressed[1] == 0) {
                			buttonCarta2.setBackground(Color.blue ); // SELECIONADO
                			btnPressed[1] = 1;
                			qtdBotoesSelecionados++;
                		} else {
                			buttonCarta2.setBackground(Color.lightGray ); // VOLTA ao normal
                			btnPressed[1] = 0 ;
                			qtdBotoesSelecionados--;
                		}
                		System.out.println("Button Carta 2 clicked");
                	} else {// limita botoes
                		if (btnPressed[1] == 1) {
                			buttonCarta2.setBackground(Color.lightGray ); // VOLTA ao normal
            				btnPressed[1] = 0 ;
            				qtdBotoesSelecionados--;
                		}
                	}
                		
                }
            });
            
          //b3
            buttonCarta3 = new JButton("Carta 3 ");
            buttonCarta3.setBounds(120,10,200,40);
            buttonCarta3.setBackground(Color.lightGray ); // a cor do botao
            buttonCarta3.setBorder(BorderFactory.createEtchedBorder() );//o tipo da borda
            buttonCarta3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	if (qtdBotoesSelecionados < 3) {
                		if (btnPressed[2] == 0) {
                			buttonCarta3.setBackground(Color.blue ); // SELECIONADO
                			btnPressed[2] = 1;
                			qtdBotoesSelecionados++;
                		} else {
                			buttonCarta3.setBackground(Color.lightGray ); // VOLTA ao normal
                			btnPressed[2] = 0 ;
                			qtdBotoesSelecionados--;
                		}
                		System.out.println("Button Carta 3 clicked");
                	}else {// limita botoes
                		if (btnPressed[2] == 1) {
                			buttonCarta3.setBackground(Color.lightGray ); // VOLTA ao normal
            				btnPressed[2] = 0 ;
            				qtdBotoesSelecionados--;
                		}
                	}
                	
                	
                }
            });
            
          //b4
            buttonCarta4 = new JButton("Carta 4 ");
            buttonCarta4.setBounds(120,10,200,40);
            buttonCarta4.setBackground(Color.lightGray ); // a cor do botao
            buttonCarta4.setBorder(BorderFactory.createEtchedBorder() );//o tipo da borda
            buttonCarta4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	if (qtdBotoesSelecionados < 3) {
                		if (btnPressed[3] == 0) {
                			buttonCarta4.setBackground(Color.blue ); // SELECIONADO
                			btnPressed[3] = 1;
                			qtdBotoesSelecionados++;
                		} else {
                			buttonCarta4.setBackground(Color.lightGray ); // VOLTA ao normal
                			btnPressed[3] = 0 ;
                			qtdBotoesSelecionados--;
                		}
                    	System.out.println("Button Carta 4 clicked");
                	}else {// limita botoes
                		if (btnPressed[3] == 1) {
                			buttonCarta4.setBackground(Color.lightGray ); // VOLTA ao normal
            				btnPressed[3] = 0 ;
            				qtdBotoesSelecionados--;
                		}
                	}
                	
                	
                }
            });
            
          //b5
            buttonCarta5 = new JButton("Carta 5 ");
            buttonCarta5.setBounds(120,10,200,40);
            buttonCarta5.setBackground(Color.lightGray ); // a cor do botao
            buttonCarta5.setBorder(BorderFactory.createEtchedBorder() );//o tipo da borda
            buttonCarta5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	if (qtdBotoesSelecionados < 3) {
                		if (btnPressed[4] == 0) {
                			buttonCarta5.setBackground(Color.blue ); // SELECIONADO
                			btnPressed[4] = 1;
                			qtdBotoesSelecionados++;
                		} else {
                			buttonCarta5.setBackground(Color.lightGray ); // VOLTA ao normal
                			btnPressed[4] = 0 ;
                			qtdBotoesSelecionados--;
                		}
                		System.out.println("Button Carta 5 clicked");
                	}else {// limita botoes
                		if (btnPressed[4] == 1) {
                			buttonCarta5.setBackground(Color.lightGray ); // VOLTA ao normal
            				btnPressed[4] = 0 ;
            				qtdBotoesSelecionados--;
                		}
                	}
                	
                	
                }
            });
            
          //b6
            buttonConfirmar = new JButton("Confirmar ! ");
            buttonConfirmar.setBounds(120,10,200,40);
            buttonConfirmar.setBackground(Color.lightGray ); // a cor do botao
            buttonConfirmar.setBorder(BorderFactory.createEtchedBorder() );//o tipo da borda
            buttonConfirmar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
      
                    System.out.println("Button \"confirmar\" clicked");
                    if (qtdBotoesSelecionados == 3) {
                    	 System.out.println("TROCA TELA porque 3 cartas estao selecionadas");
                    }
                }
            });
            
           
            
            
            
           
            
         // Add the label to the frame
            frame.getContentPane().add(labelObjetivos1);
            frame.getContentPane().add(labelObjetivos2);
            frame.getContentPane().add(labelObjetivos3);
            frame.getContentPane().add(labelObjetivos4);
            frame.getContentPane().add(labelObjetivos5);
            
  
            
            
         // Botoes 
            
            frame.add(buttonCarta1);
            frame.add(buttonCarta2);
            frame.add(buttonCarta3);
            frame.add(buttonCarta4);
            frame.add(buttonCarta5);
            frame.add(buttonConfirmar);
            
            
            
         // Prevent frame resizing
            frame.setResizable(false);

            frame.pack();
            frame.setVisible(true);
        });
    }
}