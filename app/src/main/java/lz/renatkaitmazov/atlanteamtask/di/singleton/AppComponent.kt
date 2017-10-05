package lz.renatkaitmazov.atlanteamtask.di.singleton

import dagger.Component
import lz.renatkaitmazov.atlanteamtask.di.fragment.FragmentModule
import lz.renatkaitmazov.atlanteamtask.di.fragment.FragmentSubcomponent

/**
 *
 * @author Renat Kaitmazov
 */

@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {
    // Specify injection targets here.

    // Factory methods for subcomponents
    fun plus(module: FragmentModule): FragmentSubcomponent
}