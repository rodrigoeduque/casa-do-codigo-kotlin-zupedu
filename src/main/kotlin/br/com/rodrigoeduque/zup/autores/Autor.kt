package br.com.rodrigoeduque.zup.autores

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Autor(
    @Column(nullable = false)
    val nome: String,
    @Column(nullable = false)
    val email: String,
    @Column(length = 400)
    var descricao: String,
    val endereco: Endereco,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(nullable = false)
    val criadoEm: LocalDateTime = LocalDateTime.now()

}
