package com.crisdev.pedrapapeltesoura.ui.core

fun DetermineWinner(
    posicaoJogador: Int, posicaoComputador: Int
): GameResult {
    return if (posicaoJogador == posicaoComputador) {
        GameResult.DRAW
    } else if ((posicaoJogador == 0 && posicaoComputador == 2) ||
        (posicaoJogador == 1 && posicaoComputador == 0) ||
        (posicaoJogador == 2 && posicaoComputador == 1)
    ) {
        GameResult.PLAYER_WIN
    } else {
        GameResult.COMPUTER_WIN
    }
}