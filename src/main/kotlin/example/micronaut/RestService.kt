package example.micronaut

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

@Client("default-ms")
interface RestService {

    @Get("/todos")
    fun getEmployees(

    ): Flowable<Map<String,Any>>

    @Get("/todos")
    fun getEmployeesV2(

    ): Single<List<Map<String,Any>>>
}