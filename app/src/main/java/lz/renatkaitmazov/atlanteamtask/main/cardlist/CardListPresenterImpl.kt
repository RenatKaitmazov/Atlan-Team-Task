package lz.renatkaitmazov.atlanteamtask.main.cardlist

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import lz.renatkaitmazov.atlanteamtask.base.AbsPresenter
import lz.renatkaitmazov.atlanteamtask.data.remote.RestRepository
import lz.renatkaitmazov.atlanteamtask.main.cardlist.model.CardMapper
import lz.renatkaitmazov.atlanteamtask.main.cardlist.model.DynamicJsonParser
import java.util.concurrent.TimeUnit

/**
 *
 * @author Renat Kaitmazov
 */

class CardListPresenterImpl(private val restRepository: RestRepository,
                            private val mapper: CardMapper,
                            private val parser: DynamicJsonParser)
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
        val source = restRepository.getCommonData().map(mapper::map)
        val disposable = createSubscription(source, view!!::showCommonData)
        compositeDisposable.add(disposable)
    }

    override fun validateJson(json: String) {
        view?.showProgress()
        val source = restRepository.validateJson(json).map(parser::parse)
        val disposable = createSubscription(source, view!!::showValidationResult)
        compositeDisposable.add(disposable)
    }

    override fun echoJson(json: String) {
        view?.showProgress()
        val source = restRepository.echoJson(json).map(parser::parse)
        val disposable = createSubscription(source, view!!::showEchoJsonResult)
        compositeDisposable.add(disposable)
    }

    private fun <T> createSubscription(source: Single<T>,
                                       onSuccessAction: (result: T) -> Unit): Disposable {
        return source
                .timeout(TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate { view?.hideProgress() }
                .subscribe(
                        success@ { result ->
                            if (view != null) {
                                onSuccessAction(result)
                            }
                        },
                        error@ {
                            println(it)
                        }
                )
    }
}