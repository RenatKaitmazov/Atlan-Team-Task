package lz.renatkaitmazov.atlanteamtask.di.fragment

import dagger.Subcomponent
import lz.renatkaitmazov.atlanteamtask.di.scope.FragmentScope
import lz.renatkaitmazov.atlanteamtask.main.cardlist.CardListFragment

/**
 *
 * @author Renat Kaitmazov
 */

@FragmentScope
@Subcomponent(modules = arrayOf(CardListFragmentModule::class))
interface CardListFragmentSubcomponent {
    // Specify injection targets here.
    fun inject(target: CardListFragment)
}