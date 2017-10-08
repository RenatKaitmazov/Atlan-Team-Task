package lz.renatkaitmazov.atlanteamtask.data

import java.util.concurrent.ConcurrentHashMap

/**
 *
 * @author Renat Kaitmazov
 */

class DataCache {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private val cache = ConcurrentHashMap<String, Any>(2)

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