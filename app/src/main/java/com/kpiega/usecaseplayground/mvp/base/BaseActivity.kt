package com.kpiega.usecaseplayground.mvp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by kpiega on 22.07.2017.
 */

abstract class BaseActivity: AppCompatActivity(), BaseMvp.BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

}