package br.com.rodrigoeduque.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller("/autores-xml")
class CadastraAutorXmlController(
    @Inject val autorRepository: AutorRepository,
    val enderecoClientXml: EnderecoClientXml,
) {


    @Post
    @Transactional
    fun cadastra(@Body @Valid request: NovoAutorRequest): HttpResponse<Any> {

        val enderecoResponse: HttpResponse<EnderecoResponse> = enderecoClientXml.consultaXml(request.cep)

        if (enderecoResponse.body() == null) {
            println("Retorno da consulta do CEP null")
            return HttpResponse.badRequest()
        }

        val autor: Autor = request.paraAutor(enderecoResponse.body()!!) //toModel

        autorRepository.save(autor)

        val uri = UriBuilder.of("/autores/{id}").expand(mutableMapOf(Pair("id", autor.id)))

        return HttpResponse.created(uri)

    }

}