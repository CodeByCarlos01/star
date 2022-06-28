package br.com.poli.jogodaestrela.player;

public class Jogador extends Pessoa {

    private final int valorJogador;

    public Jogador(String nome, int valorJogador) {
        super(nome);
        this.valorJogador = valorJogador;
    }

    public int getValorJogador() {
        return valorJogador;
    }
}
