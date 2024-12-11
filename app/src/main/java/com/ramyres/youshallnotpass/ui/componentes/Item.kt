package com.ramyres.youshallnotpass.ui.componentes

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramyres.youshallnotpass.model.Senha
import com.ramyres.youshallnotpass.ui.theme.YouShallNotPassTheme

@Composable
fun Item(senha: Senha, onClick: (Senha) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, MaterialTheme.colorScheme.onBackground, ShapeDefaults.Large)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                senha.plataforma,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            Text(senha.usuario, color = MaterialTheme.colorScheme.onBackground)
            Button(onClick = { onClick(senha) }) {
                Icon(Icons.Default.Lock, contentDescription = "Delete")
            }
        }
    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO, name = "ItemPreviewLight")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "ItemPreviewDark")
@Composable
fun ItemPreview() {
    YouShallNotPassTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            Item(Senha("1", "Facebook", "gandalf@gmail.com", "qwe123", "123"), onClick = {})
            Item(Senha("2", "Instagram", "gandalf@gmail.com", "qwe123", "123"), onClick = {})
        }
    }
}