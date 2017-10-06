package lz.renatkaitmazov.atlanteamtask.data

import io.reactivex.Single

/**
 *
 * @author Renat Kaitmazov
 */

class CommonDataCache {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private val cache: MutableMap<String, Any> = HashMap(1)

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