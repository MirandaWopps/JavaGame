package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Fachada;

class CartasView {

	private Map<String,Image> cartasMap = new HashMap<>();
	private List<String> playerCards; // Declare a List to store player cards

	private static CartasView cartasView; // Singleton
	
	// Botoes
	private JButton buttonCarta1;  
	private JButton buttonCarta2;     
	private JButton buttonCarta3;  
	private JButton buttonCarta4;  
	private JButton buttonCarta5;

	private Map<JButton, Integer> botoesMap = new HashMap<>();

	private int qtdBotoesSelecionados=0;
	private List<Integer> cartasSelecionadas = new ArrayList<>();

	private JDialog dialog;

	// Method to load and add an image to the map
	private void loadAndAddImage(String key, String imagePath) throws IOException {
		Image image = ImageIO.read(new File(imagePath));
		cartasMap.put(key, image);
	}

	private CartasView() {
		// Carrrega as imagens
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
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}

	public static CartasView getCartasView() {
		if (cartasView == null) {
			cartasView = new CartasView();
		}
		return cartasView;
	}

	// Inicializa parte gráfica
	public void openCartasView(JFrame owner) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			dialog = new JDialog(owner, "Cartas");
			dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			dialog.setModal(true); // Bloqueia a janela principal enquanto o dialog estiver aberto
			dialog.setSize(1000, 300); // Set your preferred size
			dialog.setLocationRelativeTo(null); // Centraliza o dialog
			dialog.setResizable(false); // Impede que o dialog seja redimensionado

			// Atualiza as cartas do jogador
			updateCardsUI();

			// Cria um painel para adicionar os botões
			JPanel panel = new JPanel();

			// Adiciona o painel ao dialog
			dialog.add(panel);

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
			// Adiciona os botoes ao painel
			panel.add(buttonCarta1);
			panel.add(buttonCarta2);
			panel.add(buttonCarta3);
			panel.add(buttonCarta4);
			panel.add(buttonCarta5);

			// Confere se o jogador precisa trocar cartas
			if (Fachada.getFachada().precisaTrocarCartas()) {
				dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				dialog.setSize(1000, 400);
				JLabel label = new JLabel("Você precisa trocar cartas!");
				label.setFont(label.getFont().deriveFont(30f)); // Aumenta o tamanho da fonte para 30
				panel.add(label);
			}

			// Adiciona os botoes ao map
			botoesMap.put(buttonCarta1, 0);
			botoesMap.put(buttonCarta2, 1);
			botoesMap.put(buttonCarta3, 2);
			botoesMap.put(buttonCarta4, 3);
			botoesMap.put(buttonCarta5, 4);

			dialog.setVisible(true);
		});
	}

	// cria botoes
	private JButton createButton(String key) {
		JButton button = new JButton(); // cria var do do tipo botao
		ImageIcon imageIcon = new ImageIcon(cartasMap.get(key)); // tera imagem equivalente ao pathing da imagem adquirido pelo hashMap
		button.setIcon(imageIcon); // essa imagem e adicionada para o botao
		button.setBackground(Color.WHITE); // o background do botao sera branco

		// cada botao tem seu proprio action lister, entao, o isClicked sera desmarcado para cada botao qnd reclicado
		button.addActionListener(createButtonActionListener(button));

		return button;
	}

	private ActionListener createButtonActionListener(JButton button) {
		return new ActionListener() {
			private boolean isClicked = false;

			@Override
			public void actionPerformed(ActionEvent e) {
				// Confere a flag para saber se o botao foi clicado
				if (isClicked) {
					// Desmarca o botao
					button.setBackground(Color.WHITE);
					// Remove a carta da lista de cartas selecionadas
					qtdBotoesSelecionados--;
					cartasSelecionadas.remove(botoesMap.get(button));
				} else {
					// Marca o botao
					button.setBackground(Color.RED);
					// Adiciona a carta na lista de cartas selecionadas
					qtdBotoesSelecionados++;
					cartasSelecionadas.add(botoesMap.get(button));
				}
				System.out.println(botoesMap.get(button));

				// Troca o estado da flag
				isClicked = !isClicked;

				// Se existem 3 todos devem ser desmarcados
				if (qtdBotoesSelecionados == 3) {
					int cartas[] = new int[3];
					for (int i = 0; i < 3; i++) {
						cartas[i] = cartasSelecionadas.get(i);
					}
					// Troca as cartas
					if (Fachada.getFachada().trocaCartas(cartas)) {
						// Atualiza as cartas do jogador
						dialog.dispose();
						openCartasView((JFrame)dialog.getParent());
					}
					cartasSelecionadas.clear();
					unselectAllButtons();
					return;
				}
			}
		};
	}

	private void unselectAllButtons() {
		// Desmarca os botoes
		for (Component comp : buttonCarta1.getParent().getComponents()) {
			if (comp instanceof JButton) {
				JButton button = (JButton) comp;
				button.setBackground(Color.WHITE);
				// Reseta o action listener
				button.removeActionListener(button.getActionListeners()[0]);
				button.addActionListener(createButtonActionListener(button));
			}
		}
		qtdBotoesSelecionados = 0;
	}

	private void updateCardsUI() { // Pega as cartas do jogador e passa para o construtor as cartas da fachada porque está sendo usada no construtor.
		playerCards = Fachada.getFachada().cartasAtualJogador();
	}
}
