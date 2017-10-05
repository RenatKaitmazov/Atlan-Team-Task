package lz.renatkaitmazov.atlanteamtask.base

/**
 *
 * @author Renat Kaitmazov
 */

abstract class AbsPresenter<V : BaseView> : Presenter<V> {

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    protected var view: V? = null

    /*------------------------------------------------------------------------*/
    // Presenter implementation
    /*------------------------------------------------------------------------*/

    override fun bind(view: V) {
        this.view = view
    }

    override fun unbind() {
        view = null
    }
}