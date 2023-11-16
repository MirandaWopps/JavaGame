package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Model.Fachada;

public class FimFrame extends JFrame {
	private static final int LARG_DEFAULT=700; // tam horizontal da tela
	private static final int ALT_DEFAULT=400;   // altura da tela

    public FimFrame(String s, Color corDeFundo, String mensagem) {
        super(s);
        setLayout(null);
		setSize(LARG_DEFAULT,ALT_DEFAULT); // setando o tamanho
		setResizable(false);               // nao permite redimensionar a tela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // quando clicar no X, fecha o programa

        // centralizar a janela
		Toolkit tk=Toolkit.getDefaultToolkit();  
		Dimension screenSize=tk.getScreenSize(); 
		int sl=screenSize.width;     
		int sa=screenSize.height;   
		int x=sl/2-LARG_DEFAULT/2;  
		int y=sa/2-ALT_DEFAULT/2;   
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);

        // Seta a cor de fundo do frame
        getContentPane().setBackground(corDeFundo);

        // Cria uma label para exibir a mensagem
        JLabel label = new JLabel(mensagem + " venceu!");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(0, 0, 400, 50);
        label.setLocation((LARG_DEFAULT - label.getWidth()) / 2, 50);
        label.setHorizontalAlignment(SwingConstants.CENTER); // centraliza o texto

        // Cria um botão para continuar
        JButton botaoContinuar = new JButton("Continuar");
        botaoContinuar.setBounds((LARG_DEFAULT - 100) / 2, 150, 100, 50);

        // Adiciona um ActionListener ao botão
        botaoContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fecha o frame atual
                dispose();
                
                // Termina o jogo
                Fachada.getFachada().terminaJogo();

                // Cria um novo MenuFrame
                MenuFrame menuFrame = new MenuFrame("War");
                menuFrame.setVisible(true);
            }
        });

        // Adiciona a label e o botão ao frame
        add(label);
        add(botaoContinuar);

        setVisible(true);
    }
}
