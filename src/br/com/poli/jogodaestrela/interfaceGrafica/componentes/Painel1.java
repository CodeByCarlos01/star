package br.com.poli.jogodaestrela.interfaceGrafica.componentes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.io.File;

public class Painel1 extends JPanel {
    // JPanel usada Para fazer o Login
    private final File endereco = new File("img");
    private ImageIcon imgFundo1;
    
    public Painel1(LblJogador lblJogador, LblNome lblNome, TxtNome txtNome, BtnNome btnNome) {
        this.getImageIcon();// Criando ImageIcon
        this.getLayout(null);// Definindo Layout
        this.addComponents(lblJogador, lblNome, txtNome, btnNome);// Adicionando Componentes
    }// Criando JPanel

    @Override // Define aparência da JPanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img = imgFundo1.getImage();
        g.drawImage(img, 0, 0, this);
    }

    private void getImageIcon() {
        try {// Endereço da imagem via IDE
            this.imgFundo1 = new ImageIcon(getClass().getResource("img\\fundo1.jpg"));
        } catch (Exception e) {// Endereço da imagem via Executável
            this.imgFundo1 = new ImageIcon(this.endereco + "\\fundo1.jpg");
        }
    }

    private void getLayout(Object object) {
        this.setLayout((LayoutManager) object);
    }

    private void addComponents(LblJogador lblJogador, LblNome lblNome, TxtNome txtNome, BtnNome btnNome) {
        this.add(lblJogador);
        this.add(lblNome);
        this.add(txtNome);
        this.add(btnNome);
    }
}
