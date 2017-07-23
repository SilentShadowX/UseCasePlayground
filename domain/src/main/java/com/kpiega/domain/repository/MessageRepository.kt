package com.kpiega.domain.repository

import com.kpiega.domain.model.Message
import io.reactivex.Single

interface MessageRepository {
    fun getMessagesList(): Single<List<Message>>
    fun getRandomMessage(): Single<Message>
}
