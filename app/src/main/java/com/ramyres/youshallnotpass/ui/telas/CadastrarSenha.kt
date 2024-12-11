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
import com.ramyres.youshallnotpass.util.criptografar
import java.util.UUID

@Composable
fun CadastrarSenha(innerPadding: PaddingValues, salvarSenha: (Senha)-> Unit) {

    var plataforma by remember { mutableStateOf("") }
    var usuario by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(innerPadding)) {
        OutlinedTextField(
            value = plataforma,
            onValueChange = { plataforma = it },
            label = { Text("Digite a plataforma") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Digite o nome do usuário") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Digite a senha") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            onClick = {
                var uid: String = UUID.randomUUID().toString()
                var salt: String = "@$uid-${plataforma.hashCode().toString()}_$senha#"
                salvarSenha(Senha(uid,plataforma, usuario, criptografar(senha, salt), salt))
            }
        ) {
            Text("Configurar", modifier = Modifier.padding(vertical = 10.dp), fontSize = 22.sp)
        }
    }


}