package br.com.rodrigoeduque.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

@Client("https://viacep.com.br/ws/")
interface EnderecoClientJson {

    @Get(value = "{cep}/json")
    fun consultaJson(cep:String) : HttpResponse<EnderecoResponse>
}