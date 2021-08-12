package br.com.rodrigoeduque.zup.carros

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank

@Introspected
data class NovoCarroRequest(
    @field:NotBlank val modelo: String?,
    @field:NotBlank @field:Placa val placa: String?,
) {
    fun toCarro() :Carro {
        return Carro(modelo,placa)
    }

}
