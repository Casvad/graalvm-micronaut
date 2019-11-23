package example.micronaut

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.JsonNode
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.TypeHint

@Introspected
@TypeHint
data class Widget (

    var id: String = "",
    var name: String = "",
    var title: String = "",
    var image: String = "",
    var background: Boolean = true,
    @field:JsonProperty("sub_title")
    var subTitle: String = "",
    var description: String = "",
    var style: String = "",
    var category: String? = null,
    var async: Boolean = false,
    var type: String = "",
    @field:JsonProperty("elements_to_show")
    var elementsToShow: Int = 10,
    @field:JsonProperty("additional_information")
    var additionalInformation: Map<String, Any>? = null
)