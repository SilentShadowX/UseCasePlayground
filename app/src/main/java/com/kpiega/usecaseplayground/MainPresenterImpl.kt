package com.kpiega.usecaseplayground

import com.kpiega.domain.usecase.GetMessageFromSource

/**
 * Created by kpiega on 22.07.2017.
 */

class MainPresenterImpl(val useCase: GetMessageFromSource) : MainPresenter {

    override var view: MainView? = null

    override fun attachView(view: MainView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
        useCase.dispose()
    }

    override fun loadMessages() {
        view?.showMessages(useCase.messageRepository.getMessages().blockingFirst())
    }

    override fun loadMessageRandom() {
        view?.showRandomMessage(useCase.messageRepository.getRandomMessage().blockingFirst())
    }

}