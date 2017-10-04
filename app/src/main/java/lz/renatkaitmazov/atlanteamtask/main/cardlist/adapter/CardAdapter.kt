package lz.renatkaitmazov.atlanteamtask.main.cardlist.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import lz.renatkaitmazov.atlanteamtask.R
import lz.renatkaitmazov.atlanteamtask.databinding.ItemCardBinding

/**
 *
 * @author Renat Kaitmazov
 */

class CardAdapter : RecyclerView.Adapter<CardViewHodler>() {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private val cardList: MutableList<Any> = ArrayList()

    /*------------------------------------------------------------------------*/
    // RecyclerView.Adapter implementation
    /*------------------------------------------------------------------------*/

    override fun getItemCount() = cardList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardViewHodler {
        val context = parent!!.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = DataBindingUtil.inflate<ItemCardBinding>(layoutInflater,
                R.layout.item_card,
                parent,
                false
        )
        return CardViewHodler(binding)
    }

    override fun onBindViewHolder(holder: CardViewHodler?, position: Int) {
        TODO("Create a view model class and then bind properties of that class with view")
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun add(card: Any): Boolean {
        val index = cardList.lastIndex
        val isAdded = cardList.add(card)
        if (isAdded) {
            notifyItemInserted(index)
        }
        return isAdded
    }

    fun addAll(cardList: List<Any>): Boolean {
        this.cardList.clear()
        val isAdded = this.cardList.addAll(cardList)
        if (isAdded) {
            notifyDataSetChanged()
        }
        return isAdded
    }
}