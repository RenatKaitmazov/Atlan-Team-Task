package lz.renatkaitmazov.atlanteamtask.di.fragment

import dagger.Module
import dagger.Provides
import lz.renatkaitmazov.atlanteamtask.data.DynamicUrlProvider
import lz.renatkaitmazov.atlanteamtask.data.RestRepository
import lz.renatkaitmazov.atlanteamtask.data.RestRepositoryImpl
import lz.renatkaitmazov.atlanteamtask.di.scope.FragmentScope
import lz.renatkaitmazov.atlanteamtask.view.main.cardlist.CardListPresenterImpl
import lz.renatkaitmazov.atlanteamtask.view.model.ViewModelMapper
import retrofit2.Retrofit

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
    fun provideCardListPresenter(repository: RestRepository,
                                 mapper: ViewModelMapper) = CardListPresenterImpl(repository, mapper)

    @Provides
    @FragmentScope
    fun provideViewModelMapper() = ViewModelMapper()

    @Provides
    @FragmentScope
    fun provideRestRepository(retrofit: Retrofit, urlProvider: DynamicUrlProvider): RestRepository
            = RestRepositoryImpl(retrofit, urlProvider)

    @Provides
    @FragmentScope
    fun provideDynamicUrlProvider() = DynamicUrlProvider()
}