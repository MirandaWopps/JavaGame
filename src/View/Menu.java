package View;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Menu extends JFrame {

	
	public static void main (String[] args) throws IOException {
		//ImageIcon image = new ImageIcon("Imagens\\menuImage.jpg");
	
		ImageIcon ico = new ImageIcon("Imagens\\windowIcon.ico");
		
		//img = ImageIO.read( new File("menuImage.jpg" ));
		
				
		JFrame fr= new JFrame();
		fr.setTitle("War");
		fr.setBounds(200,200,1200,700);  // diz onde a tela surgira e cria nas dimensoes desejadas
		fr.setDefaultCloseOperation(3);
		fr.setIconImage(ico.getImage()); // icone para janela


		//private BufferedImage img = null;
		
		//private ImageIcon img;
		
		
		
		
		//fr.setIcon(image);
		//fr.add(image);
		//f = new WarFrame("War", ImageIO.read(new File("Imagens/coolMenuImage.jpg"))   );
		
		
		//ImageIcon img = new ImagemIcon(this.getClass().getResouce("/coolMenuImage.jpg"));
		//fr.setIcon(img);
		
		
		JPanel pn = new JPanel() {
			@Override
			public void paint(Graphics g) {
				
				//g.drawImage( img, 0, 0, this );
				g.drawRect(200, 200, 600, 150); // drawRect(int x, int y, int width, int height)  
				g.drawRect(200, 400, 600, 150);
				g.drawString("Jogar", 450,300);
				g.drawString("Carregar", 450,500);
			}
			
		};

	fr.add(pn);
	
	
	fr.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            if ( (x > 200 && x < 800)   && (y > 200 && y < 350)    ) {
            System.out.println("INICIANDO NOVO JOGO");
        }
            
            if ( (x > 200 && x < 400)   && (y > 400 && y < 650)    ) {
            System.out.println("CARREGANDO JOGO");
        }
        }
    });
	
	

	fr.setVisible(true);
	
	}
}



