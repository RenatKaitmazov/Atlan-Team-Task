package lz.renatkaitmazov.atlanteamtask.data

/**
 *
 * @author Renat Kaitmazov
 */

class DataCache {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private val cache: MutableMap<String, Any> = HashMap(2)

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun <T: Any> save(key: String, value: T) {
        if (!cache.containsKey(key)) {
            cache[key] = value
        }
    }

    fun get(key: String) = cache[key]
}