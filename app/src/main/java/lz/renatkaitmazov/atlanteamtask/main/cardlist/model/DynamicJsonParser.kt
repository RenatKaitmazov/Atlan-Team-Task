package lz.renatkaitmazov.atlanteamtask.main.cardlist.model

/**
 *
 * @author Renat Kaitmazov
 */

class DynamicJsonParser {

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun parse(dynamicJson: Map<String, Any>): String {
        val builder = StringBuilder()
        dynamicJson.asSequence()
                .iterator()
                .forEach { builder.append(it.key).append(": ").append(it.value).append("\n") }
        return builder.trim().toString()
    }
}