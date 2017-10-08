package lz.renatkaitmazov.atlanteamtask.main.cardlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import lz.renatkaitmazov.atlanteamtask.R
import lz.renatkaitmazov.atlanteamtask.databinding.ItemCardBinding
import lz.renatkaitmazov.atlanteamtask.main.cardlist.model.CommonViewModel

/**
 *
 * @author Renat Kaitmazov
 */

class CardViewHolder(private val binding: ItemCardBinding,
                     private val cardViewHolderListener: Callback? = null) :
        RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

    /*------------------------------------------------------------------------*/
    // Interfaces
    /*------------------------------------------------------------------------*/

    interface Callback {
        fun onEchoJsonButtonClick(json: String)
        fun onValidateJsonButtonClick(json: String)
        fun onEmptyJsonSubmit()
    }

    /*------------------------------------------------------------------------*/
    // Initialization
    /*------------------------------------------------------------------------*/

    init {
        binding.submitEchoJsonButton.setOnClickListener(this)
        binding.submitValidationButton.setOnClickListener(this)
    }

    /*------------------------------------------------------------------------*/
    // View.OnClickListener implementation
    /*------------------------------------------------------------------------*/

    override fun onClick(view: View?) {
        view?.apply {
            when (id) {
                R.id.submit_echo_json_button -> {
                    val json = binding.echoJsonEditText.text.trim().toString()
                    if (json.length > 0) {
                        cardViewHolderListener?.apply {
                            onEchoJsonButtonClick(json)
                            binding.echoJsonEditText.text = null
                        }
                    } else {
                        cardViewHolderListener?.onEmptyJsonSubmit()
                    }
                }
                R.id.submit_validation_button -> {
                    val json = binding.validationEditText.text.trim().toString()
                    if (json.length > 0) {
                        cardViewHolderListener?.apply {
                            onValidateJsonButtonClick(json)
                            binding.validationEditText.text = null
                        }
                    } else {
                        cardViewHolderListener?.onEmptyJsonSubmit()
                    }
                }
            }
        }
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    fun bind(commonViewModel: CommonViewModel) {
        binding.ipTextView.text = commonViewModel.ipAddress
        binding.acceptLanguageTextView.text = commonViewModel.acceptLanguage
        binding.hostTextView.text = commonViewModel.host
        binding.userAgentTextView.text = commonViewModel.userAgent
        binding.acceptTextView.text = commonViewModel.accept
        binding.timeTextView.text = commonViewModel.time
        binding.millisecondsTextView.text = commonViewModel.millisSinceEpoch
        binding.dateTextView.text = commonViewModel.date
    }
}