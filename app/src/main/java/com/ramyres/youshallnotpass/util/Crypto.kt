package com.ramyres.youshallnotpass.util

import java.util.Base64


fun criptografar(senha: String, salt: String): String {
    val originalString = senha + "|" + salt;
    val encodedString: String = Base64.getEncoder().encodeToString(originalString.toByteArray())
    return encodedString;
}

fun descriptografar(senhaCriptografada: String, salt: String): String {
    val decodedString: String = String(Base64.getDecoder().decode(senhaCriptografada))
    val senha = decodedString.split("|")[0]
    return senha
}