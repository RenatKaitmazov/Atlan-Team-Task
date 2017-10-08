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

        @IntDef(URL_IP_ADDRESS, URL_HEADERS, URL_DATE_TIME, URL_JSON_ECHO, URL_JSON_VALIDATION)
        @Retention(AnnotationRetention.SOURCE)
        annotation class UrlKey

        const val URL_IP_ADDRESS = 0L
        const val URL_HEADERS = 1L
        const val URL_DATE_TIME = 2L
        const val URL_JSON_ECHO = 3L
        const val URL_JSON_VALIDATION = 4L

        @JvmStatic
        private val URL_LIST = listOf(
                "http://ip.jsontest.com/",
                "http://headers.jsontest.com/",
                "http://date.jsontest.com/",
                "http://echo.jsontest.com/",
                "http://validate.jsontest.com/?json="
        )
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun getUrl(@UrlKey urlKey: Long) = URL_LIST[urlKey.toInt()]
}