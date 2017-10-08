package lz.renatkaitmazov.atlanteamtask.main.cardlist

import android.os.Bundle
import android.widget.Toast
import lz.renatkaitmazov.atlanteamtask.R
import lz.renatkaitmazov.atlanteamtask.app.AtlanApp
import lz.renatkaitmazov.atlanteamtask.base.LoadingListFragment
import lz.renatkaitmazov.atlanteamtask.di.fragment.CardListFragmentModule
import lz.renatkaitmazov.atlanteamtask.di.fragment.CardListFragmentSubcomponent
import lz.renatkaitmazov.atlanteamtask.main.cardlist.adapter.CardAdapter
import lz.renatkaitmazov.atlanteamtask.main.cardlist.adapter.CardViewHolder
import lz.renatkaitmazov.atlanteamtask.main.cardlist.model.CommonViewModel
import javax.inject.Inject

/**
 *
 * @author Renat Kaitmazov
 */

class CardListFragment : LoadingListFragment(), CardListView, CardViewHolder.Callback {

    /*------------------------------------------------------------------------*/
    // Static
    /*------------------------------------------------------------------------*/

    companion object {
        private const val TAG_ECHO_DIALOG = "ECHO_DIALOG"
        private const val TAG_VALIDATION_DIALOG = "VALIDATION_DIALOG"

        fun newInstance() = CardListFragment()
    }

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private var subcomponent: CardListFragmentSubcomponent? = null
    @Inject internal lateinit var presenter: CardListPresenterImpl

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

    override fun showEchoJsonResult(result: String) {
        showJsonResultDialog(result, TAG_ECHO_DIALOG)
    }

    override fun showValidationResult(result: String) {
        showJsonResultDialog(result, TAG_VALIDATION_DIALOG)
    }

    private fun showJsonResultDialog(jsonResult: String, tag: String) {
        val dialog = JsonResultDialog.newInstance(jsonResult)
        dialog.show(activity.supportFragmentManager, tag)
    }

    /*------------------------------------------------------------------------*/
    // LoadingListFragment implementation
    /*------------------------------------------------------------------------*/

    override fun getAdapter() = CardAdapter(cardViewHolderListener = this)

    /*------------------------------------------------------------------------*/
    // CardViewHolder.Callback implementation
    /*------------------------------------------------------------------------*/

    override fun onEchoJsonButtonClick(json: String) = presenter.echoJson(json)

    override fun onValidateJsonButtonClick(json: String) = presenter.validateJson(json)

    override fun onEmptyJsonSubmit() {
        Toast.makeText(activity, R.string.warning_empty_edit_text, Toast.LENGTH_SHORT).show()
    }
}