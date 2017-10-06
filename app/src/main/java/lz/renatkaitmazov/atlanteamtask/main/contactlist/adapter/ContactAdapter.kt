package lz.renatkaitmazov.atlanteamtask.main.contactlist.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import lz.renatkaitmazov.atlanteamtask.R
import lz.renatkaitmazov.atlanteamtask.databinding.ItemContactBinding
import lz.renatkaitmazov.atlanteamtask.main.contactlist.model.ContactViewModel

/**
 *
 * @author Renat Kaitmazov
 */

class ContactAdapter(private val contactList: MutableList<ContactViewModel> = ArrayList())
    : RecyclerView.Adapter<ContactViewHolder>() {


    /*------------------------------------------------------------------------*/
    // RecyclerView.Adapter implementation
    /*------------------------------------------------------------------------*/

    override fun getItemCount() = contactList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ContactViewHolder {
        val context = parent!!.context
        val layoutInflater = LayoutInflater.from(context)
        val binding = DataBindingUtil.inflate<ItemContactBinding>(layoutInflater,
                R.layout.item_contact,
                parent,
                false
        )
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder?, position: Int) {
        holder?.bind(contactList[position])
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun addAll(contactList: List<ContactViewModel>): Boolean {
        this.contactList.clear()
        val isAdded = this.contactList.addAll(contactList)
        if (isAdded) {
            notifyDataSetChanged()
        }
        return isAdded
    }
}