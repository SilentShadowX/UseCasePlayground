package com.kpiega.data.repository.source

import com.kpiega.data.datamodel.MessageModel
import com.kpiega.data.datamodel.MessagePriorityLevel
import io.reactivex.Single
import java.util.*

/**
 * Created by kpiega on 23.07.2017.
 */
class SecondMessageSource : MessageDataSource {

    // sample data

    val list = listOf(
            MessageModel(0, "SECOND - Message no. 1", MessagePriorityLevel.MEDIUM),
            MessageModel(1, "SECOND - Message no. 2", MessagePriorityLevel.LOW),
            MessageModel(2, "SECOND - Message no. 3", MessagePriorityLevel.HIGH)
    )

    //

    override fun messageList(): Single<List<MessageModel>> = Single.just(list)

    override fun randomMessage(): Single<MessageModel> {
        val rand = Math.abs(Random().nextInt() % 3)
        return Single.just(list[rand])
    }

}