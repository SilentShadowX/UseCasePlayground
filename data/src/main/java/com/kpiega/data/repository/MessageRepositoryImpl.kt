package com.kpiega.data.repository

import com.kpiega.domain.model.Message
import com.kpiega.domain.repository.MessageRepository
import io.reactivex.Observable

/**
 * Created by kpiega on 22.07.2017.
 */

class MessageRepositoryImpl : MessageRepository {

    override fun getMessages(): Observable<List<Message>> = Observable.just(listOf(
            Message("msg 1"),
            Message("msg 2"),
            Message("msg 3")
    ))

    override fun getRandomMessage(): Observable<Message> = Observable.just(
            Message("msg random x")
    )

}