package main.java;

import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private Jogador (){
        this.inventario = new ArrayList<>();
    };

    private static Jogador instance = new Jogador();

    public static Jogador getInstance() {
        return instance;
    };

    private String nomeJogador;
    private List<String> inventario;
    private int qtdItens;
    private int maxItens;


    public String getNomeJogador() {
        return nomeJogador;
    };

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    };

    public List<String> getInventario() {
        return inventario;
    };

    public void addItem(String item) {
        if(this.inventario.size() < this.maxItens) {
            this.inventario.add(item);
            this.qtdItens = this.inventario.size();
        } else {
            System.out.println("Inventario Cheio");
        }
    }

    public int getQtdItens() {
        return qtdItens;
    };


    public int getMaxItens() {
        return maxItens;
    };

    public void setMaxItens(int maxItens) {
        this.maxItens = maxItens;
    };

}
