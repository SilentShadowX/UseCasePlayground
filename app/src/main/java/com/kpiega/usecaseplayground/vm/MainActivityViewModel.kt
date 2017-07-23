package com.kpiega.usecaseplayground.vm

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.kpiega.data.mapper.MessageMapper
import com.kpiega.data.repository.MessageRepositoryImpl
import com.kpiega.data.repository.source.MessageSourceFactory
import com.kpiega.domain.model.Message
import com.kpiega.domain.usecase.GetMessageList
import com.kpiega.domain.usecase.GetMessageRandom
import com.kpiega.usecaseplayground.MyApp
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

/**
 * Created by kpiega on 23.07.2017.
 */

class MainActivityViewModel(app: Application) : AndroidViewModel(app) {

    val disposable = CompositeDisposable()

    val mapper = MessageMapper()
    val factory = MessageSourceFactory()
    val repo = MessageRepositoryImpl(factory, mapper)

    val randomUseCase = GetMessageRandom(repo)
    val listUseCase = GetMessageList(repo)

    fun onRandomButtonClicked(observer: DisposableSingleObserver<Message>) {
        disposable.add(randomUseCase.execute().subscribeWith(observer))
    }

    fun onLoadListButtonClicked(observer: DisposableSingleObserver<List<Message>>) {
        disposable.add(listUseCase.execute().subscribeWith(observer))
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}

