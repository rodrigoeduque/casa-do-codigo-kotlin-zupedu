package br.com.rodrigoeduque.zup.carros

import io.micronaut.test.annotation.TransactionMode
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest(
    rollback = false, // default é true
    transactionMode = TransactionMode.SINGLE_TRANSACTION, //default é SEPARATED_TRANSACTIONS
//    transactional = false //default true
)
internal class CadastraCarroControllerTest {

    @field:Inject
    lateinit var carroRepository: CarroRepository

    @BeforeEach
    fun setUp() {
        println(" BeforeEach ==> ")
        carroRepository.deleteAll()
    }

    @AfterEach
    fun tearDown() {
        println(" AfterEach ==> ")
        carroRepository.deleteAll()
    }

    @Test
    internal fun `deve inserir um novo carro`() {
        println(" TESTE ==> deve inserir um novo carro ")

        //acao
        val carro = Carro("Gol Bola", "HEO7659")
        carroRepository.save(carro)

        //validacao
        assertEquals(1, carroRepository.count())
        assertEquals(carro.modelo, "Gol Bola")
        assertEquals(carro.placa, "HEO7659")
    }

    @Test
    internal fun `deve encontrar carro pela placa`() {
        println(" TESTE ==> deve encontrar carro pela placa ")

        val carro = Carro("Gol Bola", "HEO7659")
        carroRepository.save(carro)

        val existePlaca = carroRepository.findByPlaca("HEO7659")
        assertFalse(existePlaca.isEmpty)
    }
}