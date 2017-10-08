package lz.renatkaitmazov.atlanteamtask.main.cardlist

import lz.renatkaitmazov.atlanteamtask.base.LoadingView
import lz.renatkaitmazov.atlanteamtask.main.cardlist.model.CommonViewModel

/**
 *
 * @author Renat Kaitmazov
 */

interface CardListView : LoadingView {
    fun showCommonData(commonData: List<CommonViewModel>)
    fun showEchoJsonResult(result: String)
    fun showValidationResult(result: String)
}