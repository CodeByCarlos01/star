package br.com.poli.jogodaestrela.interfaceGrafica.componentes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

public class TxtNome extends JTextField {
    // JTextField usada para Pegar os nomes dos Jogadores
    public TxtNome() {// Criando JTextField
        this.getLocation(360, 240);// Posição
        this.getSize(160, 25);// Tamanho
        this.getBackground(Color.BLACK);// Definindo Cor de Fundo
        this.getForeground(new Color(100, 130, 160));// Definindo Cor da Letra
        this.getFont(new Font("arial", Font.BOLD, 15));// Definindo fonte
    }

    private void getLocation(int i, int i0) {
        this.setLocation(i, i0);
    }

    private void getSize(int i, int i0) {
        this.setSize(i, i0);
    }

    private void getBackground(Color color) {
        this.setBackground(color);
    }

    private void getForeground(Color color) {
        this.setForeground(color);
    }

    private void getFont(Font font) {
        this.setFont(font);
    }
}
