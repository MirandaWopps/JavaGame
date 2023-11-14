package Model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteInicializacaoTabuleiro {

	@Before
	public void setup() {
		Jogador.CriaJogs("cor1","jogador1");
		Jogador.CriaJogs("cor2","jogador2");
		Jogador.CriaJogs("cor3","jogador3");
		Jogador.CriaJogs("cor4","jogador4");
		Jogador.CriaJogs("cor5","jogador5");
		Jogador.CriaJogs("cor6","jogador6");
	}

	@Test
	public void testeInsereSetimoJogador() {
		Jogador.CriaJogs("cor1","jogador7");
		assertTrue(Jogador.qtdeJogs() == 6);
	}
}
