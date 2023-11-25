package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dado implements Observable { 
    private List<Observer> lob = new ArrayList<Observer>();
    private static int dados[];
    private static Dado dado;

    private Dado() {
        dados = new int[6];
        zerarDados();
    }

    static Dado getDado() {
        if (dado == null)
            dado = new Dado();
        return dado;
    }

    void zerarDados() {
        Arrays.fill(dados, 0);
    }

    private void ordenaDados() {
    	
    	// Ataque
    	if (dados[0] < dados[1]) {
    		int temp = dados[0]; 
    		dados[0] = dados[1];
    		dados[1] = temp;
    	}
    	if (dados[1] < dados[2]) {
    		int temp = dados[1];
    		dados[1] = dados[2];
    		dados[2] = temp;
    	}
    	if (dados[0] < dados[1]) {
    		int temp = dados[0];
    		dados[0] = dados[1];
    		dados[1] = temp;
    	}
    	
    	// Defesa
    	if (dados[3] < dados[4]) {
    		int temp = dados[3];
    		dados[3] = dados[4];
    		dados[4] = temp;
    	}
    	if (dados[4] < dados[5]) {
    		int temp = dados[4];
    		dados[4] = dados[5];
    		dados[5] = temp;
    	}
    	if (dados[3] < dados[4]) {
    		int temp = dados[3];
    		dados[3] = dados[4];
    		dados[4] = temp;
    	}
	}

	int[] sorteiaDados(int atacante, int defensor) {
        Random random = new Random();
        zerarDados();

        // Sorteia os dados do atacante
        for (int i = 0; i < atacante; i++) {
        	dados[i] = random.nextInt(6) + 1;
        }
  
        // Sorteia os dados do defensor
        for (int i = 0; i < defensor; i++) {
        	dados[i+3] = random.nextInt(6) + 1;
        }
        
        ordenaDados();

        for (Observer o : lob) {
            o.notify(this);
        }
        
        System.out.println(Arrays.toString(dados));

        return dados;
    }

    public void addObserver(Observer o) {
        lob.add(o);
    }

    public void removeObserver(Observer o) {
        lob.remove(o);
    }

    public Object get() {
        return dados;
    }
}
