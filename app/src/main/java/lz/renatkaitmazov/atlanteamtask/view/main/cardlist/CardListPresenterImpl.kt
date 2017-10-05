package lz.renatkaitmazov.atlanteamtask.view.main.cardlist

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import lz.renatkaitmazov.atlanteamtask.base.AbsPresenter
import lz.renatkaitmazov.atlanteamtask.data.RestRepository
import lz.renatkaitmazov.atlanteamtask.view.model.ViewModelMapper
import java.util.concurrent.TimeUnit

/**
 *
 * @author Renat Kaitmazov
 */

class CardListPresenterImpl(private val restRepository: RestRepository,
                            private val mapper: ViewModelMapper)
    : AbsPresenter<CardListView>(), CardListPresenter<CardListView> {

    /*------------------------------------------------------------------------*/
    // Static
    /*------------------------------------------------------------------------*/

    companion object {
        private const val TIMEOUT = 10L
    }

    /*------------------------------------------------------------------------*/
    // Properties
    /*------------------------------------------------------------------------*/

    private val compositeDisposable = CompositeDisposable()

    /*------------------------------------------------------------------------*/
    // Overridden methods
    /*------------------------------------------------------------------------*/

    override fun unbind() {
        compositeDisposable.dispose()
        super.unbind()
    }

    /*------------------------------------------------------------------------*/
    // CardListPresenter implementation
    /*------------------------------------------------------------------------*/

    override fun getCommonData() {
        val disposable = restRepository.getCommonData()
                .doOnSubscribe { view?.showProgress() }
                .map(mapper::map)
                .timeout(TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        success@ { commonDataList ->
                            if (view != null) {
                                view!!.hideProgress()
                                view!!.showCommonData(commonDataList)
                            }
                        },
                        error@ { view?.hideProgress() }
                )
        compositeDisposable.add(disposable)
    }
}