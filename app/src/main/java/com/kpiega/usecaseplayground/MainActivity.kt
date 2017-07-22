package com.kpiega.usecaseplayground

import android.os.Bundle
import com.kpiega.data.repository.MessageRepositoryImpl
import com.kpiega.domain.model.Message
import com.kpiega.domain.usecase.GetMessageFromSource
import com.kpiega.usecaseplayground.base.BaseActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : BaseActivity(), MainView {

    val presenter
            = MainPresenterImpl(
            GetMessageFromSource(Schedulers.io(), AndroidSchedulers.mainThread(), MessageRepositoryImpl()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
        presenter.loadMessages()
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    override fun showMessages(list: List<Message>) {
        val messageToast = ""

        list.forEach{
            item -> showMessage(item.message)
        }

    }

    override fun showRandomMessage(msg: Message) {
        showMessage(msg.message)
    }


}
