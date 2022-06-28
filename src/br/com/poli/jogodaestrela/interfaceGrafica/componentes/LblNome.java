package br.com.poli.jogodaestrela.interfaceGrafica.componentes;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class LblNome extends JLabel {
    // JLabel usada para exibir a palavra 'Nome' no Painel 1
    public LblNome() {// Criando JLabel
        this.getLocation(250, 200);// Posição
        this.getSize(90, 20);// Tamanho
        this.getFont(new Font("arial", Font.BOLD, 25));// Fonte da Letra
        this.getForeground(new Color(100, 130, 160));// Cor da Letra
        this.getText("Nome :");// Definindo Texto
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

    private void getForeground(Color color) {
        this.setForeground(color);
    }

    private void getText(String nome_) {
        this.setText(nome_);
    }
}
