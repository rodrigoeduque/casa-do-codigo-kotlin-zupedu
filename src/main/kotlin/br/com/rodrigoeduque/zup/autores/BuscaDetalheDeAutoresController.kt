package br.com.rodrigoeduque.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/autores")
class BuscaDetalheDeAutoresController(val autorRepository: AutorRepository) {

    @Get
    fun lista(): HttpResponse<List<DetalhesDoAutorResponse>> {
        val listaAutores = autorRepository.findAll()
        val autoresResposta = listaAutores.map { autor -> DetalhesDoAutorResponse(autor) }
        return HttpResponse.ok(autoresResposta)
    }

}