package View;

import java.awt.*;
import java.awt.geom.*;


public class TerritorioView {
	private static Font fonteNome = new Font("SERIF", Font.BOLD, 10);
	private static Font fonteExerc = new Font("Arial", Font.BOLD, 12);
	
	private int x_exerc;
	private int y_exerc;
	private int x_nome;
	private int y_nome;
	private String nome;
	
	TerritorioView(int x_exerc, int y_exerc, int x_nome, int y_nome, String nome) {
		this.x_exerc = x_exerc;
		this.y_exerc = y_exerc;
		this.x_nome = x_nome;
		this.y_nome = y_nome;
		this.nome = nome;
	}
	
	public void desenha(Graphics2D g2d, Color cor, int qtdExerc) {
		Ellipse2D circ= new Ellipse2D.Double();
		circ.setFrameFromCenter(x_exerc,y_exerc,x_exerc+10,y_exerc+10);
		g2d.setPaint(cor);
		g2d.fill(circ);
		g2d.draw(circ);

		g2d.setFont(fonteExerc);
		g2d.setPaint(Color.BLACK);
		g2d.drawString(Integer.toString(qtdExerc), x_exerc-3, y_exerc+5);	
		
		g2d.setFont(fonteNome);
		g2d.setPaint(Color.WHITE);
		g2d.drawString(nome, x_nome, y_nome);
	}

}
