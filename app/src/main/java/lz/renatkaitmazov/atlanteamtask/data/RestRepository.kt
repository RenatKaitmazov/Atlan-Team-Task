package lz.renatkaitmazov.atlanteamtask.data

import io.reactivex.Single
import lz.renatkaitmazov.atlanteamtask.data.model.CommonModel

/**
 *
 * @author Renat Kaitmazov
 */

interface RestRepository {
    fun getCommonData(): Single<CommonModel>
}