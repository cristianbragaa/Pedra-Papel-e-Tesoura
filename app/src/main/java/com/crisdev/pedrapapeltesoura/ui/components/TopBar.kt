package com.crisdev.pedrapapeltesoura.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.crisdev.pedrapapeltesoura.ui.theme.DrawGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(gameName: String) {
    TopAppBar(
        title = { Text(text = gameName) },
        //colors = TopAppBarDefaults.topAppBarColors(containerColor = DrawGray)
    )
}