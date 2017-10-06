package lz.renatkaitmazov.atlanteamtask.di.fragment

import android.content.Context
import dagger.Module
import dagger.Provides
import lz.renatkaitmazov.atlanteamtask.data.DataCache
import lz.renatkaitmazov.atlanteamtask.data.local.LocalRepository
import lz.renatkaitmazov.atlanteamtask.data.local.LocalRepositoryImpl
import lz.renatkaitmazov.atlanteamtask.di.NAME_APP_CONTEXT
import lz.renatkaitmazov.atlanteamtask.di.scope.FragmentScope
import lz.renatkaitmazov.atlanteamtask.main.contactlist.ContactListPresenterImpl
import lz.renatkaitmazov.atlanteamtask.main.contactlist.model.ContactMapper
import javax.inject.Named

/**
 *
 * @author Renat Kaitmazov
 */

@Module
class ContactListFragmentModule {

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    @Provides
    @FragmentScope
    fun provideContactListPresenter(repository: LocalRepository,
                                    mapper: ContactMapper)
            = ContactListPresenterImpl(repository, mapper)

    @Provides
    @FragmentScope
    fun provideContactMapper() = ContactMapper()

    @Provides
    @FragmentScope
    fun provideLocalRepository(cache: DataCache,
                               @Named(NAME_APP_CONTEXT) context: Context): LocalRepository
            = LocalRepositoryImpl(cache, context)
}