package br.com.rodrigoeduque.zup.autores

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Autor(
    @Column(nullable = false)
    val nome: String,
    @Column(nullable = false)
    val email: String,
    @Column(length = 400 )
    var descricao: String,
) {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(nullable = false)
    val criadoEm: LocalDateTime = LocalDateTime.now()

}
