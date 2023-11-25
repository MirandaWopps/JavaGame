package View;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DadoView { // singleton
	private Image dadosAtq[] = new Image[6];
    private Image dadosDef[] = new Image[6];
    private int dados[] = new int[6];
    private static DadoView dadoView = null;

    private DadoView() {
        try { // tente anexar as imagens aos dados
            dadosAtq[0] = ImageIO.read(new File("Imagens/dado_ataque_1.png"));
            dadosAtq[1] = ImageIO.read(new File("Imagens/dado_ataque_2.png"));
            dadosAtq[2] = ImageIO.read(new File("Imagens/dado_ataque_3.png"));
            dadosAtq[3] = ImageIO.read(new File("Imagens/dado_ataque_4.png"));
            dadosAtq[4] = ImageIO.read(new File("Imagens/dado_ataque_5.png"));
            dadosAtq[5] = ImageIO.read(new File("Imagens/dado_ataque_6.png"));
            dadosDef[0] = ImageIO.read(new File("Imagens/dado_defesa_1.png"));
            dadosDef[1] = ImageIO.read(new File("Imagens/dado_defesa_2.png"));
            dadosDef[2] = ImageIO.read(new File("Imagens/dado_defesa_3.png"));
            dadosDef[3] = ImageIO.read(new File("Imagens/dado_defesa_4.png"));
            dadosDef[4] = ImageIO.read(new File("Imagens/dado_defesa_5.png"));
            dadosDef[5] = ImageIO.read(new File("Imagens/dado_defesa_6.png"));
        } // do contrario exiba que deu erro e feche a aplicacao
        catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        // todos os dados recebem 0;
        for (int i = 0; i < 6; i++)
            dados[i] = 0;
    }

    static DadoView getDadoView() {
        if (dadoView == null)
            dadoView = new DadoView();
        return dadoView;
    }

    // DESENHA OS DADOS
    void mostrarDados(Graphics2D g2d) {
        // Mostra os dados de ataque
        for (int i = 0; i < 3; i++) {
            if (dados[i] < 1)
                break;
            g2d.drawImage(dadosAtq[dados[i]-1], 1038+40*i, 230, 30, 30, null);
        }

        // Mostra os dados de defesa
        for (int i = 3; i < 6; i++) {
            if (dados[i] < 1)
                break;
            g2d.drawImage(dadosDef[dados[i]-1], 1038+40*(i-3), 280, 30, 30, null);
        }
    }

    void setDados(int dados[]) {
        for (int i = 0; i < 6; i++)
            this.dados[i] = dados[i];
    }
}
