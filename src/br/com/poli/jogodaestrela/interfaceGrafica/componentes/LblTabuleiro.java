package br.com.poli.jogodaestrela.interfaceGrafica.componentes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.File;

public class LblTabuleiro extends JLabel {
    // JLabel usada como representação do Tabuleiro
    private final File endereco = new File("img");
    private ImageIcon circuloVerde;
    private ImageIcon circuloVermelho;
    private ImageIcon circuloCinza;

    public LblTabuleiro(byte i, byte j) {// Criando JLabel
        this.getLocation(105 + 50 * j + 40 * j, 125 + 50 * i);// Posição
        this.getSize(50, 50);// Tamanho
        this.getImageIcon();// Criando ImageIcon
    }

    public void setCor(int cor) {
        this.setIcon((cor == 0 ? circuloCinza : (cor == 1 ? circuloVerde : (cor == 2 ? circuloVermelho : null))));
    }

    private void getLocation(int i, int i0) {
        this.setLocation(i, i0);
    }

    private void getSize(int i, int i0) {
        this.setSize(i, i0);
    }

    private void getImageIcon() {
        try {// Endereço da imagem via IDE
            this.circuloVerde = new ImageIcon(getClass().getResource("img\\circuloVerde.png"));
            this.circuloVermelho = new ImageIcon(getClass().getResource("img\\circuloVermelho.png"));
            this.circuloCinza = new ImageIcon(getClass().getResource("img\\circuloCinza.png"));
        } catch (Exception e) {// Endereço da imagem via Executável
            this.circuloVerde = new ImageIcon(this.endereco + "\\circuloVerde.png");
            this.circuloVermelho = new ImageIcon(this.endereco + "\\circuloVermelho.png");
            this.circuloCinza = new ImageIcon(this.endereco + "\\circuloCinza.png");
        }
    }
}
