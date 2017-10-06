package lz.renatkaitmazov.atlanteamtask.main.contactlist

import lz.renatkaitmazov.atlanteamtask.base.Presenter

/**
 *
 * @author Renat Kaitmazov
 */

interface ContactListPresenter : Presenter<ContactListView> {
    fun getContactList()
}