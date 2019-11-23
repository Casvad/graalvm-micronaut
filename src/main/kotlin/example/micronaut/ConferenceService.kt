package example.micronaut

import com.fasterxml.jackson.databind.ObjectMapper
import java.util.*
import javax.inject.Singleton

@Singleton // <1>
class ConferenceService {

    fun randomConf(): Conference { // <2>
        return CONFERENCES[Random().nextInt(CONFERENCES.size)]
    }

    companion object {

        private val CONFERENCES = Arrays.asList(
            Conference("Greach", listOf(Widget().apply {
                subTitle = "hola mundo"
                additionalInformation = hashMapOf("hola" to "mundo")
            } ))

        )
    }
}