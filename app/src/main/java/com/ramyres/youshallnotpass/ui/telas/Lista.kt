package com.ramyres.youshallnotpass.ui.telas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramyres.youshallnotpass.model.Senha
import com.ramyres.youshallnotpass.model.Usuario
import com.ramyres.youshallnotpass.ui.componentes.Item

@Composable
fun Lista(usuario: Usuario?,  innerPadding: PaddingValues, onClickSenha: (Senha) -> Unit) {
    LazyColumn(
        modifier = Modifier.padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(usuario!!.senhas) { item ->
            Item(senha = item){
                onClickSenha(it)
            }
        }
    }
}