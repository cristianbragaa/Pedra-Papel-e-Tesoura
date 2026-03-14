package com.crisdev.pedrapapeltesoura.ui.screen

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.crisdev.pedrapapeltesoura.R
import com.crisdev.pedrapapeltesoura.ui.components.BoxArea
import com.crisdev.pedrapapeltesoura.ui.components.RowBoxArea
import com.crisdev.pedrapapeltesoura.ui.core.DetermineWinner
import com.crisdev.pedrapapeltesoura.ui.core.GameResult
import com.crisdev.pedrapapeltesoura.ui.theme.BackgroundLight
import kotlin.random.Random

@Composable
fun GameScreen(modifier: Modifier = Modifier) {
    var corFundoVencedor by remember { mutableStateOf(BackgroundLight) }
    var escolhaComputador by remember { mutableIntStateOf(-1) }
    var escolhaJogador by remember { mutableIntStateOf(-1) }

    val corAnimadaFundo by animateColorAsState(
        targetValue = (corFundoVencedor),
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = Spring.StiffnessVeryLow
        )
    )

    when (escolhaComputador) {
        0 -> R.drawable.pedra
        1 -> R.drawable.papel
        2 -> R.drawable.tesoura
        else -> R.drawable.fundo
    }

    val resultadoVencedor =
        if (escolhaJogador != -1 && escolhaComputador != -1) {
            DetermineWinner(escolhaJogador, escolhaComputador)
        } else {
            GameResult.NONE
        }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(corAnimadaFundo),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.text_escolha_app),
            modifier = Modifier.padding(top = 24.dp),
            style = MaterialTheme.typography.titleLarge
        )

        BoxArea(
            imagemComputador = escolhaComputador
        )

        Text(
            text = stringResource(R.string.text_escolha_jogador),
            modifier = Modifier.padding(top = 24.dp),
            style = MaterialTheme.typography.titleLarge
        )

        Row(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RowBoxArea(
                iconeJogador = R.drawable.pedra,
                onClickIcon = {
                    escolhaJogador = 0 //posicao após o click é posicao da Pedra
                    escolhaComputador = Random.nextInt(3)
                }
            )
            RowBoxArea(
                iconeJogador = R.drawable.papel,
                onClickIcon = {
                    escolhaJogador = 1 //posicao após o click é posicao do Papel
                    escolhaComputador = Random.nextInt(3)
                }
            )
            RowBoxArea(
                iconeJogador = R.drawable.tesoura,
                onClickIcon = {
                    escolhaJogador = 2 //posicao após o click é posicao da Tesoura
                    escolhaComputador = Random.nextInt(3)
                }
            )
        }

        when (resultadoVencedor) {
            GameResult.DRAW -> {
                Text(text = stringResource(R.string.text_empate))
                corFundoVencedor = BackgroundLight
            }

            GameResult.PLAYER_WIN -> {
                Text(text = stringResource(R.string.text_vitoria_jogador))
                corFundoVencedor = Color.Green
            }

            GameResult.COMPUTER_WIN -> {
                Text(text = stringResource(R.string.text_vitoria_computador))
                corFundoVencedor = Color.Red
            }

            GameResult.NONE -> {
                Text(text = "")
                corFundoVencedor = BackgroundLight
            }
        }
    }
}
