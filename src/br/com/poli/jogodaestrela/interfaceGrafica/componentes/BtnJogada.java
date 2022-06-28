package br.com.poli.jogodaestrela.interfaceGrafica.componentes;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.io.File;

public class BtnJogada extends JButton {
    // Botão Usado pra fazer a Jogada
    private final File endereco = new File("img");
    private static byte valorJogada;
    private final byte valor;

    public BtnJogada(int valor, BtnJogada valorPosicao) {// Criando botão
        this.getLocation(105 + 50 * valor + 40 * valor, 430);// Definindo posicao 
        this.getSize(40, 40);// Definindo Tamanho
        this.getImageIcon(valor);// Criando ImageIcon
        this.getCursor(new Cursor(Cursor.HAND_CURSOR));// Definindo tipo de Cursor
        this.getMnemonic((valor == 0 ? '0' : (valor == 1 ? '1' : (valor == 2 ? '2' : (valor == 3 ? '3' : (valor == 4 ? '4' : (valor == 5 ? '5' : valor == 6 ? '6' : null)))))));
        this.getActionListener(valorPosicao);// Definindo ação
        this.valor = (byte) valor;
    }

    public BtnJogada() {
        this.valor = 0;
    }

    private void getLocation(int i, int i0) {
        this.setLocation(i, i0);
    }

    private void getSize(int i, int i0) {
        this.setSize(i, i0);
    }

    private void getImageIcon(int valor) {
        try {// Endereço da imagem caso o programa execute na IDE
            this.getIcon(new ImageIcon(getClass().getResource("img\\img" + valor + ".jpg")));
            this.getPressedIcon(new ImageIcon(getClass().getResource("img\\img" + valor + "Pressed.jpg")));
        } catch (Exception e) {// Endereço da imagem caso o programa execute via executável
            this.getIcon(new ImageIcon(this.endereco + "\\img" + valor + ".jpg"));
            this.getPressedIcon(new ImageIcon(this.endereco + "\\img" + valor + "Pressed.jpg"));
        }
    }

    private void getIcon(ImageIcon imageIcon) {
        this.setIcon(imageIcon);
    }

    private void getPressedIcon(ImageIcon imageIcon) {
        this.setPressedIcon(imageIcon);
    }

    private void getCursor(Cursor cursor) {
        this.setCursor(cursor);
    }

    private void getActionListener(BtnJogada valorPosicao) {
        this.addActionListener((ActionEvent e) -> {
            valorJogada = this.valor;
            synchronized (valorPosicao) {
                valorPosicao.notify();
            }
        });
    }

    private void getMnemonic(char tecla) {
        this.setMnemonic(tecla);
    }

    public byte getValorJogada() {
        return valorJogada;
    }

    public void getVisible(boolean b) {
        this.setVisible(b);
    }
}
