package lz.renatkaitmazov.atlanteamtask.di.fragment

import dagger.Subcomponent
import lz.renatkaitmazov.atlanteamtask.di.scope.FragmentScope
import lz.renatkaitmazov.atlanteamtask.main.contactlist.ContactListFragment

/**
 *
 * @author Renat Kaitmazov
 */

@FragmentScope
@Subcomponent(modules = arrayOf(ContactListFragmentModule::class))
interface ContactListFragmentSubcomponent {
    // Specify injection targets here.
    fun inject(target: ContactListFragment)
}