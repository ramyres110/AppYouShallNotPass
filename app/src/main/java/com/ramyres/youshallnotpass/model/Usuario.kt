package com.ramyres.youshallnotpass.model

data class Usuario(val nome: String, val senhaMestre: String, val senhas: MutableList<Senha>)