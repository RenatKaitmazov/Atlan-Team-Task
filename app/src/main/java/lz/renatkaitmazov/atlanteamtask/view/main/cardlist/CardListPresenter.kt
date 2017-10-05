package lz.renatkaitmazov.atlanteamtask.view.main.cardlist

import lz.renatkaitmazov.atlanteamtask.base.BaseView
import lz.renatkaitmazov.atlanteamtask.base.Presenter

/**
 *
 * @author Renat Kaitmazov
 */

interface CardListPresenter<in V : BaseView> : Presenter<V> {
    fun fetchCommonData()
}