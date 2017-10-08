package lz.renatkaitmazov.atlanteamtask.main.cardlist.model

import lz.renatkaitmazov.atlanteamtask.data.model.DynamicJsonModel

/**
 *
 * @author Renat Kaitmazov
 */

class DynamicJsonParser {

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun parse(dynamicJson: DynamicJsonModel): String {
        val response = dynamicJson.response
        val builder = StringBuilder()
        for (entry in response.entries) {
            builder.append(entry.key).append(": ").append(entry.value).append("\n")
        }
        return builder.trim().toString()
    }
}