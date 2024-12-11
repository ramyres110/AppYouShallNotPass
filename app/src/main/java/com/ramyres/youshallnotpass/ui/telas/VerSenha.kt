package com.ramyres.youshallnotpass.ui.telas

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramyres.youshallnotpass.model.Senha
import com.ramyres.youshallnotpass.model.Usuario
import com.ramyres.youshallnotpass.util.descriptografar


@Composable
fun VerSenha(innerPadding: PaddingValues, usuario: Usuario?, senha: Senha?, onClick : ()-> Unit) {
    var senhaMestre by remember { mutableStateOf("") }
    var senhaDescriptografada by remember { mutableStateOf("") }
    var visualizarSenha: Boolean by remember { mutableStateOf(false) }

    val context = LocalContext.current;

    Column(modifier = Modifier.padding(innerPadding)) {
        Text(text = "Plataforma: ${senha!!.plataforma}", fontSize = 22.sp)
        Spacer(Modifier.height(5.dp))

        Text(text = "Usuário: ${senha!!.usuario}", fontSize = 22.sp)
        Spacer(Modifier.height(5.dp))

        OutlinedTextField(
            value = senhaMestre,
            onValueChange = { senhaMestre = it },
            label = { Text("Digite a senha mestre") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            onClick = {
                if (senhaMestre == usuario!!.senhaMestre) {
                    senhaDescriptografada = descriptografar(senha.senha, senha.salt)
                    visualizarSenha = true
                }else{
                    senhaMestre = ""
                    Toast.makeText(context, "Senha incorreta", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("Visualizar", modifier = Modifier.padding(vertical = 10.dp), fontSize = 22.sp)
        }

        if (visualizarSenha) {
            OutlinedTextField(
                value = senhaDescriptografada,
                onValueChange = { },
                label = { Text("Senha de acesso") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                onClick = {
                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clip: ClipData = ClipData.newPlainText(senhaDescriptografada, senhaDescriptografada)
                    clipboard.setPrimaryClip(clip)
                    onClick()
                }
            ) {
                Text("Copiar", modifier = Modifier.padding(vertical = 10.dp), fontSize = 22.sp)
            }
        }

    }

}