package lz.renatkaitmazov.atlanteamtask.app

import android.app.Application

/**
 *
 * @author Renat Kaitmazov
 */

class AtlanApp: Application() {

    /*------------------------------------------------------------------------*/
    // Static
    /*------------------------------------------------------------------------*/

    companion object {
        @JvmStatic lateinit var instance: AtlanApp
            private set
    }

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    override fun onCreate() {
        super.onCreate()
        // Make UI as responsible as possible
        Thread.currentThread().priority = Thread.MAX_PRIORITY
        instance = this
    }

}