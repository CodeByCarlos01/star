package br.com.poli.jogodaestrela.logica;

public class Tabuleiro {

    private final byte numLinha = 6;
    private final byte numColuna = 7;
    private final byte[][] matriz = new byte[numLinha][numColuna];
    private byte contador;

    public byte fazerJogada(byte valorJogador, byte posicao) {
        for (contador = numLinha - 1; contador >= 0; contador--) {
            if (matriz[contador][posicao] == 0) {
                matriz[contador][posicao] = valorJogador;
                break;
            }
        }
        if (contador == -1) {// Lança IllegalArgumentException caso a coluna esteja cheia
            throw new IllegalArgumentException();
        }
        return contador;
    }

    public byte getPosicao(byte i, byte j) {
        return matriz[i][j];
    }

    public byte getNumLinha() {
        return numLinha;
    }

    public byte getNumColuna() {
        return numColuna;
    }
}
