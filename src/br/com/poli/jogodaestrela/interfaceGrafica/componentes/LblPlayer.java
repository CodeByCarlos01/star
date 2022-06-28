package br.com.poli.jogodaestrela.interfaceGrafica.componentes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class LblPlayer extends JLabel {
    // JLabel usada pra exibir o nome dos Jogadores
    public LblPlayer(int posicaoX) {// Criando JLabel
        this.getLocation(posicaoX, 30);// Posição
        this.getSize(170, 50);// Tamanho
        this.getFont(new Font("arial", Font.BOLD, 30));// Fonte da Letra
    }

    private void getLocation(int posicaoX, int i) {
        this.setLocation(posicaoX, i);
    }

    private void getSize(int i, int i0) {
        this.setSize(i, i0);
    }

    private void getFont(Font font) {
        this.setFont(font);
    }

    public void setCor(int cor) {
        this.setForeground((cor == 0 ? Color.lightGray : (cor == 1 ? Color.GREEN : (cor == 2 ? Color.RED : null))));
    }
}
