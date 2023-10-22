package View;

import javax.swing.*;
import java.awt.*;

public class WarFrame extends JFrame{
	public final int LARG_DEFAULT=1200;
	public final int ALT_DEFAULT=700;
	JPanel p;
	
	public WarFrame(String s, Image mapa, Image fundo) {
		super(s);
		setLayout(null);
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		
		p = new PanelTabuleiro(mapa, fundo);
		p.setBounds(0,0,LARG_DEFAULT,ALT_DEFAULT);
		getContentPane().add(p);
	}
	
	
}
