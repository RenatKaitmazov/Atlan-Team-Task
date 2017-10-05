package lz.renatkaitmazov.atlanteamtask.data.model

import com.google.gson.annotations.SerializedName

/**
 *
 * @author Renat Kaitmazov
 */

data class DateTimeModel(
        var time: String = "",
        @SerializedName("milliseconds_since_epoch") var millisSinceEpoch: String = "",
        var date: String = ""
)