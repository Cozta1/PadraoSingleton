package test.java;

import main.java.Jogador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JogadorTest {

    @Test
    public void deveRetornarNomeJogador() {
        Jogador.getInstance().setNomeJogador("João");
        assertEquals("João", Jogador.getInstance().getNomeJogador());
    }

    @Test
    public void deveRetornarMaximoItens() {
        Jogador.getInstance().setMaxItens(10);
        assertEquals(10, Jogador.getInstance().getMaxItens());
    }

    @Test
    public void deveAdicionarItemEAtualizarQuantidade() {
        // Configura o limite e limpa o inventário para o teste
        Jogador.getInstance().setMaxItens(5);
        Jogador.getInstance().getInventario().clear();

        Jogador.getInstance().addItem("Espada");
        Jogador.getInstance().addItem("Escudo");

        assertEquals(2, Jogador.getInstance().getQtdItens());
    }

    @Test
    public void naoDeveAdicionarItemAcimaDoLimite() {
        Jogador.getInstance().setMaxItens(1);
        Jogador.getInstance().getInventario().clear();

        Jogador.getInstance().addItem("Espada");
        Jogador.getInstance().addItem("Escudo"); // Não deve ser adicionado

        assertEquals(1, Jogador.getInstance().getQtdItens());
    }
}