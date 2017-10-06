package lz.renatkaitmazov.atlanteamtask.di.fragment

import dagger.Module
import dagger.Provides
import lz.renatkaitmazov.atlanteamtask.data.DataCache
import lz.renatkaitmazov.atlanteamtask.data.remote.DynamicUrlProvider
import lz.renatkaitmazov.atlanteamtask.data.remote.RestRepository
import lz.renatkaitmazov.atlanteamtask.data.remote.RestRepositoryImpl
import lz.renatkaitmazov.atlanteamtask.di.scope.FragmentScope
import lz.renatkaitmazov.atlanteamtask.main.cardlist.CardListPresenterImpl
import lz.renatkaitmazov.atlanteamtask.main.cardlist.model.CardMapper
import retrofit2.Retrofit

/**
 *
 * @author Renat Kaitmazov
 */

@Module
class CardListFragmentModule {

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    @Provides
    @FragmentScope
    fun provideCardListPresenter(repository: RestRepository,
                                 mapper: CardMapper) = CardListPresenterImpl(repository, mapper)

    @Provides
    @FragmentScope
    fun provideCardMapper() = CardMapper()

    @Provides
    @FragmentScope
    fun provideRestRepository(retrofit: Retrofit,
                              urlProvider: DynamicUrlProvider,
                              dataCache: DataCache): RestRepository
            = RestRepositoryImpl(retrofit, urlProvider, dataCache)

    @Provides
    @FragmentScope
    fun provideDynamicUrlProvider() = DynamicUrlProvider()
}