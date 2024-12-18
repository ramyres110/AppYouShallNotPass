package com.ramyres.youshallnotpass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramyres.youshallnotpass.model.Senha
import com.ramyres.youshallnotpass.model.Usuario
import com.ramyres.youshallnotpass.ui.componentes.AlertaConfiguraUsuario
import com.ramyres.youshallnotpass.ui.componentes.Cabecalho
import com.ramyres.youshallnotpass.ui.componentes.Item
import com.ramyres.youshallnotpass.ui.telas.CadastrarSenha
import com.ramyres.youshallnotpass.ui.telas.ConfiguraUsuario
import com.ramyres.youshallnotpass.ui.telas.Lista
import com.ramyres.youshallnotpass.ui.telas.VerSenha
import com.ramyres.youshallnotpass.ui.theme.DarkFont
import com.ramyres.youshallnotpass.ui.theme.YellowBG
import com.ramyres.youshallnotpass.ui.theme.YouShallNotPassTheme
import com.ramyres.youshallnotpass.util.TipoTela

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(modifier: Modifier = Modifier) {
    var telaSelecionada by remember { mutableStateOf(TipoTela.USUARIO) }
    var senhaSelecionada: Senha? by remember { mutableStateOf(null) }
    var usuario by remember {
        mutableStateOf<Usuario?>(null)
    }

    fun adicionarUsuario(cadastro: Usuario) {
        usuario = cadastro
    }

    YouShallNotPassTheme {
        Scaffold(
            topBar = {
                Cabecalho(modifier = Modifier.wrapContentHeight())
            },
            floatingActionButton = {
                if (telaSelecionada == TipoTela.LISTA) {
                    FloatingActionButton(
                        containerColor = YellowBG,
                        shape = FloatingActionButtonDefaults.largeShape,
                        onClick = {
                            telaSelecionada = TipoTela.CADASTRO
                        }) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Add",
                            tint = DarkFont
                        )
                    }
                }
            },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp, start = 5.dp, end = 5.dp)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                if (usuario == null && telaSelecionada != TipoTela.USUARIO) {
                    AlertaConfiguraUsuario(innerPadding){
                        telaSelecionada = TipoTela.USUARIO
                    }
                } else {
                    when (telaSelecionada) {
                        TipoTela.USUARIO -> ConfiguraUsuario(innerPadding = innerPadding) { it ->
                            adicionarUsuario(it)
                            telaSelecionada = TipoTela.LISTA
                        }
                        TipoTela.LISTA -> Lista(
                            usuario = usuario,
                            innerPadding = innerPadding
                        ) {
                            senhaSelecionada = it
                            telaSelecionada = TipoTela.VISUALIZACAO
                        }
                        TipoTela.CADASTRO -> CadastrarSenha(innerPadding){
                            usuario?.senhas?.add(it)
                            telaSelecionada = TipoTela.LISTA
                        }
                        TipoTela.VISUALIZACAO -> VerSenha(innerPadding, usuario, senhaSelecionada){
                            telaSelecionada = TipoTela.LISTA
                            senhaSelecionada = null
                        }
                        else -> {
                            Text(text = "Tela não encontrada")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    App()
}