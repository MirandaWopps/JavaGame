package View;

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
		
		//textField.setFont(new Font("Consolas",Font.PLAIN,35);
		//textField.setForeground(new Color(0x00FF00));
		jogadoresField.setText("Quantidade Jogadores");
		textField1.setText("Nome Jogador 1");
		textField2.setText("Nome Jogador 2");
		textField3.setText("Nome Jogador 3");
		textField4.setText("Nome Jogador 4");
		textField5.setText("Nome Jogador 5");
		textField6.setText("Nome Jogador 6");
		
		
		this.add(jogadoresField);
		this.add(textField1);
		this.add(textField2);
		this.add(textField3);
		this.add(textField4);
		this.add(textField5);
		this.add(textField6);
		this.add(button);
		
		this.pack();
		this.setSize(300,400);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			qtdJogadoresString = jogadoresField.getText();
			coresArray[0] = textField1.getText();  // Armazenando		
			coresArray[1] = textField2.getText();
			coresArray[2] = textField3.getText();
			coresArray[3] = textField4.getText();		
			coresArray[4] = textField5.getText();
			coresArray[5] = textField6.getText();
			
			
			for (int i= 0 ; i<6 ;i++) {
			       // Vermelho                           // Verde                         // Azul                   // Preto                      // Branco                // Amarelo
			
				//if ( (coresArray[i] =="Vermelho") || (coresArray[i] =="Verde") || (coresArray[i] =="Azul") || (coresArray[i] =="Preto") || (coresArray[i] =="Branco") || (coresArray[i] =="Amarelo") ){
					System.out.println("Nome: " + coresArray[i]); //
				}
			
			
			//}
			
		}		

		
		
		
	}
	
	
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