package br.com.rodrigoeduque.zup.carros

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint
import kotlin.annotation.AnnotationRetention.*
import kotlin.annotation.AnnotationTarget.*

@MustBeDocumented
@Target(FIELD, CONSTRUCTOR)//onde será executada
@Retention(RUNTIME) //Em RunTime o Frame poderá analisar em tempo de execução
@Constraint(validatedBy = [PlacaValidador::class])
annotation class Placa(val message: String = "Placa com formato inválido")

@Singleton
class PlacaValidador : ConstraintValidator<Placa,String> {
    /**
     * Implements the validation logic.
     *
     *
     * Implementations should be thread-safe and immutable.
     *
     * @param value object to validate
     * @param annotationMetadata The annotation metadata
     * @param context The context object
     *
     * @return `false` if `value` does not pass the constraint
     */
    override fun isValid(
        value: String?,
        annotationMetadata: AnnotationValue<Placa>,
        context: ConstraintValidatorContext,
    ): Boolean {

        if (value == null) {
            return true
        }

        return value.matches("[A-Z]{3}[0-9][0-9A-Z][0-9]{2}".toRegex())
    }

}
