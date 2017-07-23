package com.kpiega.usecaseplayground

import com.kpiega.data.datamodel.MessageModel
import com.kpiega.domain.model.Message
import com.kpiega.domain.usecase.GetMessageList
import com.kpiega.domain.usecase.GetMessageRandom
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by kpiega on 22.07.2017.
 */

class MainPresenterImpl(
        val useCaseRandom: GetMessageRandom, val useCaseList: GetMessageList
) : MainPresenter {

    override var view: MainView? = null

    val disposable = CompositeDisposable()

    override fun attachView(view: MainView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
        disposable.clear()
    }

    override fun loadMessages() {
        disposable.add(
                useCaseList.execute()
                        .subscribeWith(object : DisposableSingleObserver<List<Message>>() {

                            override fun onSuccess(value: List<Message>?) {
                                value?.let {
                                    view?.showMessages(it)
                                }
                            }

                            override fun onError(e: Throwable?) {
                                view?.showMessage(e?.message!!)
                            }

                        })
        )

    }

    override fun loadMessageRandom() {

        disposable.add(
                useCaseRandom.execute()
                        .subscribeWith(object : DisposableSingleObserver<Message>() {

                            override fun onSuccess(value: Message?) {
                                value?.let {
                                    view?.showRandomMessage(it)
                                }
                            }

                            override fun onError(e: Throwable?) {
                                view?.showMessage(e?.message!!)
                            }

                        })
        )


    }

}