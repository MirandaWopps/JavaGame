package View;

import java.awt.*;

import javax.swing.*;

public class PanelTabuleiro extends JPanel {
	Image mapa;
	Image fundo;
	
	public PanelTabuleiro(Image mapa, Image fundo) {
		this.mapa = mapa;
		this.fundo = fundo;
	}
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(fundo,0,0,1000,700,null);
        g.drawImage(mapa,0,-30,1000,700,null);
    }
}
