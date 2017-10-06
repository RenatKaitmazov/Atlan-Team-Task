package lz.renatkaitmazov.atlanteamtask.di.singleton

import dagger.Module
import dagger.Provides
import lz.renatkaitmazov.atlanteamtask.app.AtlanApp
import lz.renatkaitmazov.atlanteamtask.di.NAME_APP_CONTEXT
import javax.inject.Named
import javax.inject.Singleton

/**
 * All dependencies specific to the Android platform whose lifecycle lasts as long as the
 * lifecycle of the application must be provided in this module.
 *
 * @author Renat Kaitmazov
 */

@Module
class AppModule(private val atlanApp: AtlanApp) {

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    @Provides
    @Singleton
    @Named(NAME_APP_CONTEXT)
    fun provideAppContext() = atlanApp.applicationContext
}