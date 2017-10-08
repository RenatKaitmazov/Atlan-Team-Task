package lz.renatkaitmazov.atlanteamtask.data.remote

import io.reactivex.Single
import io.reactivex.functions.Function3
import lz.renatkaitmazov.atlanteamtask.data.DataCache
import lz.renatkaitmazov.atlanteamtask.data.model.*
import retrofit2.Retrofit

/**
 *
 * @author Renat Kaitmazov
 */

class RestRepositoryImpl(retrofit: Retrofit,
                         private val urlProvider: DynamicUrlProvider,
                         private val cache: DataCache) : RestRepository {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private val restApi = retrofit.create(RestApi::class.java)

    /*------------------------------------------------------------------------*/
    // RestRepository implementation
    /*------------------------------------------------------------------------*/

    override fun getCommonData(): Single<CommonModel> {
        val key = "Common Data"
        val cachedCommonModel: CommonModel? = cache.get(key) as CommonModel?
        if (cachedCommonModel != null) {
            return Single.just(cachedCommonModel)
        }

        val ipUrl = urlProvider.getUrl(DynamicUrlProvider.URL_IP_ADDRESS)
        val headersUrl = urlProvider.getUrl(DynamicUrlProvider.URL_HEADERS)
        val dateTimeUrl = urlProvider.getUrl(DynamicUrlProvider.URL_DATE_TIME)
        return Single.zip(
                restApi.getIp(ipUrl),
                restApi.getHeaders(headersUrl),
                restApi.getDateTime(dateTimeUrl),
                Function3<IpModel, HeaderModel, DateTimeModel, CommonModel> zipper@ { ip, hdr, dt ->
                    val commonModel = CommonModel(
                            ip.ip,
                            hdr.acceptLanguage,
                            hdr.host,
                            hdr.userAgent,
                            hdr.accept,
                            dt.time,
                            dt.millisSinceEpoch,
                            dt.date
                    )
                    cache.save(key, commonModel)
                    return@zipper commonModel
                }
        )
    }

    override fun echoJson(json: String): Single<Map<String, Any>> {
        val echoUrl = urlProvider.getUrl(DynamicUrlProvider.URL_JSON_ECHO)
        val builder = StringBuilder(echoUrl)
        json.split(" ").forEach { builder.append(it).append("/") }
        return restApi.echoJson(builder.toString())
    }

    override fun validateJson(json: String): Single<Map<String, Any>> {
        val validationUrl = urlProvider.getUrl(DynamicUrlProvider.URL_JSON_VALIDATION)
        val completeUrl = "$validationUrl$json"
        return restApi.validateJson(completeUrl)
    }
}