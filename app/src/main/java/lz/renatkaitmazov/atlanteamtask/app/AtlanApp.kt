package lz.renatkaitmazov.atlanteamtask.app

import android.app.Application
import lz.renatkaitmazov.atlanteamtask.di.AppComponent
import lz.renatkaitmazov.atlanteamtask.di.AppModule
import lz.renatkaitmazov.atlanteamtask.di.DaggerAppComponent
import lz.renatkaitmazov.atlanteamtask.di.NetModule

/**
 *
 * @author Renat Kaitmazov
 */

class AtlanApp : Application() {

    /*------------------------------------------------------------------------*/
    // Static
    /*------------------------------------------------------------------------*/

    companion object {
        @JvmStatic lateinit var instance: AtlanApp
            private set
    }

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    val appComponent: AppComponent by lazy(LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule())
                .build()
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