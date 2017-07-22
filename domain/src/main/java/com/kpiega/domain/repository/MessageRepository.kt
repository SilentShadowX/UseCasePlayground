package com.kpiega.domain.repository

import com.kpiega.domain.model.Message
import io.reactivex.Observable

interface MessageRepository {
    fun getMessages(): Observable<List<Message>>
    fun getRandomMessage(): Observable<Message>
}
