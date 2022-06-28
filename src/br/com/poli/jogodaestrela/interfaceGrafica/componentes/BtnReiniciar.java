package br.com.poli.jogodaestrela.interfaceGrafica.componentes;

import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.io.File;

public class BtnReiniciar extends JButton {
    //    Botão usado para Reiniciar a Partida
    private final File endereco = new File("img");
    private ImageIcon imgReiniciar;

    public BtnReiniciar() { // Criando Botão
        this.getLocation(740, 420);// Posicao
        this.getSize(40, 40);// Tamanho
        this.getVisible(false);// Visibilidade
        this.getImageIcon();// Criando ImageIcon
        this.getIcon(imgReiniciar);// Aparencia
        this.getActionListener();// Ação
        this.getMnemonic('r');// Atalho Alt+r
    }

    private void getLocation(int i, int i0) {
        this.setLocation(i, i0);
    }

    private void getSize(int i, int i0) {
        this.setSize(i, i0);
    }

    private void getVisible(boolean b) {
        this.setVisible(b);
    }

    private void getImageIcon() {
        try {// Endereço da imagem via IDE
            this.imgReiniciar = new ImageIcon(getClass().getResource("img\\imgReiniciar.jpg"));
        } catch (Exception e) {// Endereço da Imagem via executável
            this.imgReiniciar = new ImageIcon(this.endereco + "\\imgReiniciar.jpg");
        }
    }

    private void getIcon(ImageIcon imageIcon) {
        this.setIcon(imageIcon);
    }

    private void getActionListener() {
        this.addActionListener((ActionEvent e) -> {
            synchronized (this) {
                this.notify();
            }
        });
    }

    private void getMnemonic(char c) {
        this.setMnemonic(c);
    }
}
