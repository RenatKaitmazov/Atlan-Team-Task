package lz.renatkaitmazov.atlanteamtask.di.singleton

import dagger.Component
import lz.renatkaitmazov.atlanteamtask.di.fragment.CardListFragmentModule
import lz.renatkaitmazov.atlanteamtask.di.fragment.CardListFragmentSubcomponent
import lz.renatkaitmazov.atlanteamtask.di.fragment.ContactListFragmentModule
import lz.renatkaitmazov.atlanteamtask.di.fragment.ContactListFragmentSubcomponent
import javax.inject.Singleton

/**
 *
 * @author Renat Kaitmazov
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {
    // Specify injection targets here.

    // Factory methods for subcomponents
    fun plus(moduleCardList: CardListFragmentModule): CardListFragmentSubcomponent
    fun plus(moduleContactList: ContactListFragmentModule): ContactListFragmentSubcomponent
}