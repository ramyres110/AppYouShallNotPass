package com.ramyres.youshallnotpass.ui.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramyres.youshallnotpass.util.TipoTela

@Composable
fun AlertaConfiguraUsuario(innerPadding: PaddingValues, onClick: ()-> Unit) {
    Column(modifier = Modifier.padding(innerPadding)) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
        ) {
            Text(
                "Necessário configurar usuário",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 22.sp
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            onClick = { onClick() }
        ) {
            Text("Configurar", modifier = Modifier.padding(vertical = 10.dp), fontSize = 22.sp)
        }
    }
}