package com.kpiega.data.mapper

import com.kpiega.data.datamodel.MessageModel
import com.kpiega.data.datamodel.MessagePriorityLevel
import com.kpiega.domain.model.Message
import com.kpiega.domain.model.MessagePriority

/**
 * Created by kpiega on 23.07.2017.
 */

class MessageMapper {

    fun transform(modelObject: MessageModel): Message {

        val msg = Message()

        msg.message = modelObject.message

        msg.priority.apply {
            when (modelObject.priorityLevel) {
                MessagePriorityLevel.LOW -> MessagePriority.LOW
                MessagePriorityLevel.MEDIUM -> MessagePriority.MEDIUM
                MessagePriorityLevel.HIGH -> MessagePriority.HIGH
            }
        }

        return msg
    }

    fun transform(list: Collection<MessageModel>): List<Message> {
        return list.map { item -> transform(item) }.toList()
    }

}