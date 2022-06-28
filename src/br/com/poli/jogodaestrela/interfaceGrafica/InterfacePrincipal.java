package br.com.poli.jogodaestrela.interfaceGrafica;

import br.com.poli.jogodaestrela.interfaceGrafica.componentes.*;
import javax.swing.JFrame;

public class InterfacePrincipal extends JFrame implements Interface {
    // Criando JLabels
    private final LblTabuleiro[][] lblTabuleiro = new LblTabuleiro[6][7];
    private final LblJogador lblJogador = new LblJogador();
    private final LblNome lblNome = new LblNome();
    private final LblPlayer lblPlayer1 = new LblPlayer(250);
    private final LblPlayer lblPlayer2 = new LblPlayer(450);
    private final LblMensagem lblMensagem = new LblMensagem();
    // Criando JButtons
    private final BtnNome btnNome = new BtnNome();
    private final BtnReiniciar btnReiniciar = new BtnReiniciar();
    private final BtnJogada[] btnJogada = new BtnJogada[7];
    private final BtnJogada valorPosicao = new BtnJogada();
    // Criando JTextField
    private final TxtNome txtNome = new TxtNome();
    // Criando JPanel de Forma Intercalada
    private Painel1 painel1;
    private Painel2 painel2;
    
    public InterfacePrincipal() {// Iniciando Componentes
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        criarJFrame();
        criarTabuleiro();
        criarBtnJogada(valorPosicao);
        criarPaineis();
        setVisible(true);
    }

    private void criarJFrame() {
        setTitle("Jogo Da Estrela");
        setResizable(false);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
    }

    private void criarTabuleiro() {
        for (byte i = 0; i < 6; i++) {
            for (byte j = 0; j < 7; j++) {
                this.lblTabuleiro[i][j] = new LblTabuleiro(i, j);
            }
        }
    }

    private void criarBtnJogada(BtnJogada valorPosicao) {
        for (byte i = 0; i < 7; i++) {
            this.btnJogada[i] = new BtnJogada(i, valorPosicao);
        }
    }

    private void criarPaineis() {
        this.painel1 = new Painel1(lblJogador, lblNome, txtNome, btnNome);
        this.painel2 = new Painel2(lblPlayer1, lblPlayer2, lblMensagem, btnReiniciar, lblTabuleiro, btnJogada);
    }
       // Todos os Métodos com @Override são chamados na Main
    @Override
    public String obterNome(int valorJogador) {
        lblJogador.setText("Jogador " + valorJogador);
        txtNome.setText(null);
        if (valorJogador == 1) {
            remove(painel2);
            add(painel1);
            painel1.repaint();
        }
        pause(btnNome);

        return (txtNome.getText().equals("") ? ("Jogador " + valorJogador) : txtNome.getText());
    }

    @Override 
    public void iniciarPartida(String nomeJogador1, String nomeJogador2) {
        lblPlayer1.setText(nomeJogador1);
        lblPlayer2.setText(nomeJogador2);
        lblMensagem.setText(null);
        iniciarTabuleiro();
        remove(painel1);
        add(painel2);
        painel2.repaint();
    }

    @Override
    public byte obterPosicao() {
        pause(valorPosicao);
        return valorPosicao.getValorJogada();
    }

    @Override // Altera cor da lblPlayer de acordo com o Jogador da vez
    public void alterarJogador(int qtdeJogada) {
        lblPlayer1.setCor(qtdeJogada % 2 == 0 ? 1 : 0);
        lblPlayer2.setCor(qtdeJogada % 2 != 0 ? 2 : 0);
    }

    @Override // Muda a cor da lblTabuleiro referente a posicao Jogada
    public void atualizarTabuleiro(byte linha, byte coluna, int valorJogador) {
        lblTabuleiro[linha][coluna].setCor(valorJogador);
    }

    @Override // Muda estado de Visibilidade de um btnJogada
    public void visibleBtnJogada(byte valorBotao, boolean estado) {
        btnJogada[valorBotao].getVisible(estado);
    }

    @Override
    public void mensagemVitoria(String nomeVencedor, int valorJogador) {
        lblMensagem.setCor(valorJogador);
        lblMensagem.setText(nomeVencedor + " WINS!");
    }

    @Override
    public void mensagemEmpate() {
        lblMensagem.setCor(0);
        lblMensagem.setText("EMPATE !");
    }

    @Override
    public void controleReset() {
        visibleAllBtnJogada(false);
        btnReiniciar.setVisible(true);
        pause(btnReiniciar);
        btnReiniciar.setVisible(false);
        visibleAllBtnJogada(true);
    }
     // Reseta as cores do tabuleiro, alterando para cinza
    private void iniciarTabuleiro() {
        for (byte i = 0; i < 6; i++) {
            for (byte j = 0; j < 7; j++) {
                lblTabuleiro[i][j].setCor(0);
            }
        }
    }
    // Muda estado de Visibilidade de todos os btnJogada
    private void visibleAllBtnJogada(boolean estado) {
        for (byte i = 0; i < 7; i++) {
            visibleBtnJogada(i, estado);
        }
    }
    // Trava o Objeto até que alguma ação seja feita
    private void pause(Object object) {
        try {
            synchronized (object) {
                object.wait();
            }
        } catch (InterruptedException e) {
        }
    }
}
