package br.com.rodrigoeduque.zup.carros

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface CarroRepository : JpaRepository<Carro, Long> {

}
