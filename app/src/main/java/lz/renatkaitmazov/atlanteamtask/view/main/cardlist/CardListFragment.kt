package lz.renatkaitmazov.atlanteamtask.view.main.cardlist

import android.os.Bundle
import android.view.View
import lz.renatkaitmazov.atlanteamtask.app.AtlanApp
import lz.renatkaitmazov.atlanteamtask.base.LoadingListFragment
import lz.renatkaitmazov.atlanteamtask.di.fragment.FragmentModule
import lz.renatkaitmazov.atlanteamtask.di.fragment.FragmentSubcomponent
import lz.renatkaitmazov.atlanteamtask.view.main.cardlist.adapter.CardAdapter
import lz.renatkaitmazov.atlanteamtask.view.model.CommonViewModel
import javax.inject.Inject

/**
 *
 * @author Renat Kaitmazov
 */

class CardListFragment : LoadingListFragment(), CardListView {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private var fragmentSubcomponent: FragmentSubcomponent? = null
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
        fragmentSubcomponent = AtlanApp.instance
                .appComponent
                .plus(FragmentModule())
        fragmentSubcomponent!!.inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getCommonData()
    }

    override fun onDestroy() {
        presenter.unbind()
        fragmentSubcomponent = null
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

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    companion object {
        fun newInstance() = CardListFragment()
    }
}