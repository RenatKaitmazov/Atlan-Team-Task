package lz.renatkaitmazov.atlanteamtask.data.model

/**
 *
 * @author Renat Kaitmazov
 */

data class DynamicJsonModel(val response: HashMap<String, Any>) {
    init {
        println(response)
    }
}