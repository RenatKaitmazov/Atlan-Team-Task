package lz.renatkaitmazov.atlanteamtask.main.contactlist

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import lz.renatkaitmazov.atlanteamtask.app.AtlanApp
import lz.renatkaitmazov.atlanteamtask.base.LoadingListFragment
import lz.renatkaitmazov.atlanteamtask.di.fragment.ContactListFragmentModule
import lz.renatkaitmazov.atlanteamtask.di.fragment.ContactListFragmentSubcomponent
import lz.renatkaitmazov.atlanteamtask.main.contactlist.adapter.ContactAdapter
import lz.renatkaitmazov.atlanteamtask.main.contactlist.model.ContactViewModel
import javax.inject.Inject

/**
 *
 * @author Renat Kaitmazov
 */

class ContactListFragment : LoadingListFragment(), ContactListView {

    /*------------------------------------------------------------------------*/
    // Static
    /*------------------------------------------------------------------------*/

    companion object {
        const val REQUEST_READ_CONTACTS = 1

        fun newInstance() = ContactListFragment()
    }

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private var subcomponent: ContactListFragmentSubcomponent? = null
    @Inject lateinit var presenter: ContactListPresenterImpl

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        makeInjectable()
        presenter.bind(this)
        val readContacts = android.Manifest.permission.READ_CONTACTS
        if (ActivityCompat.checkSelfPermission(activity, readContacts)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(readContacts), REQUEST_READ_CONTACTS)
        }
    }

    private fun makeInjectable() {
        subcomponent = AtlanApp.instance
                .appComponent
                .plus(ContactListFragmentModule())
        subcomponent!!.inject(this)
    }

    override fun onStart() {
        super.onStart()
        val readContactsPermission = android.Manifest.permission.READ_CONTACTS
        if (ActivityCompat.checkSelfPermission(activity, readContactsPermission)
                == PackageManager.PERMISSION_GRANTED) {
            presenter.getContactList()

        }
    }

    override fun onDestroy() {
        presenter.unbind()
        subcomponent = null
        super.onDestroy()
    }

    /*------------------------------------------------------------------------*/
    // LoadingListFragment implementation
    /*------------------------------------------------------------------------*/

    override fun getAdapter() = ContactAdapter()

    /*------------------------------------------------------------------------*/
    // ContactListView implementation
    /*------------------------------------------------------------------------*/

    override fun showContactList(contactList: List<ContactViewModel>) {
        val adapter = recyclerView.adapter as? ContactAdapter
        adapter?.addAll(contactList)
    }

    /*------------------------------------------------------------------------*/
    // Permissions
    /*------------------------------------------------------------------------*/

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<out String>,
                                            grantResults: IntArray) {
        when (requestCode) {
            REQUEST_READ_CONTACTS -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    presenter.getContactList()
                }
            }
        }
    }
}