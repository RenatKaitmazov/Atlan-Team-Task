package lz.renatkaitmazov.atlanteamtask.data.remote

import io.reactivex.Single
import lz.renatkaitmazov.atlanteamtask.data.model.CommonModel

/**
 *
 * @author Renat Kaitmazov
 */

interface RestRepository {
    fun getCommonData(): Single<CommonModel>
}