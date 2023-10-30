package View;

import javax.swing.*;
import java.awt.*;

public class WarFrame extends JFrame{      
	public final int LARG_DEFAULT=1200; // tam horizontal da tela
	public final int ALT_DEFAULT=700;   // altura da tela
	PanelTabuleiro p; // objeto painel
	
	public WarFrame(String s) {  // recebe como parametros uma string, uma imagem e outra imagem.
		super(s);
		setLayout(null);
		setSize(LARG_DEFAULT,ALT_DEFAULT); // setando o tam 
		setResizable(false);               // nao permite redimensionar a tela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quando clicar no X, fecha o programa
		
		Toolkit tk=Toolkit.getDefaultToolkit();  
		Dimension screenSize=tk.getScreenSize(); 
		int sl=screenSize.width;     
		int sa=screenSize.height;   
		int x=sl/2-LARG_DEFAULT/2;  
		int y=sa/2-ALT_DEFAULT/2;   
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);   
		
		p = new PanelTabuleiro();
		p.setBounds(0,0,LARG_DEFAULT,ALT_DEFAULT);   
		getContentPane().add(p);
	}
	
	public void setFase(int fase) {
		p.setFase(fase);
	}
	
}
