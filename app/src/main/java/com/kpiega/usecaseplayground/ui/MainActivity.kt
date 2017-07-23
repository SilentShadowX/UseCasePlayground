package com.kpiega.usecaseplayground.ui

import android.os.Bundle
import com.kpiega.data.mapper.MessageMapper
import com.kpiega.data.repository.MessageRepositoryImpl
import com.kpiega.data.repository.source.MessageSourceFactory
import com.kpiega.domain.model.Message
import com.kpiega.domain.usecase.GetMessageList
import com.kpiega.domain.usecase.GetMessageRandom
import com.kpiega.usecaseplayground.MainPresenter
import com.kpiega.usecaseplayground.MainPresenterImpl
import com.kpiega.usecaseplayground.MainView
import com.kpiega.usecaseplayground.R
import com.kpiega.usecaseplayground.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    val presenter: MainPresenter = MainPresenterImpl(
            GetMessageRandom(MessageRepositoryImpl(MessageSourceFactory(), MessageMapper())),
            GetMessageList(MessageRepositoryImpl(MessageSourceFactory(), MessageMapper()))
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)

        loadRandom.setOnClickListener {
            view -> presenter.loadMessageRandom()
        }

        loadList.setOnClickListener {
            view -> presenter.loadMessages()
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    override fun showMessages(list: List<Message>) {
        list.forEach { showMessage(it.toString()) }
    }

    override fun showRandomMessage(msg: Message) {
        showMessage(msg.message)
    }

}
