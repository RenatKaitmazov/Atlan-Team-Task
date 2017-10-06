package lz.renatkaitmazov.atlanteamtask.main.cardlist

import android.os.Bundle
import lz.renatkaitmazov.atlanteamtask.app.AtlanApp
import lz.renatkaitmazov.atlanteamtask.base.LoadingListFragment
import lz.renatkaitmazov.atlanteamtask.di.fragment.CardListFragmentModule
import lz.renatkaitmazov.atlanteamtask.di.fragment.CardListFragmentSubcomponent
import lz.renatkaitmazov.atlanteamtask.main.cardlist.adapter.CardAdapter
import lz.renatkaitmazov.atlanteamtask.main.cardlist.model.CommonViewModel
import javax.inject.Inject

/**
 *
 * @author Renat Kaitmazov
 */

class CardListFragment : LoadingListFragment(), CardListView {

    /*------------------------------------------------------------------------*/
    // Static
    /*------------------------------------------------------------------------*/

    companion object {
        fun newInstance() = CardListFragment()
    }

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private var subcomponent: CardListFragmentSubcomponent? = null
    @Inject lateinit var presenter: CardListPresenterImpl

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeInjectable()
        presenter.bind(this)
    }

    private fun makeInjectable() {
        subcomponent = AtlanApp.instance
                .appComponent
                .plus(CardListFragmentModule())
        subcomponent!!.inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.getCommonData()
    }

    override fun onDestroy() {
        presenter.unbind()
        subcomponent = null
        super.onDestroy()
    }

    /*------------------------------------------------------------------------*/
    // CardListView implementation
    /*------------------------------------------------------------------------*/
    override fun showCommonData(commonData: List<CommonViewModel>) {
        val cardAdapter = recyclerView.adapter as? CardAdapter
        cardAdapter?.addAll(commonData)
    }

    /*------------------------------------------------------------------------*/
    // LoadingListFragment implementation
    /*------------------------------------------------------------------------*/

    override fun getAdapter() = CardAdapter()
}