package test.java;

import main.java.Jogador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JogadorTest {

    @BeforeEach
    public void setUp() {
        Jogador jogador = Jogador.getInstance();
        jogador.setNomeJogador(null);
        jogador.getInventario().clear();
        jogador.setMaxItens(0);
    }

    @Test
    public void deveRetornarNomeJogador() {
        Jogador.getInstance().setNomeJogador("João");
        assertEquals("João", Jogador.getInstance().getNomeJogador());
    }

    @Test
    public void deveRetornarMaxItens() {
        Jogador.getInstance().setMaxItens(10);
        assertEquals(10, Jogador.getInstance().getMaxItens());
    }

    @Test
    public void deveAdicionarItemEAtualizarQuantidade() {
        Jogador.getInstance().setMaxItens(5);

        Jogador.getInstance().addItem("Espada");
        Jogador.getInstance().addItem("Escudo");

        assertEquals(2, Jogador.getInstance().getQtdItens());
    }

    @Test
    public void naoDeveAdicionarItemAcimaDoLimite() {
        Jogador.getInstance().setMaxItens(1);

        Jogador.getInstance().addItem("Espada");
        Jogador.getInstance().addItem("Escudo");

        assertEquals(1, Jogador.getInstance().getQtdItens());

        assertTrue(Jogador.getInstance().getInventario().contains("Espada"));
        assertFalse(Jogador.getInstance().getInventario().contains("Escudo"));
    }

    @Test
    public void deveRetornarInventarioVazioInicialmente() {
        assertTrue(Jogador.getInstance().getInventario().isEmpty());
    }

    @Test
    public void deveConterItemAdicionadoNoInventario() {
        Jogador.getInstance().setMaxItens(3);
        Jogador.getInstance().addItem("Poção");

        assertTrue(Jogador.getInstance().getInventario().contains("Poção"));
    }

}