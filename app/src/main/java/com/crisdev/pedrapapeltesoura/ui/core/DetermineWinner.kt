package com.crisdev.pedrapapeltesoura.ui.core

fun DetermineWinner(
    posicaoJogador: Int, posicaoComputador: Int
): GameResult {
    val result = (posicaoJogador - posicaoComputador + 3) % 3
    return when (result) {
        0 -> GameResult.DRAW
        1 -> GameResult.PLAYER_WIN
        else -> GameResult.COMPUTER_WIN
    }
}