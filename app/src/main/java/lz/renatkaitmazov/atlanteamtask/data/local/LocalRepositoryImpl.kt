package lz.renatkaitmazov.atlanteamtask.data.local

import android.content.Context
import android.database.Cursor
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.provider.ContactsContract.Contacts
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import lz.renatkaitmazov.atlanteamtask.data.DataCache
import lz.renatkaitmazov.atlanteamtask.data.model.ContactModel

/**
 *
 * @author Renat Kaitmazov
 */

class LocalRepositoryImpl(private val dataCache: DataCache,
                          private val context: Context) : LocalRepository {

    /*------------------------------------------------------------------------*/
    // LocalRepository implementation
    /*------------------------------------------------------------------------*/

    override fun getContactList(): Flowable<List<ContactModel>> {
        val key = "Contacts Data"
        val cachedContactList: List<ContactModel>? = dataCache.get(key) as? List<ContactModel>
        if (cachedContactList != null) {
            return Flowable.just(cachedContactList)
        }

        return Flowable.create({ emitter: FlowableEmitter<List<ContactModel>> ->
            try {
                val contactCursor = getContactsCursor()
                val contactList = contactCursorToList(contactCursor)
                dataCache.save(key, contactList)
                emitter.onNext(contactList)
                emitter.onComplete()
            } catch (error: Throwable) {
                emitter.onError(error)
            }
        }, BackpressureStrategy.BUFFER)
    }

    private fun contactCursorToList(contactCursor: Cursor?): List<ContactModel> {
        val contactList = ArrayList<ContactModel>()
        contactCursor?.use {
            val nameColumnIndex = contactCursor.getColumnIndex(Contacts.DISPLAY_NAME)
            val contactIdIndex = contactCursor.getColumnIndex(Contacts._ID)
            val hasPhoneNumberIndex = contactCursor.getColumnIndex(Contacts.HAS_PHONE_NUMBER)
            while (contactCursor.moveToNext()) {
                val name = contactCursor.getString(nameColumnIndex)
                val hasPhoneNumber = contactCursor.getInt(hasPhoneNumberIndex) == 1
                val contactModel = ContactModel()
                setFirstAndLastNames(name, contactModel)
                if (hasPhoneNumber) {
                    val contactId = contactCursor.getString(contactIdIndex)
                    getPhoneNumberCursor(contactId).use { phoneCursor ->
                        val phoneNumberIndex = phoneCursor.getColumnIndex(Phone.NUMBER)
                        if (phoneCursor.moveToFirst()) {
                            val phoneNumber = phoneCursor.getString(phoneNumberIndex)
                            contactModel.phoneNumber = phoneNumber
                        }
                    }
                }
                contactList.add(contactModel)
            }
        }
        return contactList
    }

    private fun setFirstAndLastNames(fullName: String, contactModel: ContactModel) {
        val spaceIndex = fullName.indexOf(" ")
        if (spaceIndex < 0) {
            contactModel.firstName = fullName
            return
        }
        contactModel.firstName = fullName.substring(0, spaceIndex)
        contactModel.lastName = fullName.substring(spaceIndex + 1)
    }

    private fun getContactsCursor(): Cursor? {
        val uri = Contacts.CONTENT_URI
        val projection = arrayOf(Contacts._ID, Contacts.DISPLAY_NAME, Contacts.HAS_PHONE_NUMBER)
        return context.contentResolver
                .query(uri,
                        projection,
                        null,
                        null,
                        "${Contacts.DISPLAY_NAME} ASC"
                )
    }

    private fun getPhoneNumberCursor(contactId: String): Cursor {
        val uri = Phone.CONTENT_URI
        val projection = arrayOf(Phone.NUMBER)
        return context.contentResolver
                .query(uri,
                        projection,
                        "${Phone.CONTACT_ID} = ?",
                        arrayOf(contactId),
                        null
                )
    }
}