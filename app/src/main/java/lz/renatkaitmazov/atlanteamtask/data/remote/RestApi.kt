package lz.renatkaitmazov.atlanteamtask.data.remote

import io.reactivex.Single
import lz.renatkaitmazov.atlanteamtask.data.model.DateTimeModel
import lz.renatkaitmazov.atlanteamtask.data.model.HeaderModel
import lz.renatkaitmazov.atlanteamtask.data.model.IpModel
import lz.renatkaitmazov.atlanteamtask.data.model.DynamicJsonModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Url

/**
 *
 * @author Renat Kaitmazov
 */

interface RestApi {
    @GET
    fun getIp(@Url url: String): Single<IpModel>

    @GET
    @Headers(
            "Accept: application/json",
            "User-Agent: Atlan Team Task App",
            "Accept-Language: ru-RU, en-USA, en-GB"
    )
    fun getHeaders(@Url url: String): Single<HeaderModel>

    @GET
    fun getDateTime(@Url url: String): Single<DateTimeModel>

    @GET
    fun echoJson(@Url url: String): Single<DynamicJsonModel>

    @GET
    fun validateJson(@Url url: String): Single<DynamicJsonModel>
}