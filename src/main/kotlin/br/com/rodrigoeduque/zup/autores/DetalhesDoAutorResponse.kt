package br.com.rodrigoeduque.zup.autores


class DetalhesDoAutorResponse(
    val nome: String,
    val email: String,
    val descricao: String,
) {
    constructor(autor: Autor) : this(
        nome = autor.nome,
        email = autor.email,
        descricao = autor.descricao
    )


}
