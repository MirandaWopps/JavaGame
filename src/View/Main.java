package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Font;

public class Main {
	public static void main (String[] args) {
		JFrame fr= new JFrame();
		fr.setBounds(10,10,1024,768);
		fr.setDefaultCloseOperation(3);
		JPanel pn = new JPanel() {
			@Override
			public void paint(Graphics g) {
				g.drawRect(200, 200, 600, 150);
				g.drawRect(200, 400, 600, 150);
				g.drawString("Jogar", 450,300);
				g.drawString("Carregar", 450,500);
			}
			
		};
	fr.add(pn);
	fr.setVisible(true);
	

	
	}
}
