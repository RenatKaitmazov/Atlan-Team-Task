package lz.renatkaitmazov.atlanteamtask.main.contactlist

import lz.renatkaitmazov.atlanteamtask.base.LoadingView
import lz.renatkaitmazov.atlanteamtask.main.contactlist.model.ContactViewModel

/**
 *
 * @author Renat Kaitmazov
 */

interface ContactListView : LoadingView {
    fun showContactList(contactList: List<ContactViewModel>)
}