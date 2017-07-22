package com.kpiega.usecaseplayground

import com.kpiega.domain.model.Message
import com.kpiega.usecaseplayground.base.BaseMvp

/**
 * Created by kpiega on 22.07.2017.
 */

interface MainView: BaseMvp.BaseView {
    fun showMessages(list: List<Message>)
    fun showRandomMessage(msg: Message)
}