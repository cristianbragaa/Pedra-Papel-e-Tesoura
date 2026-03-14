package com.crisdev.pedrapapeltesoura.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.crisdev.pedrapapeltesoura.R
import com.crisdev.pedrapapeltesoura.ui.theme.DrawGray
import com.crisdev.pedrapapeltesoura.ui.theme.GrayLight
import com.crisdev.pedrapapeltesoura.ui.theme.GrayMedium

@Composable
fun BoxArea(
    imagemComputador: Int
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .size(130.dp)
            .border(border = BorderStroke(1.dp, GrayMedium), shape = CircleShape)
            .clip(CircleShape)
            .background(color = GrayLight),
        contentAlignment = Alignment.Center
    ) {
        if (imagemComputador == -1) {
            Image(
                painter = painterResource(R.drawable.fundo),
                modifier = Modifier.background(DrawGray),
                contentDescription = null,
                contentScale = ContentScale.None,
            )
        } else {
            when (imagemComputador) {
                0 -> { Image(painter = painterResource(R.drawable.pedra), contentDescription = null,) }
                1 -> { Image(painter = painterResource(R.drawable.papel), contentDescription = null,) }
                2 -> { Image(painter = painterResource(R.drawable.tesoura), contentDescription = null,) }
                else -> { Image(painter = painterResource(R.drawable.fundo), contentDescription = null,) }
            }
        }
    }
}