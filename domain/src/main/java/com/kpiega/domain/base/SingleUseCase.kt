package com.kpiega.domain.base

import io.reactivex.Single

/**
 * Created by kpiega on 23.07.2017.
 */

abstract class SingleUseCase<I, O> {

    abstract fun execute(input: I? = null): Single<O>
}

