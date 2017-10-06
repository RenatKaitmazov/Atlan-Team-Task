package lz.renatkaitmazov.atlanteamtask.main.contactlist.adapter

import android.support.v7.widget.RecyclerView
import lz.renatkaitmazov.atlanteamtask.databinding.ItemContactBinding
import lz.renatkaitmazov.atlanteamtask.main.contactlist.model.ContactViewModel

/**
 *
 * @author Renat Kaitmazov
 */

class ContactViewHolder(private val binding: ItemContactBinding)
    : RecyclerView.ViewHolder(binding.root) {

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun bind(contactItem: ContactViewModel) {
        binding.firstNameTextView.text = contactItem.firstName
        binding.lastNameTextView.text = contactItem.lastName
        binding.phoneNumberTextView.text = contactItem.phoneNumber
    }
}