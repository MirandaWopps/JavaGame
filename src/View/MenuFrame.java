package View;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MenuFrame extends JFrame{
	private static final int LARG_DEFAULT=700; // tam horizontal da tela
	private static final int ALT_DEFAULT=400;   // altura da tela
	
	public MenuFrame (String s) {
		super(s);
		setLayout(null);
		setSize(LARG_DEFAULT,ALT_DEFAULT); // setando o tamanho
		setResizable(false);               // nao permite redimensionar a tela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quando clicar no X, fecha o programa
		
		// centralizar a janela
		Toolkit tk=Toolkit.getDefaultToolkit();  
		Dimension screenSize=tk.getScreenSize(); 
		int sl=screenSize.width;     
		int sa=screenSize.height;   
		int x=sl/2-LARG_DEFAULT/2;  
		int y=sa/2-ALT_DEFAULT/2;   
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		
        JLabel l = new JLabel(); 
        l.setIcon(new ImageIcon("Imagens/menuImage.jpg"));
        l.setBounds(0,0,LARG_DEFAULT,ALT_DEFAULT);

		Container c = getContentPane();

        // criação dos botões
        JButton button1 = new JButton("Novo Jogo");
        button1.setBounds(275, 100, 150, 40);
        JButton button2 = new JButton("Carregar");
        button2.setBounds(275, 180, 150, 40);
        
        // Adiciona action listener ao button1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
                IntermediariaComCombo f = new IntermediariaComCombo("War");
                f.setVisible(true);
            }
        });

        // Adiciona action listener ao button2
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Carregando !");
            }
        });
        
        
        // Adiciona os botões
        c.add(button1);
        c.add(button2);
        
        // Adiciona imagem de background
        c.add(l);
	}
}
