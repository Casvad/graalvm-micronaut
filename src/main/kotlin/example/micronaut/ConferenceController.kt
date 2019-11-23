package example.micronaut

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.reactivex.Flowable
import io.reactivex.Single

@Controller("/conferences") // <1>
class ConferenceController(
    private val conferenceService: ConferenceService,
    private val restService: RestService
)// <2>
{

    @Get("/random") // <3>
    fun randomConf(): Conference { // <4>
        return conferenceService.randomConf()
    }

    @Post("/rand")
    fun randomConf2(
        @Body request: Conference
    ): Conference { // <4>
        return request
    }

    @Get("/employees-async")
    fun random2(
    ): Flowable<Map<String,Any>> { // <4>
        println("Hello")
        return this.restService.getEmployees()
    }

    @Get("/employees-blocking")
    fun random3(
    ): List<Map<String, Any>> { // <4>

        println("Hello")
        return this.restService.getEmployees().toObservable().toList().blockingGet()
    }

    @Get("/employees-blocking2")
    fun random4(
    ): List<Map<String, Any>> { // <4>

        println("Hello")
        return this.restService.getEmployeesV2().blockingGet()
    }
}