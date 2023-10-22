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

	@Test
	public void testeObjetivoDiferentes() {
		int[] objsorteados = Tabuleiro.sorteiaObjetivos(14,6);
		assertTrue(objsorteados[0] != objsorteados[1] &&
				   objsorteados[0] != objsorteados[2] &&
				   objsorteados[0] != objsorteados[3] &&
				   objsorteados[0] != objsorteados[4] &&
				   objsorteados[0] != objsorteados[5] &&
				   objsorteados[1] != objsorteados[2] &&
				   objsorteados[1] != objsorteados[3] &&
				   objsorteados[1] != objsorteados[4] &&
				   objsorteados[1] != objsorteados[5] &&
				   objsorteados[2] != objsorteados[3] &&
				   objsorteados[2] != objsorteados[4] &&
				   objsorteados[2] != objsorteados[5] &&
				   objsorteados[3] != objsorteados[4] &&
				   objsorteados[3] != objsorteados[5] &&
				   objsorteados[4] != objsorteados[5] );
	}
}
