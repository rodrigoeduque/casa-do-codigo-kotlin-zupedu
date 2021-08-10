package br.com.rodrigoeduque.zup.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastraAutorController(@Inject val autorRepository: AutorRepository) {


    @Post
    fun cadastra(@Body @Valid request: NovoAutorRequest): HttpResponse<Status> {

        val autor: Autor = request.paraAutor() //toModel

        autorRepository.save(autor)

        return HttpResponse.ok()

    }


}