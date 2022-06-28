package br.com.poli.jogodaestrela.interfaceGrafica.componentes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class LblJogador extends JLabel {
    //   JLabel usada para exibir a palavra 'Jogador' no Painel 1
    public LblJogador() {// Criando JLabel
        this.getLocation(350, 50);// Posição
        this.getSize(170, 40);// Tamanho
        this.getForeground(new Color(100, 130, 160));// Cor da Letra
        this.getFont(new Font("arial", Font.BOLD, 35));// Fonte da Letra
    }

    private void getLocation(int i, int i0) {
        this.setLocation(i, i0);
    }

    private void getSize(int i, int i0) {
        this.setSize(i, i0);
    }

    private void getForeground(Color color) {
        this.setForeground(color);
    }

    private void getFont(Font font) {
        this.setFont(font);
    }
}
