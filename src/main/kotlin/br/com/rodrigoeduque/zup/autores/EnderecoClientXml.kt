package br.com.rodrigoeduque.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Produces
import io.micronaut.http.client.annotation.Client

@Client("https://viacep.com.br/ws/")
interface EnderecoClientXml {

    @Get("{cep}/xml/")
    @Produces(value = [MediaType.APPLICATION_XML])
    fun consultaXml(@PathVariable cep:String) : HttpResponse<EnderecoResponse>

}