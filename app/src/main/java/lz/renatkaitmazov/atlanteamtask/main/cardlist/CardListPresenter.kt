package lz.renatkaitmazov.atlanteamtask.main.cardlist

import lz.renatkaitmazov.atlanteamtask.base.Presenter

/**
 *
 * @author Renat Kaitmazov
 */

interface CardListPresenter : Presenter<CardListView> {
    fun getCommonData()
    fun echoJson(json: String)
    fun validateJson(json: String)
}