package example.micronaut

import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class LowLevelClient(
    @Client("default-ms")
    private val client: RxHttpClient
) {

    fun getEmployeesV2(): Maybe<List<Map<*, *>>> {

        return this.client.retrieve(HttpRequest.GET<String>("/todos"), Argument.listOf(Map::class.java)).firstElement()
    }
}