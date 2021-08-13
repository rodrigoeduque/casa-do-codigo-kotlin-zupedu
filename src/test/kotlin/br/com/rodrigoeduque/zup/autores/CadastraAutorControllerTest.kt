package br.com.rodrigoeduque.zup.autores

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import javax.inject.Inject

@MicronautTest
internal class CadastraAutorControllerTest {

    @field:Inject
    lateinit var enderecoClientJson: EnderecoClientJson


    @field:Inject
    lateinit var autorRepository: AutorRepository

    @field:Inject
    @field:Client("/")
    lateinit var client: HttpClient

    lateinit var autor: Autor

    lateinit var enderecoResponse: EnderecoResponse


    @Test
    internal fun `deve cadastrar um novo autor`() {
        //cenario

        val novoAutorRequest = NovoAutorRequest("Rodrigo Eustáquio Duque",
            "rodrigo.duque@zup.com.br",
            "Autor Renomado do Best-Seller - Apanhando do Kotlin :D",
            "38401879",
            "77")

        enderecoResponse = EnderecoResponse("Rua Tomaz Martins de Campos", "Uberlândia", "MG")

        Mockito.`when`(enderecoClientJson.consultaJson(novoAutorRequest.cep))
            .thenReturn(HttpResponse.ok(enderecoResponse))

        val request = HttpRequest.POST("/autores", novoAutorRequest)

        // acao

        val response = client.toBlocking().exchange(request, Any::class.java)

        //corretude
        assertEquals(HttpStatus.CREATED, response.status)
        assertTrue(response.headers.contains("Location"))
        assertTrue(response.header("Location")!!.matches("/autores/\\d".toRegex()))

    }

    @MockBean(EnderecoClientJson::class)
    fun enderecoMock(): EnderecoClientJson {
        return Mockito.mock(EnderecoClientJson::class.java)
    }
}