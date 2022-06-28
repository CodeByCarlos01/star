package br.com.poli.jogodaestrela.interfaceGrafica.componentes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class LblMensagem extends JLabel {
    // JLabel usada para mostrar o Resultado da Partida
    public LblMensagem() {// Criando JLabel
        this.getLocation(320, 85);// Posição
        this.getSize(250, 30);// Tamanho
        this.getFont(new Font("arial", Font.BOLD, 25));// Fonte da Letra
    }

    private void getLocation(int i, int i0) {
        this.setLocation(i, i0);
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
