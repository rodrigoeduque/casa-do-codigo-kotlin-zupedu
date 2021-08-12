package br.com.rodrigoeduque.zup.carros

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Controller
@Validated
class CadastraCarroController(val carroRepository: CarroRepository) {

    @Post(value = "carros/")
    fun cadastra(@Body @Valid request: NovoCarroRequest): HttpResponse<Any> {

        val carro: Carro = request.toCarro()

        carroRepository.save(carro)

        return HttpResponse.ok(carro)
    }
}