package lz.renatkaitmazov.atlanteamtask.view.model

/**
 *
 * @author Renat Kaitmazov
 */

data class CommonViewModel(
        val ipAddress: String = "",
        val acceptLanguage: String = "",
        val host: String = "",
        val userAgent: String = "",
        val accept: String = "",
        val time: String = "",
        val millisSinceEpoch: String = "",
        val date: String = ""
)