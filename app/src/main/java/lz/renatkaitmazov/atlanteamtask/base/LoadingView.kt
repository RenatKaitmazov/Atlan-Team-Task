package lz.renatkaitmazov.atlanteamtask.base

/**
 * Any view that needs to be waiting until its content is ready to show must implement
 * this interface.
 *
 * @author Renat Kaitmazov
 */

interface LoadingView : BaseView {
    /**
     * Shows progress of loading some content to the user.
     */
    fun showProgress()

    /**
     * Hides progress as soon as data is available to be shown.
     */
    fun hideProgress()
}