package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TesteRecebimentoExercito {
	private Jogador jogador;
	private static Territorio territorio1;
	private static Territorio territorio2;
	private static Territorio territorio3;
	private static Territorio territorio4;
	private static Territorio territorio5;
	private static Territorio territorio6;
	private static Carta carta1;
	private static Carta carta2;
	private static Carta carta3;
	private static Carta carta4;
	private static Carta carta5;
	private static Carta carta6;

	@BeforeClass
	public static void setupBeforeClass() {
		territorio1 = new Territorio("Brasil",null);
		territorio2 = new Territorio("Argentina",null);
		territorio3 = new Territorio("Peru",null);
		territorio4 = new Territorio("Venezuela",null);
		territorio5 = new Territorio("Argélia",null);
		territorio6 = new Territorio("Inglaterra",null);
		carta1 = new Carta(Carta.TipoCarta.circulo, territorio1);
		carta2 = new Carta(Carta.TipoCarta.triangulo, territorio2);
		carta3 = new Carta(Carta.TipoCarta.quadrado, territorio3);
		carta4 = new Carta(Carta.TipoCarta.coringa, territorio4);
		carta5 = new Carta(Carta.TipoCarta.circulo, territorio5);
		carta6 = new Carta(Carta.TipoCarta.circulo, territorio6);
	}

	@Before
	public void setup() {
		jogador = new Jogador("amarelo","jogador");
	}

	@Test
	public void testeExercitoPorNumeroTerritorios() {
		jogador.adicionarTerritorio(territorio1);
		jogador.adicionarTerritorio(territorio2);
		jogador.adicionarTerritorio(territorio3);
		jogador.adicionarTerritorio(territorio4);
		jogador.adicionarTerritorio(territorio5);

		jogador.exercitoPorNumeroTerritorios();

		assertEquals(2, jogador.getExerc());
	}

	@Test
	public void testePrecisaTrocarCartasTrue() {
		jogador.adicionarCarta(carta1);
		jogador.adicionarCarta(carta2);
		jogador.adicionarCarta(carta3);
		jogador.adicionarCarta(carta4);
		jogador.adicionarCarta(carta5);

		assertTrue(jogador.precisaTrocarCartas());
	}

	@Test
	public void testePrecisaTrocarCartasFalse() {
		jogador.adicionarCarta(carta1);
		jogador.adicionarCarta(carta2);
		jogador.adicionarCarta(carta3);
		jogador.adicionarCarta(carta4);

		assertFalse(jogador.precisaTrocarCartas());
	}

	@Test
	public void testePodeTrocarCartasTrueTiposIguais() {
		jogador.adicionarCarta(carta1);
		jogador.adicionarCarta(carta2);
		jogador.adicionarCarta(carta3);

		assertTrue(jogador.podeTrocarCartas(0, 1, 2));
	}

	@Test
	public void testePodeTrocarCartasTrueTiposDiferentes() {
		jogador.adicionarCarta(carta1);
		jogador.adicionarCarta(carta5);
		jogador.adicionarCarta(carta6);

		assertTrue(jogador.podeTrocarCartas(0, 1, 2));
	}

	@Test
	public void testePodeTrocarCartasTrueCoringa() {
		jogador.adicionarCarta(carta1);
		jogador.adicionarCarta(carta2);
		jogador.adicionarCarta(carta4);
		
		assertTrue(jogador.podeTrocarCartas(0, 1, 2));
	}

	@Test
	public void testePodeTrocarCartasFalse() {
		jogador.adicionarCarta(carta1);
		jogador.adicionarCarta(carta2);
		jogador.adicionarCarta(carta5);
		
		assertFalse(jogador.podeTrocarCartas(0, 1, 2));
	}

	@Test
	public void testeExercitoPorCartas() {
		Jogador jogador2 = new Jogador("vermelho", "jogador 2");
		jogador2.adicionarCarta(carta1);
		jogador2.adicionarCarta(carta5);
		jogador2.adicionarCarta(carta6);
		
		jogador.adicionarCarta(carta2);
		jogador.adicionarCarta(carta3);
		jogador.adicionarCarta(carta4);

		jogador2.exercitoPorCartas(0, 1, 2);
		int trocaAnterior = jogador2.getExerc();

		jogador.exercitoPorCartas(0, 1, 2);
		
		assertEquals(trocaAnterior+2, jogador.getExerc());
	}

	@Test
	public void testePossuiTerritorioDaCarta() {
		jogador.adicionarTerritorio(territorio1);
		jogador.adicionarCarta(carta1);
		jogador.adicionarCarta(carta2);
		jogador.adicionarCarta(carta3);
		
		int exercitoInicial = territorio1.getQtdExerc();
		jogador.exercitoPorCartas(0, 1, 2);
		
		assertEquals(2+exercitoInicial, territorio1.getQtdExerc());
	}
	
	@Test
	public void testePossuiContinenteTrue() {
		Continente continente = new Continente("América do Sul",2);
		continente.adicionarTerritorio(territorio1);
		continente.adicionarTerritorio(territorio2);
		continente.adicionarTerritorio(territorio3);
		continente.adicionarTerritorio(territorio4);
		
		jogador.adicionarTerritorio(territorio1);
		jogador.adicionarTerritorio(territorio2);
		jogador.adicionarTerritorio(territorio3);
		jogador.adicionarTerritorio(territorio4);
		
		assertTrue(jogador.possuiContinente(continente));
	}
	
	@Test
	public void testePossuiContinenteFalse() {
		Continente continente = new Continente("América do Sul",2);
		continente.adicionarTerritorio(territorio1);
		continente.adicionarTerritorio(territorio2);
		continente.adicionarTerritorio(territorio3);
		continente.adicionarTerritorio(territorio4);
		
		jogador.adicionarTerritorio(territorio1);
		jogador.adicionarTerritorio(territorio2);
		jogador.adicionarTerritorio(territorio5);
		jogador.adicionarTerritorio(territorio6);
		
		assertFalse(jogador.possuiContinente(continente));
	}
	
	@Test
	public void testeExercBonusContinente() {
		Continente continente = new Continente("América do Sul",2);
		
		assertEquals(2, continente.getExercBonus());
	}
}
