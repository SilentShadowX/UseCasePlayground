package com.kpiega.usecaseplayground.mvp

import com.kpiega.domain.model.Message
import com.kpiega.usecaseplayground.mvp.base.BaseMvp

/**
 * Created by kpiega on 22.07.2017.
 */

interface MainView: BaseMvp.BaseView {
    fun showMessages(list: List<Message>)
    fun showRandomMessage(msg: Message)
}