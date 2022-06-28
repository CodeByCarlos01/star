package br.com.poli.jogodaestrela.interfaceGrafica;

import br.com.poli.jogodaestrela.logica.Partida;

public class Main {

    private static byte posicao, retorno;
    private static String nomJogador1, nomJogador2;
    static Interface interfacePrincipal = new InterfacePrincipal();

    public static void main(String[] args) {
        do {
            nomJogador1 = interfacePrincipal.obterNome(1);// Pega o nome do Jogador1
            nomJogador2 = interfacePrincipal.obterNome(2);// Pega o nome do Jogador2

            Partida partida = new Partida(nomJogador1, nomJogador2);// Cria Jogadores
            // Inicia Partida
            interfacePrincipal.iniciarPartida(partida.getJogador1().getNome(), partida.getJogador2().getNome());

            while (partida.getFim() == false) {
                interfacePrincipal.alterarJogador(partida.getQtdeJogada());
                posicao = interfacePrincipal.obterPosicao();
                retorno = partida.fazerJogada(posicao);
                if (retorno != -1) {
                    interfacePrincipal.atualizarTabuleiro(retorno, posicao, partida.getJogadorAtual().getValorJogador());
                } else {
                    interfacePrincipal.visibleBtnJogada(posicao, false);// Torna botão invisível, caso a coluna esteja cheia
                }
            }

            if (partida.getVencedor() == true) {
                interfacePrincipal.mensagemVitoria(partida.getJogadorAtual().getNome(), partida.getJogadorAtual().getValorJogador());
            } else {
                interfacePrincipal.mensagemEmpate();
            }

            interfacePrincipal.controleReset();// Controle de Reinício

        } while (true);
    }
}
