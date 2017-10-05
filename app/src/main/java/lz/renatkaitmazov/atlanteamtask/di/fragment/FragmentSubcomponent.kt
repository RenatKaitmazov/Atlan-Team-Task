package lz.renatkaitmazov.atlanteamtask.di.fragment

import dagger.Subcomponent
import lz.renatkaitmazov.atlanteamtask.di.scope.FragmentScope
import lz.renatkaitmazov.atlanteamtask.view.main.cardlist.CardListFragment

/**
 *
 * @author Renat Kaitmazov
 */

@FragmentScope
@Subcomponent(modules = arrayOf(FragmentModule::class))
interface FragmentSubcomponent {
    // Specify injection targets here.
    fun inject(target: CardListFragment)
}