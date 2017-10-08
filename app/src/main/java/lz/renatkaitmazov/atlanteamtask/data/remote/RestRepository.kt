package lz.renatkaitmazov.atlanteamtask.data.remote

import io.reactivex.Single
import lz.renatkaitmazov.atlanteamtask.data.model.CommonModel

/**
 *
 * @author Renat Kaitmazov
 */

interface RestRepository {
    fun getCommonData(): Single<CommonModel>
    fun echoJson(json: String): Single<Map<String, Any>>
    fun validateJson(json: String): Single<Map<String, Any>>
}