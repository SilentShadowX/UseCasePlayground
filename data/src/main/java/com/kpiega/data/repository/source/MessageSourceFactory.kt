package com.kpiega.data.repository.source

/**
 * Created by kpiega on 23.07.2017.
 */

class MessageSourceFactory {

    fun createFirstSource(): MessageDataSource = FirstMessageSource()
    fun createSecondSource(): MessageDataSource = SecondMessageSource()

}