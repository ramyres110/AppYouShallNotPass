package com.ramyres.youshallnotpass

import com.ramyres.youshallnotpass.util.criptografar
import com.ramyres.youshallnotpass.util.descriptografar

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testar_criptogafia_e_descriptografia(){
        val senha = "qwe12"
        val senhaCriptografada = criptografar(senha, "asd")
        val senhaDescriptografada = descriptografar(senhaCriptografada, "asd")
        assertEquals(senha, senhaDescriptografada)
    }

}