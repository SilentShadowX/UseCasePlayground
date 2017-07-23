package com.kpiega.usecaseplayground.vm

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.Toast
import com.kpiega.domain.model.Message
import com.kpiega.usecaseplayground.R
import io.reactivex.observers.DisposableSingleObserver
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by kpiega on 23.07.2017.
 */

class MainActivity : BaseActivity() {

    val viewModel by lazy {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscribe()
    }

    private fun subscribe() {

        loadRandom.setOnClickListener {
            _ ->
            viewModel.onRandomButtonClicked(object : DisposableSingleObserver<Message>() {
                override fun onSuccess(value: Message?) {
                    Toast.makeText(this@MainActivity, value?.message, Toast.LENGTH_LONG).show()
                }

                override fun onError(e: Throwable?) {
                    Toast.makeText(this@MainActivity, e?.message, Toast.LENGTH_LONG).show()
                }

            })
        }

        loadList.setOnClickListener {
            _ ->
            viewModel.onLoadListButtonClicked(object : DisposableSingleObserver<List<Message>>() {
                override fun onSuccess(value: List<Message>?) {
                    value?.forEach {
                        item -> Toast.makeText(this@MainActivity, item.message, Toast.LENGTH_LONG).show()
                    }
                }

                override fun onError(e: Throwable?) {
                    Toast.makeText(this@MainActivity, e?.message, Toast.LENGTH_LONG).show()
                }

            })
        }
    }
}