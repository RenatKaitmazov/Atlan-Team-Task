package lz.renatkaitmazov.atlanteamtask.data.remote

import io.reactivex.Single
import lz.renatkaitmazov.atlanteamtask.data.model.CommonModel
import lz.renatkaitmazov.atlanteamtask.data.model.DynamicJsonModel

/**
 *
 * @author Renat Kaitmazov
 */

interface RestRepository {
    fun getCommonData(): Single<CommonModel>
    fun validateJson(json: String): Single<DynamicJsonModel>
    fun echoJson(json: String): Single<DynamicJsonModel>
}