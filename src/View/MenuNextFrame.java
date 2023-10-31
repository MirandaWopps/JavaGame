package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MenuNextFrame extends JFrame implements ActionListener{

	private JButton button;     // Declare button as an instance variable
	private JTextField textField; // Declare textField as an instance variable
	private JTextField textField2; // Declare textField as an instance variable
	private JTextField textField3; // Declare textField as an instance variable
	private JTextField textField4; // Declare textField as an instance variable
	private JTextField textField5; // Declare textField as an instance variable
	private JTextField textField6; // Declare textField as an instance variable
	
	MenuNextFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button = new JButton("Confirmar");
		button.addActionListener(this);
		
		textField = new JTextField(); 
		textField.setPreferredSize(new Dimension(250,40));
		
		textField2 = new JTextField(); 
		textField.setPreferredSize(new Dimension(250,40));
		
		textField3 = new JTextField(); 
		textField.setPreferredSize(new Dimension(250,40));
		
		textField4 = new JTextField(); 
		textField.setPreferredSize(new Dimension(250,40));
		
		textField5 = new JTextField(); 
		textField.setPreferredSize(new Dimension(250,40));
		
		textField6 = new JTextField(); 
		textField.setPreferredSize(new Dimension(250,40));
		
		//textField.setFont(new Font("Consolas",Font.PLAIN,35);
		//textField.setForeground(new Color(0x00FF00));
		textField.setText("Quantidade Jogadores");
		textField2.setText("Nome Jogador 1");
		textField3.setText("Nome Jogador 2");
		textField4.setText("Nome Jogador 3");
		textField5.setText("Nome Jogador 4");
		textField6.setText("Nome Jogador 5");
		textField6.setText("Nome Jogador 6");
		
		
		this.add(button);
		this.add(textField);
		this.add(textField2);
		this.add(textField3);
		this.add(textField4);
		this.add(textField5);
		this.add(textField6);
		
		
		this.pack();
		this.setSize(1200,700);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == button) {
			System.out.println("Jogador 1: " + textField.getText() );
			System.out.println("Jogador 2: " + textField2.getText() );
			System.out.println("Jogador 3: " + textField3.getText() );
			System.out.println("Jogador 4: " + textField4.getText() );
			System.out.println("Jogador 5: " + textField5.getText() );
			System.out.println("Jogador 6: " + textField6.getText() );
		}
			
		
	}
	
	
	
}