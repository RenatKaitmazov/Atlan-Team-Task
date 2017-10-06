package lz.renatkaitmazov.atlanteamtask.data.local

import io.reactivex.Flowable
import lz.renatkaitmazov.atlanteamtask.data.model.ContactModel

/**
 *
 * @author Renat Kaitmazov
 */

interface LocalRepository {
    fun getContactList(): Flowable<List<ContactModel>>
}