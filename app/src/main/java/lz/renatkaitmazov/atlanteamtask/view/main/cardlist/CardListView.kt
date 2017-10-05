package lz.renatkaitmazov.atlanteamtask.view.main.cardlist

import lz.renatkaitmazov.atlanteamtask.base.LoadingView
import lz.renatkaitmazov.atlanteamtask.view.model.CommonViewModel

/**
 *
 * @author Renat Kaitmazov
 */

interface CardListView : LoadingView {
    fun showCommonData(commonData: List<CommonViewModel>)
}