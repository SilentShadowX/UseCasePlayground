package com.kpiega.usecaseplayground

import com.kpiega.usecaseplayground.base.BaseMvp

/**
 * Created by kpiega on 22.07.2017.
 */
interface MainPresenter: BaseMvp.BasePresenter<MainView> {
    fun loadMessages()
    fun loadMessageRandom()
}