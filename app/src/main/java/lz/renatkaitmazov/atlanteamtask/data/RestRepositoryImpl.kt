package lz.renatkaitmazov.atlanteamtask.data

import io.reactivex.Single
import io.reactivex.functions.Function3
import lz.renatkaitmazov.atlanteamtask.data.model.CommonModel
import lz.renatkaitmazov.atlanteamtask.data.model.DateTimeModel
import lz.renatkaitmazov.atlanteamtask.data.model.HeaderModel
import lz.renatkaitmazov.atlanteamtask.data.model.IpModel
import retrofit2.Retrofit

/**
 *
 * @author Renat Kaitmazov
 */

class RestRepositoryImpl(retrofit: Retrofit,
                         private val urlProvider: DynamicUrlProvider) : RestRepository {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private val restApi = retrofit.create(RestApi::class.java)

    /*------------------------------------------------------------------------*/
    // RestRepository implementation
    /*------------------------------------------------------------------------*/

    override fun getCommonData(): Single<CommonModel> {
        val ipUrl = urlProvider.getUrl(DynamicUrlProvider.URL_IP_ADDRESS)
        val headersUrl = urlProvider.getUrl(DynamicUrlProvider.URL_HEADERS)
        val dateTimeUrl = urlProvider.getUrl(DynamicUrlProvider.URL_DATE_TIME)
        return Single.zip(
                restApi.getIp(ipUrl),
                restApi.getHeaders(headersUrl),
                restApi.getDateTime(dateTimeUrl),
                Function3<IpModel, HeaderModel, DateTimeModel, CommonModel> { ip, hdr, dt ->
                    CommonModel(
                            ip.ip,
                            hdr.acceptLanguage,
                            hdr.host,
                            hdr.userAgent,
                            hdr.accept,
                            dt.time,
                            dt.millisSinceEpoch,
                            dt.date
                    )
                }
        )
    }
}