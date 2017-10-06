package lz.renatkaitmazov.atlanteamtask.main.cardlist.adapter

import android.support.v7.widget.RecyclerView
import lz.renatkaitmazov.atlanteamtask.databinding.ItemCardBinding
import lz.renatkaitmazov.atlanteamtask.main.cardlist.model.CommonViewModel

/**
 *
 * @author Renat Kaitmazov
 */

class CardViewHolder(private val binding: ItemCardBinding)
    : RecyclerView.ViewHolder(binding.cardItemRoot) {

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