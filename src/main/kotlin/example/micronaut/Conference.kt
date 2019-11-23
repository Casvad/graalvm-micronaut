package example.micronaut

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected

@Introspected // <1>
data class Conference (

    @field:JsonProperty("some_name")
    val someName: String? = null,

    val widgets: List<Widget> = emptyList()
)