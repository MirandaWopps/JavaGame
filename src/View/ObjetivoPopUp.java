package View;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;

class ObjetivoPopUp extends JPopupMenu {
    private JLabel mensagemObjetivo;
    private Image imagemFundo;

    ObjetivoPopUp() {
        try {
            imagemFundo = ImageIO.read(new File("Imagens/war_carta_objetivo_grande.png"));
        } catch(IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        setLayout(null);

        // Cria o label que vai conter a mensagem do objetivo
        mensagemObjetivo = new JLabel();
        mensagemObjetivo.setFont(new Font("Arial", Font.BOLD, 24));
        add(mensagemObjetivo);

        // Seta o tamanho do popup para o tamanho da imagem de fundo
        setPreferredSize(new Dimension(imagemFundo.getWidth(null), imagemFundo.getHeight(null)));
    }

    public void mostra(Component invoker, String objetivo) {
        // Seta a mensagem do objetivo
        mensagemObjetivo.setText("<html><div style='width:240px; text-align: center;'>" + objetivo + "</div></html>");

        // Centraliza o popup na tela
        int x = (invoker.getWidth() - this.getPreferredSize().width) / 2;
        int y = (invoker.getHeight() - this.getPreferredSize().height) / 2;
        show(invoker, x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        // Desenha a imagem de fundo
        g2d.drawImage(imagemFundo, 0, 0, null);
        // Posiciona o label da mensagem do objetivo
        mensagemObjetivo.setLocation(22, 120);
    }
}
