package lz.renatkaitmazov.atlanteamtask.main.cardlist

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import lz.renatkaitmazov.atlanteamtask.R

/**
 *
 * @author Renat Kaitmazov
 */

class JsonResultDialog : DialogFragment() {

    /*------------------------------------------------------------------------*/
    // Static
    /*------------------------------------------------------------------------*/

    companion object {
        private const val ARGUMENT_JSON_RESULT = "ARGUMENT_JSON_RESULT"

        fun newInstance(jsonResult: String): JsonResultDialog {
            val args = Bundle(1)
            args.putString(ARGUMENT_JSON_RESULT, jsonResult)
            val dialog = JsonResultDialog()
            dialog.arguments = args
            return dialog
        }
    }

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private var jsonResult: String? = null

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val args = arguments
        jsonResult = args.getString(ARGUMENT_JSON_RESULT, "")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity)
                .setMessage(jsonResult)
                .setPositiveButton(R.string.title_positive_button) { dialog, _ ->
                    dialog.dismiss()
                }
                .create()
    }

}