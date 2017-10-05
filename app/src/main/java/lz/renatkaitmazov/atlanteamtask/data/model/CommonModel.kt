package lz.renatkaitmazov.atlanteamtask.data.model

/**
 *
 * @author Renat Kaitmazov
 */

data class CommonModel(
        val ipAddress: String = "",
        val acceptLanguage: String = "",
        val host: String = "",
        val userAgent: String = "",
        val accept: String = "",
        val time: String = "",
        val millisSinceEpoch: String = "",
        val date: String = ""
)