package lz.renatkaitmazov.atlanteamtask.view.main.cardlist

import lz.renatkaitmazov.atlanteamtask.base.AbsPresenter

/**
 *
 * @author Renat Kaitmazov
 */

class CardListPresenterImpl : AbsPresenter<CardListView>(), CardListPresenter<CardListView> {

    /*------------------------------------------------------------------------*/
    // CardListPresenter implementation
    /*------------------------------------------------------------------------*/

    override fun fetchCommonData() {
        view?.showProgress()
        println("You rock!")
        view?.hideProgress()
    }
}