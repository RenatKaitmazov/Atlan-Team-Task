package lz.renatkaitmazov.atlanteamtask.main.contactlist

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import lz.renatkaitmazov.atlanteamtask.base.AbsPresenter
import lz.renatkaitmazov.atlanteamtask.data.local.LocalRepository
import lz.renatkaitmazov.atlanteamtask.main.contactlist.model.ContactMapper
import java.util.concurrent.TimeUnit

/**
 *
 * @author Renat Kaitmazov
 */

class ContactListPresenterImpl(private val repository: LocalRepository,
                               private val mapper: ContactMapper)
    : AbsPresenter<ContactListView>(), ContactListPresenter {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private var contactDisposable: Disposable? = null

    /*------------------------------------------------------------------------*/
    // Overridden methods
    /*------------------------------------------------------------------------*/

    override fun unbind() {
        contactDisposable?.dispose()
        contactDisposable = null
        super.unbind()
    }

    /*------------------------------------------------------------------------*/
    // ContactListPresenter implementation
    /*------------------------------------------------------------------------*/

    override fun getContactList() {
        view?.showProgress()
        contactDisposable = repository.getContactList()
                .timeout(TIMEOUT, TimeUnit.SECONDS)
                .map(mapper::map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        next@ { contactList ->
                            view?.apply {
                                hideProgress()
                                showContactList(contactList)
                            }
                        },
                        error@ {
                            view?.hideProgress()
                        }
                )
    }
}