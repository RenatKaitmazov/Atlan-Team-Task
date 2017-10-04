package lz.renatkaitmazov.atlanteamtask.di

import dagger.Component

/**
 *
 * @author Renat Kaitmazov
 */

@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {
    // Specify injection targets here.
}