package lz.renatkaitmazov.atlanteamtask.data.remote

import android.support.annotation.IntDef

/**
 *
 * @author Renat Kaitmazov
 */

class DynamicUrlProvider {

    /*------------------------------------------------------------------------*/
    // Static
    /*------------------------------------------------------------------------*/

    companion object {

        @IntDef(URL_IP_ADDRESS, URL_HEADERS, URL_DATE_TIME)
        @Retention(AnnotationRetention.SOURCE)
        annotation class UrlKey

        const val URL_IP_ADDRESS = 0L
        const val URL_HEADERS = 1L
        const val URL_DATE_TIME = 2L

        @JvmStatic
        private val URL_LIST = listOf(
                "http://ip.jsontest.com/",
                "http://headers.jsontest.com/",
                "http://date.jsontest.com"
        )
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun getUrl(@UrlKey urlKey: Long) = URL_LIST[urlKey.toInt()]
}