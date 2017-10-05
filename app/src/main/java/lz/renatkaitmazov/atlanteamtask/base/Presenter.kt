package lz.renatkaitmazov.atlanteamtask.base

/**
 *
 * @author Renat Kaitmazov
 */

interface Presenter<in V : BaseView> {
    fun bind(view: V)
    fun unbind()
}