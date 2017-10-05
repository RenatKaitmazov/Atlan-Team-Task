package lz.renatkaitmazov.atlanteamtask.data.model

import com.google.gson.annotations.SerializedName

/**
 *
 * @author Renat Kaitmazov
 */

data class HeaderModel(
        @SerializedName("Accept-Language") var acceptLanguage: String = "",
        @SerializedName("Host") var host: String = "",
        @SerializedName("User-Agent") var userAgent: String = "",
        @SerializedName("Accept") var accept: String = ""
)