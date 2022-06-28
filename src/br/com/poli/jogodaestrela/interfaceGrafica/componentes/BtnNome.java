package br.com.poli.jogodaestrela.interfaceGrafica.componentes;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.io.File;

public class BtnNome extends JButton {
    // Botão usado para Confirmar os Nomes dos Jogadores
    private final File endereco = new File("img");
    private ImageIcon imgSeta;
    private ImageIcon imgSetaRollover;

    public BtnNome() { // Criando Botão
        this.getLocation(540, 238);// Posição
        this.getSize(50, 30);// Tamanho
        this.getBorderPainted(false);
        this.getContentAreaFilled(false);
        this.getFocusPainted(false);
        this.getImageIcon();// Criando ImageIcon
        this.getIcon(imgSeta);// Definindo Aparência
        this.getRolloverEnabled(true);
        this.getRolloverIcon(imgSetaRollover);// Definindo Aparência quando o Mouse estiver em Cima
        this.getCursor(new Cursor(Cursor.HAND_CURSOR));// Tipo de Cursor
        this.getActionListener();// Definindo Ação do botão
        this.getMnemonic(KeyEvent.VK_ENTER);// Definindo atalho Alt+Enter
    }

    private void getLocation(int i, int i0) {
        this.setLocation(i, i0);
    }

    private void getSize(int i, int i0) {
        this.setSize(i, i0);
    }

    private void getBorderPainted(boolean b) {
        this.setBorderPainted(b);
    }

    private void getContentAreaFilled(boolean b) {
        this.setContentAreaFilled(b);
    }

    private void getFocusPainted(boolean b) {
        this.setFocusPainted(b);
    }

    private void getImageIcon() {
        try {// Endereço da Imagem via IDE
            this.imgSeta = new ImageIcon(getClass().getResource("img\\imgSeta.png"));
            this.imgSetaRollover = new ImageIcon(getClass().getResource("img\\imgSetaRollover.png"));
        } catch (Exception e) {// Endereço da Imagem via Executável
            this.imgSeta = new ImageIcon(this.endereco + "\\imgSeta.png");
            this.imgSetaRollover = new ImageIcon(this.endereco + "\\imgSetaRollover.png");
        }
    }

    private void getIcon(ImageIcon imgSeta) {
        this.setIcon(imgSeta);
    }

    private void getRolloverEnabled(boolean b) {
        this.setRolloverEnabled(b);
    }

    private void getRolloverIcon(ImageIcon imageIcon) {
        this.setRolloverIcon(imageIcon);
    }

    private void getCursor(Cursor cursor) {
        this.setCursor(cursor);
    }

    private void getActionListener() {
        this.addActionListener((ActionEvent e) -> {
            synchronized (this) {
                this.notify();
            }
        });
    }

    private void getMnemonic(int VK_ENTER) {
        this.setMnemonic(VK_ENTER);
    }
}
