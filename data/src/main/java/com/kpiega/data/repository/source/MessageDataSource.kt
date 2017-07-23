package com.kpiega.data.repository.source

import com.kpiega.data.datamodel.MessageModel
import io.reactivex.Single

/**
 * Created by kpiega on 23.07.2017.
 */

interface MessageDataSource {

    fun messageList(): Single<List<MessageModel>>

    fun randomMessage(): Single<MessageModel>
}