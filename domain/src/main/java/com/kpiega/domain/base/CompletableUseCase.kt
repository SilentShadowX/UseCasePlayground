package com.kpiega.domain.base

import io.reactivex.Completable

/**
 * Created by kpiega on 23.07.2017.
 */

abstract class CompletableUseCase<in I: BaseInput> {

    abstract fun execute(input: I? = null): Completable
}