package src.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MenuNextFrame extends JFrame implements ActionListener{

	// declares an array of integers
    private String jogadoresArray[] = new String[6];     // allocates memory for 6 Strings
    private String coresArray[] = new String[6];     // allocates memory for 6 Strings
    private String qtdJogadoresString;  // esta dando erro fazer o casting dentro do listener
    private int qtdJogadores;
	
	private JButton button;     // Declare button as an instance variable
	private JTextField jogadoresField;
	private JTextField textField1; // Declare textField as an instance variable
	private JTextField textField2; // Declare textField as an instance variable
	private JTextField textField3; // Declare textField as an instance variable
	private JTextField textField4; // Declare textField as an instance variable
	private JTextField textField5; // Declare textField as an instance variable
	private JTextField textField6; // Declare textField as an instance variable
	
	private JTextField textFieldCor1; // Declare textField as an instance variable
	private JTextField textFieldCor2; 
	private JTextField textFieldCor3; 
	private JTextField textFieldCor4; 
	private JTextField textFieldCor5; 
	private JTextField textFieldCor6; 
	
	MenuNextFrame(){
		this.setTitle("Escolha de Jogadores");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		
		// Botao
		button = new JButton("Confirmar");
		button.addActionListener(this);
		//button.setForeground(Color.cyan); // a cor do texto do botao
		button.setBackground(Color.lightGray ); // a cor do botao
		button.setBorder(BorderFactory.createEtchedBorder() );//o tipo da borda
		
		// Text Fields
		jogadoresField = new JTextField(); 
		jogadoresField.setPreferredSize(new Dimension(250,40));
		
		textField1 = new JTextField(); 
		textField1.setPreferredSize(new Dimension(250,40));
		
		textField2 = new JTextField(); 
		textField2.setPreferredSize(new Dimension(250,40));
		
		textField3 = new JTextField(); 
		textField3.setPreferredSize(new Dimension(250,40));
		
		textField4 = new JTextField(); 
		textField4.setPreferredSize(new Dimension(250,40));
		
		textField5 = new JTextField(); 
		textField5.setPreferredSize(new Dimension(250,40));
		
		textField6 = new JTextField(); 
		textField6.setPreferredSize(new Dimension(250,40));
		
		
		
		textFieldCor1 = new JTextField(); 
		textFieldCor1.setPreferredSize(new Dimension(250,40));
		
		textFieldCor2 = new JTextField(); 
		textFieldCor2.setPreferredSize(new Dimension(250,40));
		
		textFieldCor3 = new JTextField(); 
		textFieldCor3.setPreferredSize(new Dimension(250,40));
		
		textFieldCor4 = new JTextField(); 
		textFieldCor4.setPreferredSize(new Dimension(250,40));
		
		textFieldCor5 = new JTextField(); 
		textFieldCor5.setPreferredSize(new Dimension(250,40));
		
		textFieldCor6 = new JTextField(); 
		textFieldCor6.setPreferredSize(new Dimension(250,40));
		
		//textField.setFont(new Font("Consolas",Font.PLAIN,35);
		//textField.setForeground(new Color(0x00FF00));
		jogadoresField.setText("Quantidade Jogadores");
		textField1.setText("Nome Jogador 1");
		textField2.setText("Nome Jogador 2");
		textField3.setText("Nome Jogador 3");
		textField4.setText("Nome Jogador 4");
		textField5.setText("Nome Jogador 5");
		textField6.setText("Nome Jogador 6");
		
		textFieldCor1.setText("Cor Jogador 1");
		textFieldCor2.setText("Cor Jogador 2");
		textFieldCor3.setText("Cor Jogador 3");
		textFieldCor4.setText("Cor Jogador 4");
		textFieldCor5.setText("Cor Jogador 5");
		textFieldCor6.setText("Cor Jogador 6");
		
		// qtdJogadores e Nome dos jogadores
		this.add(jogadoresField);
		this.add(textField1);
		this.add(textField2);
		this.add(textField3);
		this.add(textField4);
		this.add(textField5);
		this.add(textField6);
		
		this.add(textFieldCor1);
		this.add(textFieldCor2);
		this.add(textFieldCor3);
		this.add(textFieldCor4);
		this.add(textFieldCor5);
		this.add(textFieldCor6);
		
		this.add(button);
		
		this.pack();
		this.setSize(300,675);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			qtdJogadores = Integer.parseInt( jogadoresField.getText()   );  // falta exception para qnd tiver texto
			//qtdJogadoresString = jogadoresField.getText();
			//qtdJogadores = Integer.parseInt(qtdJogadoresString)  ;
			jogadoresArray[0] = textField1.getText();  // Armazenando		
			jogadoresArray[1] = textField2.getText();
			jogadoresArray[2] = textField3.getText();
			jogadoresArray[3] = textField4.getText();		
			jogadoresArray[4] = textField5.getText();
			jogadoresArray[5] = textField6.getText();
			
			coresArray[0] = textFieldCor1.getText();  // Armazenando		
			coresArray[1] = textFieldCor2.getText();
			coresArray[2] = textFieldCor3.getText();
			coresArray[3] = textFieldCor4.getText();		
			coresArray[4] = textFieldCor5.getText();
			coresArray[5] = textFieldCor6.getText();
			
			
			
			
			System.out.println(qtdJogadores);
			System.out.println("Cor: " + coresArray[0]+"\n"); 	
			
			for (int i= 0 ; i<6 ;i++) {
				// crie um vetor e adicione a cor ali. Entao, verifique se a cor da vez aparece quando o vetor for percorrido
				
				
			       // Vermelho                           // Verde                         // Azul                   // Preto                      // Branco                // Amarelo		
				if ( coresArray[i].equals("Vermelho") || coresArray[i].equals("Verde") || coresArray[i].equals("Azul") || coresArray[i].equals("Preto") || coresArray[i].equals("Branco") || coresArray[i].equals("Amarelo") ){
					System.out.println("Nome: " + jogadoresArray[i]); //
					System.out.println("Cor: " + coresArray[i]+"\n"); 		
				}	else {
					System.out.println("NAO INSERIU COR CORRETAMENTE");
					break;
				} // else
			}// for
			
		}// evento no botao				
	}// action performed
	
	
	
	
	
	
	// NECESSARIA VERIFICACAO DAS CORES
	//
	// cria vetor
	// faça 2 for: verifica se existe alguma repetida - ps: atencao quando o for chegar no indice da cor em questão
	/*
	for(int i =0 ; i<6; i++ ) {
		coresArray[i];
		System.out.println("Jogador 4: " + textField4.getText() ); //
		
	}
	// coloca um break se der achar repetida. O código precisa 
	*/
	
	
}