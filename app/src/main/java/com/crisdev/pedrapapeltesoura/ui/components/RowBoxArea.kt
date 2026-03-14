package com.crisdev.pedrapapeltesoura.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.crisdev.pedrapapeltesoura.ui.theme.GrayLight
import com.crisdev.pedrapapeltesoura.ui.theme.GrayMedium

@Composable
fun RowBoxArea(
    iconeJogador: Int,
    onClickIcon: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .border(border = BorderStroke(1.dp, GrayMedium), shape = CircleShape)
            .clip(CircleShape)
            .background(color = GrayLight),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            modifier = Modifier.size(200.dp),
            onClick = {
                onClickIcon.invoke()
            }) {
            Image(
                painter = painterResource(iconeJogador),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}