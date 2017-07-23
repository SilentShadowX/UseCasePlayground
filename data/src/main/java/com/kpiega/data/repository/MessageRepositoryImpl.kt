package com.kpiega.data.repository

import com.kpiega.data.mapper.MessageMapper
import com.kpiega.data.repository.source.MessageSourceFactory
import com.kpiega.domain.model.Message
import com.kpiega.domain.repository.MessageRepository
import io.reactivex.Single

/**
 * Created by kpiega on 23.07.2017.
 */

class MessageRepositoryImpl constructor(
        val dataSource: MessageSourceFactory, val dataMapper: MessageMapper
) : MessageRepository {
    override fun getMessagesList(): Single<List<Message>> {
        val source = dataSource.createFirstSource()
        return source.messageList().flatMap { item -> Single.just(dataMapper.transform(item)) }
    }

    override fun getRandomMessage(): Single<Message> {
        val source = dataSource.createSecondSource()
        return source.randomMessage().flatMap { item -> Single.just(dataMapper.transform(item)) }
    }

}