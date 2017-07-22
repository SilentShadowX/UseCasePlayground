package com.kpiega.usecaseplayground.base

/**
 * Created by kpiega on 22.07.2017.
 */

interface BaseMvp {

    interface BaseView {
        fun <T: String> showMessage(msg: T)
    }

    interface BasePresenter<V: BaseView> {
        var view: V?
        fun attachView(view: V)
        fun detachView()
    }
}