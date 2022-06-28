package br.com.poli.jogodaestrela.interfaceGrafica;

public interface Interface {
    // Declaração de métodos abstratos
    public String obterNome(int valorJogador);

    public void iniciarPartida(String nomeJogador1, String nomeJogador2);

    public void alterarJogador(int qtdeJogada);

    public byte obterPosicao();

    public void atualizarTabuleiro(byte linha, byte coluna, int valorJogador);

    public void mensagemVitoria(String nomeVencedor, int valorJogador);

    public void mensagemEmpate();

    public void controleReset();

    public void visibleBtnJogada(byte valorBotao, boolean estado);
}
