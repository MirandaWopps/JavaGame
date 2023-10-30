package View;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CartasFrame2 extends JFrame{
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	
	private ImageIcon img1; // 1
	private ImageIcon img2; // 2
	private ImageIcon img3;
	private ImageIcon img4;
	private ImageIcon img5;
	private JLabel labelCartas;
	
	// Cartas
	String war_carta_coringa = "Imagens/war_carta_coringa.png";//41
	String war_carta_oc_australia = "Imagens/war_carta_oc_australia.png";//50
	String war_carta_oc_indonesia = "Imagens/war_carta_oc_indonesia.png";//51
	String war_carta_oc_novazelandia = "Imagens/war_carta_oc_novazelandia.png";//52
	String war_carta_oc_perth = "Imagens/war_carta_oc_perth.png";//53
	
	CartasFrame2(){
		setLayout(new FlowLayout());
		img1 = new ImageIcon(getClass().getResource(war_carta_oc_australia) );
		label1 = new JLabel(img1);
		add(label1);
		
		img2 = new ImageIcon(getClass().getResource(war_carta_oc_indonesia) );
		label1 = new JLabel(img1);
		add(label1);
		
		img3 = new ImageIcon(getClass().getResource(war_carta_oc_novazelandia) );
		label1 = new JLabel(img1);
		add(label1);
		
		img4 = new ImageIcon(getClass().getResource(war_carta_oc_perth) );
		label1 = new JLabel(img1);
		add(label1);
		
		img5 = new ImageIcon(getClass().getResource(war_carta_coringa) );
		label1 = new JLabel(img1);
		add(label1);
	}
	
	public static void main(String args[]) {
		CartasFrame2 gui = new CartasFrame2();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.pack();
		gui.setTitle("Cartas");
	}
	
}
