package View;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class PanelTabuleiro extends JPanel {
	Image mapa;
	Image fundo;
	private List<TerritorioView> territorios = new ArrayList<>();
	
	public PanelTabuleiro(Image mapa, Image fundo) {
		this.mapa = mapa;
		this.fundo = fundo;
		
		territorios.add(new TerritorioView(321,80,285,65,"GROENLÂNDIA", Color.YELLOW));
	}
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;

        g2d.drawImage(fundo,0,0,1000,700,null);
        g2d.drawImage(mapa,0,-30,1000,700,null);
        
        for (TerritorioView territorio : territorios) {
        	territorio.desenha(g2d);
        }
    }
}
