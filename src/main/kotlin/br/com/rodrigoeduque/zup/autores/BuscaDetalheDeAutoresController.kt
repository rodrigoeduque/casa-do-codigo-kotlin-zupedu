package br.com.rodrigoeduque.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import javax.transaction.Transactional

@Controller("/autores")
class BuscaDetalheDeAutoresController(val autorRepository: AutorRepository) {

    @Get
    @Transactional
    fun lista(@QueryValue(defaultValue = "") email: String): HttpResponse<Any> {


        if (email.isBlank() || email.isEmpty()) {
            val listaAutores = autorRepository.findAll()

            val autoresResposta = listaAutores.map { autor -> DetalhesDoAutorResponse(autor) }

            return HttpResponse.ok(autoresResposta)
        }

//        val possivelAutor = autorRepository.findByEmail(email)

        val possivelAutor = autorRepository.buscaPorEmail(email)

        if (possivelAutor.isEmpty) {

            return HttpResponse.notFound()
        }

        val autor = possivelAutor.get()

        return HttpResponse.ok(DetalhesDoAutorResponse(autor))

    }

}