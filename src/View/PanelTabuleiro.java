package View;

import java.awt.*;
import javax.swing.*;

import Controller.Controller;

import java.util.HashMap;
import java.util.Map;


public class PanelTabuleiro extends JPanel {
	Image mapa;
	Image fundo;
	private Map<String,TerritorioView> territorios = new HashMap<String,TerritorioView>();
	
	public PanelTabuleiro(Image mapa, Image fundo) {
		this.mapa = mapa;
		this.fundo = fundo;
		
		instanciaTerritoriosView();
		
	}
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;

        g2d.drawImage(fundo,0,0,1000,700,null);
        g2d.drawImage(mapa,0,-30,1000,700,null);
        
        Controller.desenhaTerritorios(territorios, g2d);
    }
    
    private void instanciaTerritoriosView() {
    	// América do Norte
    	territorios.put("ALASCA", new TerritorioView(95,104,82,90,"ALASCA"));
    	territorios.put("CALGARY", new TerritorioView(190,110,170,94,"CALGARY"));
    	territorios.put("GROENLÂNDIA", new TerritorioView(321,80,285,65,"GROENLÂNDIA"));
    	territorios.put("VANCOUVER", new TerritorioView(160,153,132,140,"VANCOUVER"));
    	territorios.put("QUEBEC", new TerritorioView(270,150,270,135,"QUEBEC"));
    	territorios.put("CALIFORNIA", new TerritorioView(106,230,80,213,"CALIFORNIA"));
    	territorios.put("TEXAS", new TerritorioView(175,200,170,185,"TEXAS"));
    	territorios.put("NOVA YORK", new TerritorioView(205,222,210,207,"NOVA YORK"));
    	territorios.put("MEXICO", new TerritorioView(150,315,120,298,"MEXICO"));
    	
    	// América do Sul
    	territorios.put("VENEZUELA", new TerritorioView(192,375,165,360,"VENEZUELA"));
    	territorios.put("PERU", new TerritorioView(230,425,218,407,"PERU"));
    	territorios.put("BRASIL", new TerritorioView(289,397,268,380,"BRASIL"));
    	territorios.put("ARGENTINA", new TerritorioView(279,495,250,472,"ARGENTINA"));
    	
    	// Oceania
    	territorios.put("PERTH", new TerritorioView(788,528,823,480,"PERTH"));
    	territorios.put("AUSTRALIA", new TerritorioView(844,551,868,484,"AUSTRALIA"));
    	territorios.put("NOVA ZELÂNDIA", new TerritorioView(903,572,924,541,"NOVA ZELÂNDIA"));
    	territorios.put("INDONÉSIA", new TerritorioView(841,422,879,413,"INDONÉSIA"));
    	
    	// África
    	territorios.put("ARGÉLIA", new TerritorioView(441,315,420,300,"ARGÉLIA"));
    	territorios.put("EGITO", new TerritorioView(560,325,545,308,"EGITO"));
    	territorios.put("NIGÉRIA", new TerritorioView(500,355,435,360,"NIGÉRIA"));
    	territorios.put("SOMÁLIA", new TerritorioView(603,420,584,400,"SOMÁLIA"));
    	territorios.put("ANGOLA", new TerritorioView(544,443,525,425,"ANGOLA"));
    	territorios.put("ÁFRICA DO SUL", new TerritorioView(565,495,530,477,"ÁFRICA DO SUL"));
    	
    	// Europa
    	territorios.put("REINO UNIDO", new TerritorioView(457,140,425,125,"REINO UNIDO"));
    	territorios.put("ESPANHA", new TerritorioView(432,233,410,216,"ESPANHA"));
    	territorios.put("FRANÇA", new TerritorioView(480,195,460,178,"FRANÇA"));
    	territorios.put("SUÉCIA", new TerritorioView(528,110,510,92,"SUÉCIA"));
    	territorios.put("POLÔNIA", new TerritorioView(565,161,545,145,"POLÔNIA"));
    	territorios.put("ITÁLIA", new TerritorioView(520,210,508,194,"ITÁLIA"));
    	territorios.put("ROMÊNIA", new TerritorioView(573,214,555,236,"ROMÊNIA"));
    	territorios.put("UCRÂNIA", new TerritorioView(590,185,587,205,"UCRÂNIA"));
    	territorios.put("ESTÔNIA", new TerritorioView(627,106,604,68,"ESTÔNIA"));
    	territorios.put("LETÔNIA", new TerritorioView(622,152,664,151,"LETÔNIA"));
    	territorios.put("TURQUIA", new TerritorioView(680,185,709,191,"TURQUIA"));
    	territorios.put("SÍRIA", new TerritorioView(627,228,661,234,"SÍRIA"));
    	territorios.put("JORDÂNIA", new TerritorioView(611,290,637,266,"JORDÂNIA"));
    	territorios.put("ARÁBIA SAUDITA", new TerritorioView(647,361,646,315,"ARÁBIA SAUDITA"));
    	territorios.put("IRAQUE", new TerritorioView(674,298,663,270,"IRAQUE"));
    	territorios.put("IRÃ", new TerritorioView(712,291,703,271,"IRÃ"));
    	territorios.put("PAQUISTÃO", new TerritorioView(747,284,723,242,"PAQUISTÃO"));
    	territorios.put("RÚSSIA", new TerritorioView(718,108,774,102,"RÚSSIA"));
    	territorios.put("SIBÉRIA", new TerritorioView(850,121,887,96,"SIBÉRIA"));
    	territorios.put("CAZAQUISTÃO", new TerritorioView(753,158,799,172,"CAZAQUISTÃO"));
    	territorios.put("MONGÓLIA", new TerritorioView(813,204,848,202,"MONGÓLIA"));
    	territorios.put("CHINA", new TerritorioView(787,259,776,227,"CHINA"));
    	territorios.put("COREIA DO NORTE", new TerritorioView(832,249,853,256,"COREIA DO NORTE"));
    	territorios.put("COREIA DO SUL", new TerritorioView(817,270,846,273,"COREIA DO SUL"));
    	territorios.put("ÍNDIA", new TerritorioView(783,345,781,303,"ÍNDIA"));
    	territorios.put("BANGLADESH", new TerritorioView(836,328,841,299,"BANGLADESH"));
    	territorios.put("TAILÂNDIA", new TerritorioView(879,349,889,309,"TAILÂNDIA"));
    	territorios.put("JAPÃO", new TerritorioView(923,230,924,181,"JAPÃO"));
    }
}
