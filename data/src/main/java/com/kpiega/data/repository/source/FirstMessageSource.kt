package com.kpiega.data.repository.source

import com.kpiega.data.datamodel.MessageModel
import com.kpiega.data.datamodel.MessagePriorityLevel
import io.reactivex.Single
import java.util.*

class FirstMessageSource : MessageDataSource {

    // sample data

    val list = listOf(
            MessageModel(0, "FIRST - Message no. 1", MessagePriorityLevel.LOW),
            MessageModel(1, "FIRST - Message no. 2", MessagePriorityLevel.MEDIUM),
            MessageModel(2, "FIRST - Message no. 3", MessagePriorityLevel.HIGH)
    )

    //

    override fun messageList(): Single<List<MessageModel>> = Single.just(list)

    override fun randomMessage(): Single<MessageModel> {
        val rand = Math.abs(Random().nextInt() % list.size)
        return Single.just(list[rand])
    }

}