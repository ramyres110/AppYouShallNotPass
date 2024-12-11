package com.ramyres.youshallnotpass.ui.telas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramyres.youshallnotpass.model.Senha
import com.ramyres.youshallnotpass.model.Usuario

@Composable
fun ConfiguraUsuario(innerPadding: PaddingValues, salvarUsuario: (Usuario) -> Unit)     {
    var nome by remember { mutableStateOf("") }
    var senhaMestre by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(innerPadding)) {
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Digite o nome do usuário") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        OutlinedTextField(
            value = senhaMestre,
            onValueChange = { senhaMestre = it },
            label = { Text("Digite a senha mestre") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            onClick = { salvarUsuario(Usuario(nome, senhaMestre, mutableListOf<Senha>())) }
        ) {
            Text("Configurar", modifier = Modifier.padding(vertical = 10.dp), fontSize = 22.sp)
        }
    }
}

