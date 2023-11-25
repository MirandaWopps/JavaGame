package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Fachada;

class CartasFrameV2 {

		private static Map<String,Image> cartasMap = new HashMap<>();
		private List<String> playerCards; // Declare a List to store player cards
		
		// Botoes
		private static JButton buttonCarta1;  
		private static JButton buttonCarta2;     
		private static JButton buttonCarta3;  
		private static JButton buttonCarta4;  
		private static JButton buttonCarta5;  
		private static JButton buttonConfirmar;  
		
		private static int[] btnPressed = new int[5];
		private static int qtdBotoesSelecionados=0;
		
		// adquire cartas da fachada
		private Fachada fachada; // Assuming you have an instance of Fachada

		
		
		// Method to load and add an image to the map
	    private void loadAndAddImage(String key, String imagePath) throws IOException {
	        Image image = ImageIO.read(new File(imagePath));
	        cartasMap.put(key, image);
	    }
		
	 
	    
	    
	 // Constructor
	    public CartasFrameV2(Fachada fachada) { // Precisa instanciar uma fachada, do contrario dá erro. Isso permite a comunicação da fachada com esta classe. 
	    	this.fachada = fachada;	
	    	
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
	            loadAndAddImage("SIBÉRIA", "Imagens/war_carta_as_siberia.png");
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
	            loadAndAddImage("CORINGA", "Imagens/war_carta_coringa.png");
	            loadAndAddImage("null", "Imagens/war_carta_verso.png");
	           

	        } catch (IOException e) {
	        	System.out.println("Algo deu errado na criacao do hash map");
	            e.printStackTrace();
	        }
	        
	        
	       
	        updateCardsUI(); // poe as cartas 
	    }
	    
	    
	    
	    // Inicializa parte gráfica
	    public void openCartasFrameV2() {
	        javax.swing.SwingUtilities.invokeLater(() -> {
	        	System.out.println(playerCards.size());
	            JFrame frame = new JFrame("Cartas");
	            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            frame.setSize(600, 400); // Set your preferred size

	            JPanel panel = new JPanel();

	            // Dependendo dos elementos pode dar erro "indexOutOfBounds". Entao, vamos criar botos com null onde nao existe elemento, isto é, carta 
	            switch (playerCards.size()) {
	            case 0: // nenhuma carta 
	            	buttonCarta1 = createButton("null");
		            buttonCarta2 = createButton("null");
		            buttonCarta3 = createButton("null");
		            buttonCarta4 = createButton("null");
		            buttonCarta5 = createButton("null");
	                break;
	            case 1: // 1 carta
	            	buttonCarta1 = createButton(playerCards.get(0));
		            buttonCarta2 = createButton("null");
		            buttonCarta3 = createButton("null");
		            buttonCarta4 = createButton("null");
		            buttonCarta5 = createButton("null");
	                break;
	            case 2: // 2 cartas
	            	buttonCarta1 = createButton(playerCards.get(0));
		            buttonCarta2 = createButton(playerCards.get(1));
		            buttonCarta3 = createButton("null");
		            buttonCarta4 = createButton("null");
		            buttonCarta5 = createButton("null");
	                break;
	            case 3: // 3 cartas
	            	buttonCarta1 = createButton(playerCards.get(0));
		            buttonCarta2 = createButton(playerCards.get(1));
		            buttonCarta3 = createButton(playerCards.get(2));
		            buttonCarta4 = createButton("null");
		            buttonCarta5 = createButton("null");
	                break;
	            case 4: // 4 cartas
	            	buttonCarta1 = createButton(playerCards.get(0));
		            buttonCarta2 = createButton(playerCards.get(1));
		            buttonCarta3 = createButton(playerCards.get(2));
		            buttonCarta4 = createButton(playerCards.get(3));
		            buttonCarta5 = createButton("null");
	                break;            
	            case 5:  // 5 CARTAS
	            	buttonCarta1 = createButton(playerCards.get(0));
		            buttonCarta2 = createButton(playerCards.get(1));
		            buttonCarta3 = createButton(playerCards.get(2));
		            buttonCarta4 = createButton(playerCards.get(3));
		            buttonCarta5 = createButton(playerCards.get(4));
		            break;
	        }

            // Add buttons to the panel
            panel.add(buttonCarta1);
            panel.add(buttonCarta2);
            panel.add(buttonCarta3);
            panel.add(buttonCarta4);
            panel.add(buttonCarta5);

            // Add the panel to the frame
            frame.getContentPane().add(panel);

            // Prevent frame resizing
            frame.setResizable(false);

            frame.pack();
            frame.setVisible(true);
        });
	    }

	    
	 // Method to unselect all buttons
	    private void unselectAllButtons() {
	        // Unselect all buttons and reset the count
	        for (Component comp : buttonCarta1.getParent().getComponents()) {
	            if (comp instanceof JButton) {
	                ((JButton) comp).setBackground(Color.WHITE);
	            }
	        }
	        qtdBotoesSelecionados = 0;
	    }
	    
	    
	    
	    
	    
	    // Metodo criador de botoes
	    private JButton createButton(String key) {
	    System.out.println(key);
	    JButton button = new JButton(); // surge novo botao
	    ImageIcon imageIcon = new ImageIcon(cartasMap.get(key)); // a imagem do botao aparece aq
	    
	    button.setIcon(imageIcon);

	    // Set initial background color
	    button.setBackground(Color.WHITE);

	    button.addActionListener(new ActionListener() {
	        private boolean isClicked = false;

	        public void actionPerformed(ActionEvent e) {
	        	// Se existem 3 todos devem ser unselected
                if (qtdBotoesSelecionados >= 3) {
                    unselectAllButtons();
                    // implementar troca de cartas
                    return;
                }
	            	
	        	
	        	
	            // Toggle the color on each click
	            if (isClicked) {
	                button.setBackground(Color.WHITE);
	                qtdBotoesSelecionados--;
	            } else {
	                // Set the desired color when the button is clicked
	                button.setBackground(Color.RED);
	                qtdBotoesSelecionados++;
	            }


	            // Handle button click if needed  DEBUG LINE
	            System.out.println("Button " + key + " clicked");
	            
	          
	            
	        }
	    });
	    return button;
	}
	    
	    
	    
	    private void updateCardsUI() { // Pega as cartas do jogador e passa para o construtor as cartas da fachada porque está sendo usada no construtor.
	    	playerCards = fachada.cartasAtualJogador();
	    }

	    
	    
	   
}	    
	    
	    
