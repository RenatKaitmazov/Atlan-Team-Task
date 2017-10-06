package lz.renatkaitmazov.atlanteamtask.main.contactlist.model

import lz.renatkaitmazov.atlanteamtask.data.model.ContactModel

/**
 *
 * @author Renat Kaitmazov
 */

class ContactMapper {

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun map(contactModelList: List<ContactModel>): List<ContactViewModel> {
        val size = contactModelList.size
        val contactViewModelList = ArrayList<ContactViewModel>(size)
        for (model in contactModelList) {
            val viewModel = map(model)
            contactViewModelList.add(viewModel)
        }
        return contactViewModelList
    }

    private fun map(contactModel: ContactModel) = ContactViewModel(
            contactModel.firstName,
            contactModel.lastName,
            contactModel.phoneNumber
    )
}