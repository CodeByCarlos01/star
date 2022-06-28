package br.com.poli.jogodaestrela.logica;

import br.com.poli.jogodaestrela.player.Jogador;

public class Partida {

    private final Tabuleiro tabuleiro;
    private Jogador jogadorAtual = null;
    private final Jogador jogador1;
    private final Jogador jogador2;
    private boolean fim;
    private boolean vencedor;
    private int qtdeJogada = 0;
    private byte y;

    public Partida(String jogador1, String jogador2) {
        this.jogador1 = new Jogador(jogador1, 1);
        this.jogador2 = new Jogador(jogador2, 2);
        this.tabuleiro = new Tabuleiro();
    }

    public byte fazerJogada(byte x) {
        try {
            jogadorAtual = (qtdeJogada % 2 == 0) ? jogador1 : jogador2;
            y = tabuleiro.fazerJogada((byte) jogadorAtual.getValorJogador(), x);
            vencedor = checkVitoria(y, x);
            fim = (vencedor == false) ? checkFim() : true;
            qtdeJogada++;
            return y;
        } catch (Exception e) {
            return -1;
        }
    }

    public boolean checkVitoria(byte linha, byte coluna) {

        byte combo = 1, i, j;

        for (i = 0; i < 7; i++) {
            combo = (i == 1 || i == 3 || i == 5) ? 1 : combo;
            for (j = 1; j <= 3; j++) {
                try {
                    if (i == 0) {
                        if (tabuleiro.getPosicao((byte) (linha + j), coluna) == jogadorAtual.getValorJogador()) {
                            combo++;
                        } else {
                            break;
                        }
                    } else if (i == 1) {
                        if (tabuleiro.getPosicao(linha, (byte) (coluna - j)) == jogadorAtual.getValorJogador()) {
                            combo++;
                        } else {
                            break;
                        }
                    } else if (i == 2) {
                        if (tabuleiro.getPosicao(linha, (byte) (coluna + j)) == jogadorAtual.getValorJogador()) {
                            combo++;
                        } else {
                            break;
                        }
                    } else if (i == 3) {
                        if (tabuleiro.getPosicao((byte) (linha - j), (byte) (coluna - j)) == jogadorAtual.getValorJogador()) {
                            combo++;
                        } else {
                            break;
                        }
                    } else if (i == 4) {
                        if (tabuleiro.getPosicao((byte) (linha + j), (byte) (coluna + j)) == jogadorAtual.getValorJogador()) {
                            combo++;
                        } else {
                            break;
                        }
                    } else if (i == 5) {
                        if (tabuleiro.getPosicao((byte) (linha - j), (byte) (coluna + j)) == jogadorAtual.getValorJogador()) {
                            combo++;
                        } else {
                            break;
                        }
                    } else if (i == 6) {
                        if (tabuleiro.getPosicao((byte) (linha + j), (byte) (coluna - j)) == jogadorAtual.getValorJogador()) {
                            combo++;
                        } else {
                            break;
                        }
                    }
                } catch (Exception e) {
                    break;
                }
            }
            if (combo >= 4) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFim() {
        for (byte i = 0; i < tabuleiro.getNumLinha(); i++) {
            for (byte j = 0; j < tabuleiro.getNumColuna(); j++) {
                if (tabuleiro.getPosicao(i, j) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean getFim() {
        return fim;
    }

    public boolean getVencedor() {
        return vencedor;
    }

    public int getQtdeJogada() {
        return qtdeJogada;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }
}
