package Controller;

import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;

import View.WarFrame;

public class Controller {

	public static void main(String[] args) {
		WarFrame f = null;
		try {
			f = new WarFrame("War", ImageIO.read(new File("Imagens/war_tabuleiro_mapa copy.png")), ImageIO.read(new File("Imagens/war_tabuleiro_fundo.png")));
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println("Coordenadas: (" + x + ", " + y + ")");
            }
        });
		f.setVisible(true);

	}

}
