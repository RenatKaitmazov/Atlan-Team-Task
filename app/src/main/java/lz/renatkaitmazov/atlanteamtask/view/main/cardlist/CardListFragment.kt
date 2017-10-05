package lz.renatkaitmazov.atlanteamtask.view.main.cardlist

import lz.renatkaitmazov.atlanteamtask.base.LoadingListFragment
import lz.renatkaitmazov.atlanteamtask.view.main.cardlist.adapter.CardAdapter

/**
 *
 * @author Renat Kaitmazov
 */

class CardListFragment : LoadingListFragment() {

    /*------------------------------------------------------------------------*/
    // LoadingListFragment implementation
    /*------------------------------------------------------------------------*/

    override fun getAdapter() = CardAdapter()

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    companion object {
        fun newInstance() = CardListFragment()
    }
}