package br.com.rodrigoeduque.zup.autores

import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface AutorRepository : JpaRepository<Autor, Long> {

    fun findByEmail(email: String): Optional<Autor>

    @Query(value = "SELECT a FROM Autor a WHERE a.email = :email")
    fun buscaPorEmail(email: String) : Optional<Autor>



}
