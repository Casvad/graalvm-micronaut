package example.micronaut

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import io.micronaut.core.annotation.TypeHint
import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("example.micronaut")
                .mainClass(Application.javaClass)
                .start()
    }
}