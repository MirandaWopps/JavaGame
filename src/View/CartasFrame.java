package View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap; // faz o hash map funcionar 
import java.util.List;
import java.util.Map;     // 

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.Fachada;


// JANELA ABRINDO MOSTRANDO AS CARTAS
class CartasFrame {
	private static Map<String,Image> cartasMap = new HashMap<>();
	
	// Botoes
	private static JButton buttonCarta1;  
	private static JButton buttonCarta2;     
	private static JButton buttonCarta3;  
	private static JButton buttonCarta4;  
	private static JButton buttonCarta5;  
	private static JButton buttonConfirmar;  
	
	private static int[] btnPressed = new int[5];
	private static int qtdBotoesSelecionados;
	
	
	
	// Method to load and add an image to the map
    private void loadAndAddImage(String key, String imagePath) throws IOException {
        Image image = ImageIO.read(new File(imagePath));
        cartasMap.put(key, image);
    }
	
 // Constructor
    CartasFrame() {
        // Load images and add them to the map
        try {
            // America do Norte
            loadAndAddImage("ALASCA", "Imagens/war_carta_an_alasca.png");
            loadAndAddImage("CALGARY", "Imagens/war_carta_an_calgary.png");
            loadAndAddImage("GROELÂNDIA", "Imagens/war_carta_an_groelandia.png");
            loadAndAddImage("VANCOUVER", "Imagens/war_carta_an_vancouver.png");
            loadAndAddImage("QUEBEC", "Imagens/war_carta_an_quebec.png");
            loadAndAddImage("CALIFORNIA", "Imagens/war_carta_an_california.png");
            loadAndAddImage("TEXAS", "Imagens/war_carta_an_texas.png");
            loadAndAddImage("NOVA YORK", "Imagens/war_carta_an_novayork.png");
            loadAndAddImage("MÉXICO", "Imagens/war_carta_an_mexico.png");

            // America do Sul
            loadAndAddImage("VENEZUELA", "Imagens/war_carta_asl_venezuela.png");
            loadAndAddImage("PERU", "Imagens/war_carta_asl_peru.png");
            loadAndAddImage("BRASIL", "Imagens/war_carta_asl_brasil.png");
            loadAndAddImage("ARGENTINA", "Imagens/war_carta_asl_argentina.png");

            // Africa
            loadAndAddImage("ARGÉLIA", "Imagens/war_carta_af_argelia.png");
            loadAndAddImage("EGITO", "Imagens/war_carta_af_egito.png");
            loadAndAddImage("NIGÉRIA", "Imagens/war_carta_af_nigeria.png");
            loadAndAddImage("SOMÁLIA", "Imagens/war_carta_af_somalia.png");
            loadAndAddImage("ANGOLA", "Imagens/war_carta_af_angola.png");
            loadAndAddImage("ÁFRICA DO SUL", "Imagens/war_carta_af_africadosul.png");

            // Europa
            loadAndAddImage("REINO UNIDO", "Imagens/war_carta_eu_reinounido.png");
            loadAndAddImage("ESPANHA", "Imagens/war_carta_eu_espanha.png");
            loadAndAddImage("FRANÇA", "Imagens/war_carta_eu_franca.png");
            loadAndAddImage("SUÉCIA", "Imagens/war_carta_eu_suecia.png");
            loadAndAddImage("POLÔNIA", "Imagens/war_carta_eu_polonia.png");
            loadAndAddImage("ITÁLIA", "Imagens/war_carta_eu_italia.png");
            loadAndAddImage("ROMÊNIA", "Imagens/war_carta_eu_romenia.png");
            loadAndAddImage("UCRÂNIA", "Imagens/war_carta_eu_ucrania.png");

            // Asia
            loadAndAddImage("ESTÔNIA", "Imagens/war_carta_as_estonia.png");
            loadAndAddImage("LETÔNIA", "Imagens/war_carta_as_letonia.png");
            loadAndAddImage("TURQUIA", "Imagens/war_carta_as_turquia.png");
            loadAndAddImage("SÍRIA", "Imagens/war_carta_as_siria.png");
            loadAndAddImage("JORDÂNIA", "Imagens/war_carta_as_jordania.png");
            loadAndAddImage("ARÁBIA SAUDITA", "Imagens/war_carta_as_arabiasaudita.png");
            loadAndAddImage("IRAQUE", "Imagens/war_carta_as_iraque.png");
            loadAndAddImage("IRÃ", "Imagens/war_carta_as_ira.png");
            loadAndAddImage("PAQUISTÃO", "Imagens/war_carta_as_paquistao.png");
            loadAndAddImage("RÚSSIA", "Imagens/war_carta_as_russia.png");
            loadAndAddImage("SIBÉRIA", "war_carta_as_siberia.png");
            loadAndAddImage("CAZAQUISTÃO", "Imagens/war_carta_as_cazaquistao.png");
            loadAndAddImage("MONGÓLIA", "Imagens/war_carta_as_mongolia.png");
            loadAndAddImage("CHINA", "Imagens/war_carta_as_china.png");
            loadAndAddImage("COREIA DO NORTE", "Imagens/war_carta_as_coreiadonorte.png");
            loadAndAddImage("COREIA DO SUL", "Imagens/war_carta_as_coreiadosul.png");
            loadAndAddImage("ÍNDIA", "Imagens/war_carta_as_india.png");
            loadAndAddImage("BANGLADESH", "Imagens/war_carta_as_bangladesh.png");
            loadAndAddImage("TAILÂNDIA", "Imagens/war_carta_as_tailandia.png");
            loadAndAddImage("JAPÃO", "Imagens/war_carta_as_japao.png");

            // Oceania
            loadAndAddImage("AUSTRÁLIA", "Imagens/war_carta_oc_australia.png");
            loadAndAddImage("INDONÉSIA", "Imagens/war_carta_oc_indonesia.png");
            loadAndAddImage("NOVA ZELÂNDIA", "Imagens/war_carta_oc_novazelandia.png");
            loadAndAddImage("PERTH", "Imagens/war_carta_oc_perth.png");
            
            // Add more images as needed
            loadAndAddImage("VERSO", "Imagens/war_carta_verso.png");
            loadAndAddImage(null, "Imagens/war_carta_verso.png");
            loadAndAddImage("SMOKING", "Imagens/pacific.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




	 public void openCartasFrame() {		
		List<String> cartasAtualJogador ;
	
		cartasAtualJogador = Fachada.getFachada().cartasAtualJogador();
		
		
		String[] vetorCartas = new String[5];
		// tratamento de erro porque se pegar um que nao tem nada VAI DAR ERRO
		if (cartasAtualJogador.size() >= 4) { 
		    vetorCartas[0] = cartasAtualJogador.get(0);
		    vetorCartas[1] = cartasAtualJogador.get(1);
		    vetorCartas[2] = cartasAtualJogador.get(2);
		    vetorCartas[3] = cartasAtualJogador.get(3);
		} else if (cartasAtualJogador.size() >= 3){
			vetorCartas[0] = cartasAtualJogador.get(0);
			vetorCartas[1] = cartasAtualJogador.get(1);
			vetorCartas[2] = cartasAtualJogador.get(2);
		} else if (cartasAtualJogador.size() >= 2){
			vetorCartas[0] = cartasAtualJogador.get(0);
			vetorCartas[1] = cartasAtualJogador.get(1);
		} else if (cartasAtualJogador.size() >= 1){
			vetorCartas[0] = cartasAtualJogador.get(0);
		} else {
			
		}
		
		
		// Tapa buracos porque ta dando erro qnd pega NULL
		
		
		
		
		
		
		

        javax.swing.SwingUtilities.invokeLater(() -> {
        	
            JFrame frame = new JFrame("Cartas");
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Esse fecha tudo
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // fecha so o frame
            frame.setLayout(new FlowLayout());
  
            
            // Label
            JLabel labelObjetivos1 = new JLabel();
            JLabel labelObjetivos2 = new JLabel();
            JLabel labelObjetivos3 = new JLabel();
            JLabel labelObjetivos4 = new JLabel();
            JLabel labelObjetivos5 = new JLabel();
            System.out.println("asd");
            
            //if ( vetorCartas[0] != null) {
            	//ImageIcon image1 = new ImageIcon(cartasMap.get(vetorCartas[0])); // Provide the path to your image file
            	ImageIcon image1 = new ImageIcon(cartasMap.get("VERSO")); // Provide the path to your image file
            	labelObjetivos1.setIcon(image1);
            /*} else {
            	ImageIcon image1 = new ImageIcon(cartasMap.get("VERSO")); // Provide the path to your image file
            	labelObjetivos1.setIcon(image1);
            }*/

            
            //if ( vetorCartas[1] != null) {
            	//ImageIcon image2 = new ImageIcon(cartasMap.get(vetorCartas[1])); // Provide the path to your image file
            	ImageIcon image2 = new ImageIcon(cartasMap.get("VERSO")); // Provide the path to your image file
            	labelObjetivos2.setIcon(image2);
           /* } else {
            	ImageIcon image2 = new ImageIcon(cartasMap.get("VERSO")); // Provide the path to your image file
            	labelObjetivos2.setIcon(image2);
            }*/
            
           // if ( vetorCartas[2] != null) {
            	//ImageIcon image2 = new ImageIcon(cartasMap.get(vetorCartas[2])); // Provide the path to your image file
            	ImageIcon image3 = new ImageIcon(cartasMap.get("VERSO")); // Provide the path to your image file
            	labelObjetivos3.setIcon(image3);
           /* } else {
            	ImageIcon image3 = new ImageIcon(cartasMap.get("VERSO")); // Provide the path to your image file
            	labelObjetivos3.setIcon(image3);
            }*/
            
           // if ( vetorCartas[3] != null) {
            	//ImageIcon image4 = new ImageIcon(cartasMap.get(vetorCartas[3])); // Provide the path to your image file
            	ImageIcon image4 = new ImageIcon(cartasMap.get("VERSO")); // Provide the path to your image file
            	labelObjetivos4.setIcon(image4);
           /* } else {
            	ImageIcon image4 = new ImageIcon(cartasMap.get("VERSO")); // Provide the path to your image file
                labelObjetivos4.setIcon(image4);
            }*/
            
            //if ( vetorCartas[4] != null) {
            	//ImageIcon image5 = new ImageIcon(cartasMap.get(vetorCartas[4])); // Provide the path to your image file
            	ImageIcon image5 = new ImageIcon(cartasMap.get("VERSO")); // Provide the path to your image file
            	labelObjetivos5.setIcon(image5);
           /* } else {
            	ImageIcon image5 = new ImageIcon(cartasMap.get("VERSO")); // Provide the path to your image file
            	labelObjetivos5.setIcon(image5);
            }*/
            
            
            
            
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
            
           
                                  
            
             
           
            
         // Add as labels ao frame
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
        
        
        System.out.println("Abriu");
        System.out.println(cartasMap.get("VERSO"));
        System.out.println(vetorCartas[0]   ); 
        System.out.println(vetorCartas[1]   ); 
        System.out.println(vetorCartas[2]   );
        System.out.println(vetorCartas[3]   ); 
        System.out.println(vetorCartas[4]   ); 
        System.out.println(vetorCartas[4]   );
        
        
        
        
        
    } // fim do metodo q abre tudo 
	 
	 
	 
	 
	 
}// fim da classe