package lz.renatkaitmazov.atlanteamtask.view.model

import lz.renatkaitmazov.atlanteamtask.data.model.CommonModel

/**
 *
 * @author Renat Kaitmazov
 */

class ViewModelMapper {

    /*------------------------------------------------------------------------*/
    // Static
    /*------------------------------------------------------------------------*/

    companion object {
        // We need to have 10 cards in the card list
        private const val ELEMENT_COUNT = 10
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun map(commonModel: CommonModel): List<CommonViewModel> {
        val commonViewModel = CommonViewModel(
                commonModel.ipAddress,
                commonModel.acceptLanguage,
                commonModel.host,
                commonModel.userAgent,
                commonModel.accept,
                commonModel.time,
                commonModel.millisSinceEpoch,
                commonModel.date
        )
        return List(ELEMENT_COUNT) { commonViewModel }
    }
}