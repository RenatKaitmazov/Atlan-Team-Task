package lz.renatkaitmazov.atlanteamtask.main.cardlist.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import lz.renatkaitmazov.atlanteamtask.R
import lz.renatkaitmazov.atlanteamtask.databinding.ItemCardBinding
import lz.renatkaitmazov.atlanteamtask.main.cardlist.model.CommonViewModel

/**
 *
 * @author Renat Kaitmazov
 */

class CardAdapter(cardList: MutableList<CommonViewModel> = ArrayList())
    : RecyclerView.Adapter<CardViewHolder>() {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private val cardList: MutableList<CommonViewModel> = cardList

    /*------------------------------------------------------------------------*/
    // RecyclerView.Adapter implementation
    /*------------------------------------------------------------------------*/

    override fun getItemCount() = cardList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardViewHolder {
        val context = parent!!.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = DataBindingUtil.inflate<ItemCardBinding>(layoutInflater,
                R.layout.item_card,
                parent,
                false
        )
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder?, position: Int) {
        holder?.bind(cardList[position])
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun addAll(cardList: List<CommonViewModel>): Boolean {
        this.cardList.clear()
        val isAdded = this.cardList.addAll(cardList)
        if (isAdded) {
            notifyDataSetChanged()
        }
        return isAdded
    }
}