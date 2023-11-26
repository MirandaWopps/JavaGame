package View;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import Controller.Controller;
import Model.Fachada;
import Model.Observable;
import Model.Observer;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PanelTabuleiro extends JPanel implements Observer {
	private Image mapa;  // imagem do mapa
	private Image fundo; // o fundo atras do mapa

	private Map<String,TerritorioView> territorios = new HashMap<>();
	private int faseView = -1; 
	private List<String> possuiContinentes;
	private boolean passouContinente = false;
	private boolean mostrarDados = false;

	private static final Color verdeCustom = new Color(50,205,50);
	private static final Color amareloCustom = new Color(255,200,0);

	// Combo boxes
	private JComboBox<String> cb1 = new JComboBox<>();  // Territorio de cima
	private JComboBox<String> cb2 = new JComboBox<>();  // Territorio de baixo
	private JComboBox<Integer> cb3 = new JComboBox<>(); // Tropas.

	// Combo boxes para dados
	private JComboBox<Integer> dadoAtq1 = new JComboBox<>();
	private JComboBox<Integer> dadoAtq2 = new JComboBox<>();
	private JComboBox<Integer> dadoAtq3 = new JComboBox<>();
	private JComboBox<Integer> dadoDef1 = new JComboBox<>();
	private JComboBox<Integer> dadoDef2 = new JComboBox<>();
	private JComboBox<Integer> dadoDef3 = new JComboBox<>();

	// Listas de dados
	private List<JComboBox<Integer>> dadosAtq = Arrays.asList(dadoAtq1, dadoAtq2, dadoAtq3);
	private List<JComboBox<Integer>> dadosDef = Arrays.asList(dadoDef1, dadoDef2, dadoDef3);

	// os botos da UI
	private JButton btnPosicionar = new JButton("Posicionar");
	private JButton btnAtacar = new JButton("Atacar");
	private JButton btnAtaqueManipulado = new JButton("<html><center>Ataque<br>Manipulado</center></html>");
	private JButton btnDeslocar = new JButton("Deslocar");

	private JButton btnObjetivo = new JButton("Objetivo");

	private JButton btnCartas = new JButton("Cartas"); // botao para as cartas
	
	private JButton btnSalvar = new JButton("Salvar");
	private JLabel proximoLabel = new JLabel();

	private ObjetivoPopUp objetivoPopup;

	public PanelTabuleiro() { // metodo do tabuleiro na View
		try {  // tente inicializar as 2 imagens
			mapa = ImageIO.read(new File("Imagens/war_tabuleiro_mapa copy.png")); // img do mapa na frente
			fundo = ImageIO.read(new File("Imagens/war_tabuleiro_fundo.png"));  // imagem de fundo
		}
		catch(IOException e) {
			System.out.println(e.getMessage()); // expoe o erro
			System.exit(1); // aborta com codigo 1
		}

		// Adiciona as combobox
        add(cb1);
        add(cb2);
		add(cb3);

		// Adiciona as combobox para dados
		add(dadoAtq1);
		add(dadoAtq2);
		add(dadoAtq3);
		add(dadoDef1);
		add(dadoDef2);
		add(dadoDef3);

		// Adiciona as opções dos dados
		for (int i = 1; i <= 6; i++) {
			dadoAtq1.addItem(i);
			dadoAtq2.addItem(i);
			dadoAtq3.addItem(i);
			dadoDef1.addItem(i);
			dadoDef2.addItem(i);
			dadoDef3.addItem(i);
		}

		// Listener da combobox dos territórios do jogador atual, para atualizar as outras combobox
		cb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String selected = (String) cb1.getSelectedItem();
            	if (selected != null) {
					if (faseView == 2) {  // Fase de ataque
						// Visibilidade dos dados manipulados
						int qtdExerc = Fachada.getFachada().qtdExerc(selected);
						qtdExerc--;

						// Guarda os dados selecionados
						int dados[] = { (int) dadoAtq1.getSelectedItem(), (int) dadoAtq2.getSelectedItem(), (int) dadoAtq3.getSelectedItem() };

						// Atualiza a combobox dos dados do atacante
						for (int i = 0; i < qtdExerc && i < 3; i++) {
							preencheDado(dadosAtq.get(i));
							// Seleciona o item que estava selecionado
							if (dados[i] != 0)
								dadosAtq.get(i).setSelectedItem(dados[i]);
						}
						for (int i = qtdExerc; i < 3; i++) {
							zeraDado(dadosAtq.get(i));
						}
						
						// Atualiza a combobox do defensor
						comboBoxDefensor(selected);
					}
					else if (faseView == 3) { // Fase de deslocamento
						// Atualiza a combobox do destino
						comboBoxDestino(selected);
						// Atualiza a combobox de exercitos
						comboBoxExercDeslocamento(selected);
					}
				}
            } 
        });

		// Listener da combobox do defensor, para atualizar os dados manipulados
		cb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selected = (String) cb2.getSelectedItem();
				if (faseView == 2) {
					if (selected != null) {
						// Visibilidade dos dados manipulados
						int qtdExerc = Fachada.getFachada().qtdExerc(selected);

						// Guarda os dados selecionados
						int dados[] = { (int) dadoDef1.getSelectedItem(), (int) dadoDef2.getSelectedItem(), (int) dadoDef3.getSelectedItem() };

						// Atualiza a combobox dos dados do defensor
						for (int i = 0; i < qtdExerc && i < 3; i++) {
							preencheDado(dadosDef.get(i));
							// Seleciona o item que estava selecionado
							if (dados[i] != 0)
								dadosDef.get(i).setSelectedItem(dados[i]);
						}
						for (int i = qtdExerc; i < 3; i++) {
							zeraDado(dadosDef.get(i));
						}
						visibilidadeDadosManipulados(true);
					}
					else {
						visibilidadeDadosManipulados(false);
					}
				}
			} 
		});

		// Botão posicionamento de tropas
		btnPosicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String territorio = (String) cb1.getSelectedItem();
				int qtdExerc = (int) cb3.getSelectedItem();

				if (possuiContinentes.isEmpty()) {
					Controller.posicionaExerc(territorio, qtdExerc);
				}
				else {
					if (Controller.posicionaExercContinente(possuiContinentes.get(0), territorio, qtdExerc)) {
						possuiContinentes.remove(0);
						passouContinente = true;
					}
				}
			}
		});
		add(btnPosicionar);

		// Botão ataque
		btnAtacar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String atacante = (String) cb1.getSelectedItem();
				String defensor = (String) cb2.getSelectedItem();
				if (atacante != null && defensor != null) {
					Controller.atacaTerritorio(atacante, defensor);
				}
			}
		});
		add(btnAtacar);

		// Botão ataque manipulado
		btnAtaqueManipulado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String atacante = (String) cb1.getSelectedItem();
				String defensor = (String) cb2.getSelectedItem();
				if (atacante != null && defensor != null) {
					int dadosAtq[] = { (int) dadoAtq1.getSelectedItem(), (int) dadoAtq2.getSelectedItem(), (int) dadoAtq3.getSelectedItem() };
					int dadosDef[] = { (int) dadoDef1.getSelectedItem(), (int) dadoDef2.getSelectedItem(), (int) dadoDef3.getSelectedItem() };
					Controller.atacaTerritorioManipulado(atacante, defensor, dadosAtq, dadosDef);
				}
			}
		});
		add(btnAtaqueManipulado);

		// Botão deslocamento de tropas
		btnDeslocar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String origem = (String) cb1.getSelectedItem();
				String destino = (String) cb2.getSelectedItem();
				Integer qtdExerc = (Integer) cb3.getSelectedItem();
				if (origem != null && destino != null && qtdExerc != null) {
					Controller.deslocaExerc(origem, destino, qtdExerc);
				}
			}
		});
		add(btnDeslocar);

		// Botão objetivo
		btnObjetivo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String objetivo = Fachada.getFachada().objetivoAtualJogador();
        		objetivoPopup.mostra(PanelTabuleiro.this, objetivo);
			}
		});
		add(btnObjetivo);

		// Botão próximo
		proximoLabel.setIcon(new ImageIcon("Imagens/war_btnProxJogada.png"));
		proximoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Controller.mudaFase();
				repaint();
			}
		});
		add(proximoLabel);
		
		// Botão cartas
		btnCartas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CartasView.getCartasView().openCartasView((JFrame)SwingUtilities.getWindowAncestor(PanelTabuleiro.this));
			}
		});
		add(btnCartas);
		
		// Botão salvar
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int r = fileChooser.showSaveDialog(null);
				if (r == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					Fachada.getFachada().salvarJogo(file.getAbsolutePath());
				}
			}
		});
		add(btnSalvar);

		objetivoPopup = new ObjetivoPopUp();
		
		instanciaTerritoriosView();
	}
	
	// comecam os desenhos na tela
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;
        
        // Desenha as imagens de fundo
        g2d.drawImage(fundo,0,0,1000,700,null);
        g2d.drawImage(mapa,0,-30,1000,700,null);
        
        // Desenha os territorios
        desenhaTerritorios(territorios, g2d);

        // Desenha sidebar
        Rectangle2D sideBar = new Rectangle2D.Double(1000,0,200,700);
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(sideBar);
        g2d.draw(sideBar);

		// Obtenha o jogador atual
		String jogadorAtual = Fachada.getFachada().atualJogador();

		// Obtenha a cor do jogador
		Color corJogador = stringToColor(jogadorAtual);

		// Desenha um retângulo com a cor do jogador
		Rectangle2D retanguloJogador = new Rectangle2D.Double(1018, 210, 150, 120);
		g2d.setColor(corJogador);
		g2d.fill(retanguloJogador);
		g2d.draw(retanguloJogador);

        // Fase do jogo
        int fase = Controller.getFase();
        boolean mudouFase = Controller.mudouFase(faseView);

		switch(fase) {
			case 0:
				boolean mudouJogador = Controller.mudouJogador();
				if (mudouJogador || passouContinente) {
					passouContinente = false;
					faseRecebimento(mudouJogador);
				}
				
				break;
			case 1:
				if (mudouFase || passouContinente) {
					passouContinente = false;
					faseView = fase;
					faseRecebimento(mudouFase);
					if (Fachada.getFachada().precisaTrocarCartas()) {
						CartasView.getCartasView().openCartasView((JFrame)SwingUtilities.getWindowAncestor(PanelTabuleiro.this));
					}
				}
				break;
			case 2:
				if (mudouFase) {
					faseView = fase;
					faseAtaque();
				}
				break;
			case 3:
				if (mudouFase) {
					faseView = fase;
					faseDeslocamento();
				}
				break;
			case 4:
				faseFim();
				break;
		}

		// Posicionamento das combobox
		cb1.setLocation(1010, 30);
		switch (faseView) {
			case 3:
				cb2.setLocation(1010, 70);
				cb3.setLocation(1010, 110);
				break;
			case 2:
				// Desenha os dados
				if (mostrarDados)
					DadoView.getDadoView().mostrarDados(g2d);
			default:
				cb2.setLocation(1010, 70);
				cb3.setLocation(1010, 70);
				break;
		}

		// Posicionamento dos botões
		btnPosicionar.setBounds(1040, 120, 100, 30);
		btnAtacar.setBounds(1040, 120, 100, 30);
		btnAtaqueManipulado.setBounds(1040, 450, 100, 60);
		btnDeslocar.setBounds(1040, 160, 100, 30);

		btnObjetivo.setBounds(1040, 580, 100, 30);
		
		btnCartas.setBounds(1040, 500, 100, 30);
		
		btnSalvar.setBounds(1040, 500, 100, 30);
		proximoLabel.setBounds(920, 580, 100, 50);

		// Posicionamento das combobox para dados
		dadoAtq1.setLocation(1038, 350);
		dadoAtq2.setLocation(1078, 350);
		dadoAtq3.setLocation(1118, 350);
		dadoDef1.setLocation(1038, 410);
		dadoDef2.setLocation(1078, 410);
		dadoDef3.setLocation(1118, 410);
    }

	public void notify(Observable o) {
		Object obj = o.get();
		// Mudança nos territórios
		if (obj instanceof Boolean) {
			if (!(boolean)obj) {
				int fase = Controller.getFase();
				switch (fase) {
					case 0:
					case 1:
						if (possuiContinentes.isEmpty()) {
							comboBoxExerc();
						}
						else {
							comboBoxExercContinente(possuiContinentes.get(0));
						}
						break;
					case 3:
						comboBoxOrigem();
						break;
				}
			}
			else {
				comboBoxAtacante();
			}
		}
		else {
			// Mudança nos dados
			int dados[] = (int[]) obj;
			DadoView.getDadoView().setDados(dados);
			mostrarDados = true;
		}

		repaint();
	}

	private void faseRecebimento(boolean mudou) {
		// Se mudou a fase ou o jogador, atualiza a lista de continentes que ele possui
		if (mudou)
			possuiContinentes = Fachada.getFachada().getContinentesJogador();

		// Se tiver algum continente pendente para receber, recebe exercitos dele
		if (!possuiContinentes.isEmpty()) {
			comboBoxRecebimentoContinente(possuiContinentes.get(0));
			comboBoxExercContinente(possuiContinentes.get(0));
		} else {
			// Senão, recebe exercitos normalmente
			comboBoxRecebimento();
			comboBoxExerc();
		}

		// Configura os componentes
		cb3.setVisible(true);
		btnPosicionar.setVisible(true);
		btnCartas.setVisible(true);

		cb2.setVisible(false);
		btnAtacar.setVisible(false);
		btnAtaqueManipulado.setVisible(false);
		btnDeslocar.setVisible(false);
		proximoLabel.setVisible(false);
		btnSalvar.setVisible(false);
		visibilidadeDadosManipulados(false);
	}

	private void faseAtaque() {
		comboBoxAtacante();
		mostrarDados = false;

		// Configura os componentes
		cb2.setVisible(true);
		btnAtacar.setVisible(true);
		btnAtaqueManipulado.setVisible(true);
		proximoLabel.setVisible(true);
		visibilidadeDadosManipulados(true);

		cb3.setVisible(false);
		btnPosicionar.setVisible(false);
		btnDeslocar.setVisible(false);
		btnCartas.setVisible(false);
		btnSalvar.setVisible(false);
	}

	private void faseDeslocamento() {
		comboBoxOrigem();

		// Configura os componentes
		cb2.setVisible(true);
		cb3.setVisible(true);
		btnDeslocar.setVisible(true);
		proximoLabel.setVisible(true);
		btnSalvar.setVisible(true);
		
		btnPosicionar.setVisible(false);
		btnAtacar.setVisible(false);
		btnAtaqueManipulado.setVisible(false);
		btnCartas.setVisible(false);
		visibilidadeDadosManipulados(false);
	}

	private void visibilidadeDadosManipulados(boolean visivel) {
		dadoAtq1.setVisible(visivel);
		dadoAtq2.setVisible(visivel);
		dadoAtq3.setVisible(visivel);
		dadoDef1.setVisible(visivel);
		dadoDef2.setVisible(visivel);
		dadoDef3.setVisible(visivel);
	}

	private void zeraDado(JComboBox<Integer> dado) {
		// remove os itens da combobox
		dado.removeAllItems();
		// adiciona o 0
		dado.addItem(0);
	}

	private void preencheDado(JComboBox<Integer> dado) {
		// remove os itens da combobox
		dado.removeAllItems();
		// adiciona 1 até 6
		for (int i = 1; i <= 6; i++) {
			dado.addItem(i);
		}
	} 

	private void comboBoxRecebimento() {
		// remove os itens da combobox
		cb1.removeAllItems();

		// adiciona os itens na combobox
		List<String> territorios = Fachada.getFachada().territoriosJogador(Fachada.getFachada().atualJogador());
		Collections.sort(territorios);
		for (String territorio : territorios) {
			cb1.addItem(territorio);
		}
	}

	private void comboBoxRecebimentoContinente(String continente) {
		// remove os itens da combobox
		cb1.removeAllItems();

		// adiciona os itens na combobox
		List<String> territorios = Fachada.getFachada().territoriosContinente(continente);
		Collections.sort(territorios);
		for (String territorio : territorios) {
			cb1.addItem(territorio);
		}
	}

	private void comboBoxExerc() {
		// remove os itens da combobox
		cb3.removeAllItems();

		// adiciona os itens na combobox
		int numExerc = Fachada.getFachada().getRecebimento();
		while (numExerc > 0) {
			cb3.addItem(numExerc);
			numExerc--;
		}
	}

	private void comboBoxExercContinente(String continente) {
		// remove os itens da combobox
		cb3.removeAllItems();

		// adiciona os itens na combobox
		int numExerc = Fachada.getFachada().getRecebimentoContinente(continente);
		while (numExerc > 0) {
			cb3.addItem(numExerc);
			numExerc--;
		}
	}

	private void comboBoxAtacante() {
		// guarda o item que estava selecionado
		Object selected = cb1.getSelectedItem();

		// remove os itens da combobox
		cb1.removeAllItems();

		// adiciona os itens na combobox
		List<String> territorios = Fachada.getFachada().territoriosAtacante();
		Collections.sort(territorios);
		for (String territorio : territorios) {
			cb1.addItem(territorio);
		}

		// seleciona o item que estava selecionado
		if (selected != null)
			cb1.setSelectedItem(selected);
		else {
			cb2.removeAllItems();
		}
	}

	private void comboBoxDefensor(String territorioAtacante) {
		// guarda o item que estava selecionado
		Object selected = cb2.getSelectedItem();

		// remove os itens da combobox
		cb2.removeAllItems();

		// adiciona os itens na combobox
		List<String> territorios = Fachada.getFachada().territoriosDefensor(territorioAtacante);
		Collections.sort(territorios);
		for (String territorio : territorios) {
			cb2.addItem(territorio);
		}

		// seleciona o item que estava selecionado
		if (selected != null && territorios.contains(selected)) {
			System.out.println("selected: " + selected);
			cb2.setSelectedItem(selected);
		}
	}

	private void comboBoxOrigem() {
		// guarda o item que estava selecionado
		Object selected = cb1.getSelectedItem();

		// remove os itens da combobox
		cb1.removeAllItems();

		// adiciona os itens na combobox
		List<String> territorios = Fachada.getFachada().territoriosOrigem();
		Collections.sort(territorios);
		for (String territorio : territorios) {
			cb1.addItem(territorio);
		}

		// seleciona o item que estava selecionado
		if (selected != null)
			cb1.setSelectedItem(selected);
		else {
			cb2.removeAllItems();
			cb3.removeAllItems();
		}
	}

	private void comboBoxDestino(String territorioOrigem) {
		// guarda o item que estava selecionado
		Object selected = cb2.getSelectedItem();

		// remove os itens da combobox
		cb2.removeAllItems();

		// adiciona os itens na combobox
		List<String> territorios = Fachada.getFachada().territoriosDestino(territorioOrigem);
		Collections.sort(territorios);
		for (String territorio : territorios) {
			cb2.addItem(territorio);
		}

		// seleciona o item que estava selecionado
		if (selected != null)
			cb2.setSelectedItem(selected);
	}

	private void comboBoxExercDeslocamento(String territorioOrigem) {
		// remove os itens da combobox
		cb3.removeAllItems();

		// adiciona os itens na combobox
		int numExerc = Fachada.getFachada().qtdExercDesloc(territorioOrigem);
		while (numExerc > 0) {
			cb3.addItem(numExerc);
			numExerc--;
		}
	}

	private void faseFim() {
		// Fecha o frame principal do jogo
		SwingUtilities.getWindowAncestor(this).dispose();

		Color cor = stringToColor(Fachada.getFachada().atualJogador());
		String vencedor = Fachada.getFachada().nomeAtualJogador();

		// Abre o frame de fim de jogo
		new FimFrame("War", cor, vencedor);
	}

	// variando a cor do jogador precisamos saber qual a cor dele para pintar o territorio de acordo.
	private Color stringToColor(String cor) {
		switch(cor) {
			case "amarelo":
	            return amareloCustom;
	        case "vermelho":
	            return Color.RED;
	        case "azul":
	            return Color.BLUE;
	        case "branco":
	            return Color.WHITE;
	        case "preto":
	            return Color.BLACK;
	        case "verde":
	            return verdeCustom;
	        default:
	            return null;
		}
	}

	private void desenhaTerritorios(Map<String,TerritorioView> territoriosView, Graphics2D g2d){
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
				territorioView.desenha(g2d, amareloCustom, fachada.qtdExerc(territorio));
			}
		}

		// territorios verde
		territoriosJogador = fachada.territoriosJogador("verde");
		if (territoriosJogador!=null)
		{
			for (String territorio : territoriosJogador) {
				TerritorioView territorioView = territoriosView.get(territorio);
				territorioView.desenha(g2d, verdeCustom, fachada.qtdExerc(territorio));
			}
		}
	}

	// ANOTA O NOME DOS TERRITORIOS NO TABULEIRO
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
    	territorios.put("MÉXICO", new TerritorioView(150,315,120,298,"MÉXICO"));
    	
    	// América do Sul
    	territorios.put("VENEZUELA", new TerritorioView(192,375,165,360,"VENEZUELA"));
    	territorios.put("PERU", new TerritorioView(230,425,218,407,"PERU"));
    	territorios.put("BRASIL", new TerritorioView(289,397,268,380,"BRASIL"));
    	territorios.put("ARGENTINA", new TerritorioView(279,495,250,472,"ARGENTINA"));
    	
    	// Oceania
    	territorios.put("PERTH", new TerritorioView(788,528,770,513,"PERTH"));
    	territorios.put("AUSTRÁLIA", new TerritorioView(844,551,820,535,"AUSTRÁLIA"));
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
