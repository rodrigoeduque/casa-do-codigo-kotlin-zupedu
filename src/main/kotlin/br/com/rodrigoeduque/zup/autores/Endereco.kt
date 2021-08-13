package br.com.rodrigoeduque.zup.autores

import javax.persistence.Embeddable

@Embeddable
class Endereco(
    enderecoResponse: EnderecoResponse,
    val cep : String,
    val numero: String,
) {

    val logradouro = enderecoResponse.logradouro
    val cidade = enderecoResponse.localidade
    val estado = enderecoResponse.uf
}

