package com.kpiega.domain

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

abstract class BaseUseCase constructor(val workExecutor: Scheduler, val mainExecutor: Scheduler) {

    private val disposable = CompositeDisposable()

    protected abstract fun buildUseCase(): Observable<*>

    fun execute(observer: DisposableObserver<Any>) {
        this.disposable.add(
                buildUseCase()
                        .subscribeOn(workExecutor)
                        .observeOn(mainExecutor)
                        .subscribeWith(observer)
        )
    }

    fun clear() {
        this.disposable.clear()
    }

    fun dispose() {
        if(!disposable.isDisposed) this.disposable.dispose()
    }

}
