package lz.renatkaitmazov.atlanteamtask.base

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import lz.renatkaitmazov.atlanteamtask.R
import lz.renatkaitmazov.atlanteamtask.databinding.FragmentLoadingListBinding

/**
 * It is a base class for fragments which can show a progress view, and displays its content
 * in a list.
 *
 * @author Renat Kaitmazov
 */

abstract class LoadingListFragment : Fragment(), LoadingView {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    protected lateinit var binding: FragmentLoadingListBinding

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_loading_list, container, false)
        return binding.root
    }

    /*------------------------------------------------------------------------*/
    // LoadingView implementation
    /*------------------------------------------------------------------------*/

    final override fun showProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    final override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
    }
}