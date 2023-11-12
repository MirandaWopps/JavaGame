package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntermediariaComCombo {
	
	private static JTextField textField1; // Declare textField as an instance variable
	private static JTextField textField2; // Declare textField as an instance variable
	private static JTextField textField3; // Declare textField as an instance variable
	private static JTextField textField4; // Declare textField as an instance variable
	private static JTextField textField5; // Declare textField as an instance variable
	private static JTextField textField6; // Declare textField as an instance variable
	

	public static String [][] matrizCorJogador = new String[6][2]; // 6 linhas porque temos 6 jogadores e 2 colunas para adquirir nome e cor
	
	
	// verficação das cores
	private static int impedeTrocarTela;
	private static int qtdRepeticoes2;
	
    public static void main(String[] args) {
    	javax.swing.SwingUtilities.invokeLater(() -> {
    		
    	
        JFrame frame = new JFrame("Integer Combo Box Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JPanel panel2Selected = new JPanel();


        
        textField1 = new JTextField(); 
		textField1.setPreferredSize(new Dimension(150,40));
    	
		textField2 = new JTextField(); 
		textField2.setPreferredSize(new Dimension(150,40));
        
        textField3 = new JTextField(); 
		textField3.setPreferredSize(new Dimension(150,40));
    	
		textField4 = new JTextField(); 
		textField4.setPreferredSize(new Dimension(150,40));
		
		textField5 = new JTextField(); 
		textField5.setPreferredSize(new Dimension(150,40));
		
		textField6 = new JTextField(); 
		textField6.setPreferredSize(new Dimension(150,40));
		
		textField1.setText("Nome Jogador 1");
		textField2.setText("Nome Jogador 2");
		textField3.setText("Nome Jogador 3");
		textField4.setText("Nome Jogador 4");
		textField5.setText("Nome Jogador 5");
		textField6.setText("Nome Jogador 6");
		
        
     // configuracoes do painel qtd2

        // Create an array of Integer objects
        Integer[] integers = { 2, 3, 4, 5, 6};
        // Create a JComboBox with Integer items
        JComboBox<Integer> integerComboBox = new JComboBox<>(integers);
        
        
       
        String[] cores = {"vermelho", "verde", "azul", "preto" , "branco", "amarelo"}; // vetor de cores
        JComboBox<String> comboJogador1 = new JComboBox<>(cores); // crio o combo para o jogador 1 COM A ESPECIFICAÇÃO DAS CORES NA STRING ACIMA
        JComboBox<String> comboJogador2 = new JComboBox<>(cores);
        JComboBox<String> comboJogador3 = new JComboBox<>(cores);
        JComboBox<String> comboJogador4 = new JComboBox<>(cores);
        JComboBox<String> comboJogador5 = new JComboBox<>(cores);
        JComboBox<String> comboJogador6 = new JComboBox<>(cores);

        
        
        
        
        
        JButton printButton = new JButton("Confirmar");
        JButton prosseguirButton = new JButton("Começar");  // lembrar de acrescentar este  
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer selectedInteger = (Integer) integerComboBox.getSelectedItem();
                System.out.println("Selected Integer: " + selectedInteger);
                
                if (selectedInteger== 2) {
                	panel2Selected.removeAll();
                	panel2Selected.add(textField1);
                    panel2Selected.add(comboJogador1);
             		panel2Selected.add(textField2);
             		panel2Selected.add(comboJogador2);
             		panel2Selected.add(prosseguirButton);
                    panel2Selected.setVisible(false); 
                }
                
                
                else if (selectedInteger== 3) {		
                	panel2Selected.removeAll();
                	panel2Selected.add(textField1);
                    panel2Selected.add(comboJogador1);
            		panel2Selected.add(textField2);
            		panel2Selected.add(comboJogador2);
            		panel2Selected.add(textField3);
            		panel2Selected.add(comboJogador3);
            		panel2Selected.add(prosseguirButton);
                    panel2Selected.setVisible(false); 
                }
                
                
                else if (selectedInteger== 4) {		
                	panel2Selected.removeAll();
                	panel2Selected.add(textField1);
                    panel2Selected.add(comboJogador1);
            		panel2Selected.add(textField2);
            		panel2Selected.add(comboJogador2);
            		panel2Selected.add(textField3);
            		panel2Selected.add(comboJogador3);
            		panel2Selected.add(textField4);
            		panel2Selected.add(comboJogador4);
            		panel2Selected.add(prosseguirButton);
                    panel2Selected.setVisible(false);  
                }
                
                
                else if (selectedInteger== 5) {		
                	panel2Selected.removeAll();
                	panel2Selected.add(textField1);
                    panel2Selected.add(comboJogador1);
            		panel2Selected.add(textField2);
            		panel2Selected.add(comboJogador2);
            		panel2Selected.add(textField3);
            		panel2Selected.add(comboJogador3);
            		panel2Selected.add(textField4);
            		panel2Selected.add(comboJogador4);
            		panel2Selected.add(textField5);
            		panel2Selected.add(comboJogador5);
            		panel2Selected.add(prosseguirButton);
                    panel2Selected.setVisible(false); 
                }
                
                
                else if (selectedInteger== 6) {
                	panel2Selected.removeAll();
                	panel2Selected.add(textField1);
                    panel2Selected.add(comboJogador1);
            		panel2Selected.add(textField2);
            		panel2Selected.add(comboJogador2);
            		panel2Selected.add(textField3);
            		panel2Selected.add(comboJogador3);
            		panel2Selected.add(textField4);
            		panel2Selected.add(comboJogador4);
            		panel2Selected.add(textField5);
            		panel2Selected.add(comboJogador5);
            		panel2Selected.add(textField6);
            		panel2Selected.add(comboJogador6);
            		panel2Selected.add(prosseguirButton);
                    panel2Selected.setVisible(false); 
                    

                }
                
             // exibe na tela
            	panel2Selected.setVisible(!panel2Selected.isVisible());  
                 // Repack the frame to adjust its size
                 frame.pack();
        
            }
        });
        
        
        // ------------------------ PAROU DE FUNCIONAR NESSE BLOCO DE LISTENER -----------------------------
        
        
        
        // BOTAO prosseguir
        prosseguirButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	Integer selectedInteger = (Integer) integerComboBox.getSelectedItem();
            	if (selectedInteger ==2){
            		matrizCorJogador[0][0] = textField1.getText();     matrizCorJogador[0][1] = (String) comboJogador1.getSelectedItem();     
            		matrizCorJogador[1][0] = textField2.getText();     matrizCorJogador[1][1] = (String)comboJogador2.getSelectedItem();  
            		matrizCorJogador[2][0] = textField3.getText();     matrizCorJogador[2][1] = null;
            		matrizCorJogador[3][0] = textField4.getText();     matrizCorJogador[3][1] = null;
            		matrizCorJogador[4][0] = textField5.getText();     matrizCorJogador[4][1] = null;
            		matrizCorJogador[5][0] = textField6.getText();     matrizCorJogador[5][1] = null;
            	} else if (selectedInteger ==3) {
            		matrizCorJogador[0][0] = textField1.getText();     matrizCorJogador[0][1] = (String)comboJogador1.getSelectedItem();     
            		matrizCorJogador[1][0] = textField2.getText();     matrizCorJogador[1][1] = (String)comboJogador2.getSelectedItem();  
            		matrizCorJogador[2][0] = textField3.getText();     matrizCorJogador[2][1] = (String)comboJogador3.getSelectedItem();
            		matrizCorJogador[3][0] = textField4.getText();     matrizCorJogador[3][1] = null;
            		matrizCorJogador[4][0] = textField5.getText();     matrizCorJogador[4][1] = null;
            		matrizCorJogador[5][0] = textField6.getText();     matrizCorJogador[5][1] = null;
            	} else if (selectedInteger ==4) {
            		matrizCorJogador[0][0] = textField1.getText();     matrizCorJogador[0][1] = (String)comboJogador1.getSelectedItem();     
            		matrizCorJogador[1][0] = textField2.getText();     matrizCorJogador[1][1] = (String)comboJogador2.getSelectedItem();  
            		matrizCorJogador[2][0] = textField3.getText();     matrizCorJogador[2][1] = (String)comboJogador3.getSelectedItem();
            		matrizCorJogador[3][0] = textField4.getText();     matrizCorJogador[3][1] = (String)comboJogador4.getSelectedItem();
            		matrizCorJogador[4][0] = textField5.getText();     matrizCorJogador[4][1] = null;
            		matrizCorJogador[5][0] = textField6.getText();     matrizCorJogador[5][1] = null;
            	} else if (selectedInteger ==5) {
            		matrizCorJogador[0][0] = textField1.getText();     matrizCorJogador[0][1] = (String)comboJogador1.getSelectedItem();     
            		matrizCorJogador[1][0] = textField2.getText();     matrizCorJogador[1][1] = (String)comboJogador2.getSelectedItem();  
            		matrizCorJogador[2][0] = textField3.getText();     matrizCorJogador[2][1] = (String)comboJogador3.getSelectedItem();
            		matrizCorJogador[3][0] = textField4.getText();     matrizCorJogador[3][1] = (String)comboJogador4.getSelectedItem();
            		matrizCorJogador[4][0] = textField5.getText();     matrizCorJogador[4][1] = (String)comboJogador5.getSelectedItem();
            		matrizCorJogador[5][0] = textField6.getText();     matrizCorJogador[5][1] = null;
            	} else if (selectedInteger ==6) {
            		matrizCorJogador[0][0] = textField1.getText();     matrizCorJogador[0][1] = (String)comboJogador1.getSelectedItem();     
            		matrizCorJogador[1][0] = textField2.getText();     matrizCorJogador[1][1] = (String)comboJogador2.getSelectedItem();  
            		matrizCorJogador[2][0] = textField3.getText();     matrizCorJogador[2][1] = (String)comboJogador3.getSelectedItem();
            		matrizCorJogador[3][0] = textField4.getText();     matrizCorJogador[3][1] = (String)comboJogador4.getSelectedItem();
            		matrizCorJogador[4][0] = textField5.getText();     matrizCorJogador[4][1] = (String) comboJogador5.getSelectedItem();
            		matrizCorJogador[5][0] = textField6.getText();     matrizCorJogador[5][1] = (String) comboJogador6.getSelectedItem();
            	}			
            	
            	
            	// faça verificação das cores    ps: ESSE CÓDIGO DE VERIFICAÇÃO VEIO DO OUTRO ARQUIVO ! ME LIMITO A APENAS USAR O QTDREPETICOES ali em baixo porque resolve. 
            	//      pouco fiz questão de parar tudo para refletir
            	qtdRepeticoes2 = 0;
    			for (int i = 0; i < selectedInteger; i++) {
    			    for (int j = 0; j < selectedInteger; j++) {
    			        if (i != j && matrizCorJogador[i][1].equals(matrizCorJogador[j][1])) { // Use .equals to compare strings
    			            qtdRepeticoes2++;
    			            //System.out.println("Cor " + coresArray[j] + " repetida " + qtdRepeticoes2 + " vezes !"); // teste line
    			        }

    			        // Impede tela de trocar
    			        if (qtdRepeticoes2 > 0) { // Change to > 0 to prevent screen change
    			            //System.out.println("ISHHH Cor " + coresArray[j] + " repetida " + qtdRepeticoes2 + " vezes !");  // teste line
    			            impedeTrocarTela++;
    			        }
    			    }
    			}

    			System.out.println("TELA " + impedeTrocarTela + "   ||  qtdRepeticoes2 " + qtdRepeticoes2);

    			if (qtdRepeticoes2 == 0) {
    				for (int i = 0; i <6 ; i++) {	
        				System.out.println("Nome: "+ matrizCorJogador[i][0] + " | Cor: " + matrizCorJogador[i][1]);
        				System.out.println("Substitua essa linha pela troca de tela");
    
    				}
    			    System.out.println("Troca tela");
    			}
            	

    			
            	
            }
        });
        
        
        
        
        
        
        
        
        
        
        // comeco da tela
        panel.add(integerComboBox);
        panel.add(printButton);
        frame.add(panel);
        
        
        
        frame.getContentPane().add(panel2Selected);
        
        
        
        // assim evitamos sobreposição
        frame.add(panel, BorderLayout.NORTH); // You can choose other positions (e.g., SOUTH, EAST, WEST)
        //frame.add(panel2Selected, BorderLayout.EAST);
        frame.add(panel2Selected, BorderLayout.SOUTH);

        
        //frame.setSize(300, 200); // resize pelo programador
        frame.pack();  // resize auto
        frame.setVisible(true);
        
    	});
    }
}