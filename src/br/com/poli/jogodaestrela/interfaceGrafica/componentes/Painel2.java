package br.com.poli.jogodaestrela.interfaceGrafica.componentes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.io.File;

public class Painel2 extends JPanel {
    // JPanel usada para Jogar a Partida
    private final File endereco = new File("img");
    private ImageIcon imgFundo2;
    
    public Painel2(LblPlayer lblPlayer1, LblPlayer lblPlayer2, LblMensagem lblMensagem, BtnReiniciar btnReiniciar, LblTabuleiro lblTabuleiro[][], BtnJogada[] btnJogada) {
        this.getImageIcon();// Criando ImageIcon
        this.getLayout(null);// Definindo Layout
        this.addComponents(lblPlayer1, lblPlayer2, lblMensagem, btnReiniciar, lblTabuleiro, btnJogada);// Adicionando Componentes
    }// Criando JPanel

    @Override // Define Aparência da JPanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img = imgFundo2.getImage();
        g.drawImage(img, 0, 0, this);
    }

    private void getImageIcon() {
        try {// Endereço da imagem via IDE
            this.imgFundo2 = new ImageIcon(getClass().getResource("img\\fundo2.jpg"));
        } catch (Exception e) {// Endereço da imagem via Executável
            this.imgFundo2 = new ImageIcon(this.endereco + "\\fundo2.jpg");
        }
    }

    private void getLayout(Object object) {
        this.setLayout((LayoutManager) object);
    }

    private void addComponents(LblPlayer lblPlayer1, LblPlayer lblPlayer2, LblMensagem lblMensagem, BtnReiniciar btnReiniciar, LblTabuleiro lblTabuleiro[][], BtnJogada[] btnJogada) {
        this.add(lblPlayer1);
        this.add(lblPlayer2);
        this.add(lblMensagem);
        this.add(btnReiniciar);
        this.addTabuleiro(lblTabuleiro);
        this.addBtn(btnJogada);
    }

    private void addTabuleiro(LblTabuleiro lblTabuleiro[][]) {
        for (byte i = 0; i < 6; i++) {
            for (byte j = 0; j < 7; j++) {
                this.add(lblTabuleiro[i][j]);
            }
        }
    }

    private void addBtn(BtnJogada[] btnJogada) {
        for (byte i = 0; i < 7; i++) {
            this.add(btnJogada[i]);
        }
    }
}
