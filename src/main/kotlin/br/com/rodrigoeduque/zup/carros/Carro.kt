package br.com.rodrigoeduque.zup.carros

import javax.persistence.*

@Entity
data class Carro(
    val modelo: String?,
    val placa: String?,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
}
