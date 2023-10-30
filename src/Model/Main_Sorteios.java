package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_Sorteios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(System.in);
		int QJogs = 0;
		
		// Passo 1:
		// Criar instancia de Tabuleiro
		Tabuleiro tabuleiro = new Tabuleiro();
		
		// Pergunta qtde de Jogadores: Q_jogadores
		while(QJogs < 2 || QJogs >6 ) {
			System.out.println("Informe a quantidade de jogadores (2-6):");
			QJogs = s.nextInt();
			}
		System.out.println("Quantidade de jogadores na partida: " + QJogs);
		
		String[] nomeJogs = new String[QJogs];		
		String nome = s.nextLine();
		
		// Pergunta nome de cada um dos Q_jogadores
		for (int i = 0; i < QJogs; i++) {
            System.out.println("Informe o nome do jogador " + (i+1) + ": ");
            nomeJogs[i] = s.nextLine();
            }
		
		// Sorteia Dados
		int[] Dados = tabuleiro.sorteiaDados();
		System.out.println("Dados do Ataque");
		for (int i = 1; i < 4; i++) {
			System.out.println(i +"o. dado do ataque: saiu =>  " + Dados[i-1]);
		}
		System.out.println();
		System.out.println("Dados da Defesa");
		for (int i = 4; i < 7; i++) {
			System.out.println(i-3 +"o. dado da defesa: saiu =>  " + Dados[i-1]);
		}
				
		/*
		// Sorteia ordem dos Q_jogadores
		int[] ordem = tabuleiro.sorteiaOrdem(QJogs, QJogs);
		
		
		// Sorteia uma cor para cada um dos Q_jogadores
		String[] sortcores = tabuleiro.sorteiaCores(QJogs, QJogs);
		
				
		// Sorteia objetivo para cada um dos Q_jogadores
		String[] objetivos = tabuleiro.sorteiaObjetivos(QJogs, QJogs);
				
		// Sortea territorios por jogador até o final do deck
		//ArrayList<ArrayList<String>> territoriosJog = tabuleiro.sorteaTerritorios(41, QJogs);
		
		// Recebimento e posicionamento dos exércitos 
		//   correspondente à metade do número de territórios
		//   de cada um dos Q_jogadores

		// Resume partida até aqui
		System.out.println();
		System.out.println("Resumo da Partida");
		System.out.println("Esta partida terá " + QJogs + " jogadores: ");
		System.out.println("que jogarão na seguinte ordem: ");
		System.out.println("e terão os seguintes objetivos: ");
		
		// Instancio Jogadores
		for (int i = 0; i < QJogs; i++) {
			System.out.println((i+1) + "o. Jogador: " + nomeJogs[ordem[i]-1] + " que terá a cor: " + sortcores[i] + ", e o objetivo: " + objetivos[i]);
			//tabuleiro.adicionarJogador(sortcores[i],nomeJogs[ordem[i]-1],objetivos[i], 0);
		}
		
		// Sorteio Territórios
		//String[] listTerr = tabuleiro.ListaFronteiras();
		//String[] sortTerr = tabuleiro.sorteiaTerritorios();
		
		// Instancio Territorios sorteados por Jogador  
		//int TotTerr = sortTerr.length;
		//int QTerr = TotTerr/QJogs; // Divisão em JAVA é inteira, não tem resto
		//int resto = TotTerr % QJogs; // Resto da Divisão
		//int contrTerr = 0;
		//int Qexerc = 0;
		
		
		for (int i = 0; i < QJogs; i++) {
			if (i < resto) {
				QTerr = TotTerr/QJogs + 1;
			}
			else
				QTerr = TotTerr/QJogs;
			
			Qexerc = QTerr/2; 
			
			System.out.println("Jogador: "+ i + " recebe " + QTerr + " Territorios, e vai posicionar "+ Qexerc +" exércitos");
			for (int j = 0; j < QTerr ; j++) {
				System.out.println("Jogador: "+ i + "  "+  j + "o. Territorio: "+ sortTerr[j+contrTerr]);
				tabuleiro.adicionarTerritorio(sortTerr[j+contrTerr]);
			}
			contrTerr = contrTerr + QTerr;
		}
		*/
				
		// (5) Recebimento e posicionamento dos exércitos 
		//   correspondente à posse de um continente inteiro
		
		// (6) Recebimento e posicionamento dos exércitos 
		//   correspondente à troca de cartas.
		
		
	
		System.out.println("FIM");
	}

}

