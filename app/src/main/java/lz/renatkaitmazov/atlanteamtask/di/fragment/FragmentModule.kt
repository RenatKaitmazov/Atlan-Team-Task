package lz.renatkaitmazov.atlanteamtask.di.fragment

import dagger.Module
import dagger.Provides
import lz.renatkaitmazov.atlanteamtask.di.scope.FragmentScope
import lz.renatkaitmazov.atlanteamtask.view.main.cardlist.CardListPresenterImpl

/**
 * All dependencies whose lifecycle lasts as long as the
 * lifecycle of a fragment must be provided in this module.
 *
 * @author Renat Kaitmazov
 */

@Module
class FragmentModule {

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    @Provides
    @FragmentScope
    fun provideCardListPresenter() = CardListPresenterImpl()
}