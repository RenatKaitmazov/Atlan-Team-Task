package lz.renatkaitmazov.atlanteamtask.main.cardlist

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import lz.renatkaitmazov.atlanteamtask.base.AbsPresenter
import lz.renatkaitmazov.atlanteamtask.data.remote.RestRepository
import lz.renatkaitmazov.atlanteamtask.main.cardlist.model.CardMapper
import java.util.concurrent.TimeUnit

/**
 *
 * @author Renat Kaitmazov
 */

class CardListPresenterImpl(private val restRepository: RestRepository,
                            private val mapper: CardMapper)
    : AbsPresenter<CardListView>(), CardListPresenter {

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
        view?.showProgress()
        val disposable = restRepository.getCommonData()
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
                        error@ {
                            view?.hideProgress()
                            println(it)
                        }
                )
        compositeDisposable.add(disposable)
    }
}