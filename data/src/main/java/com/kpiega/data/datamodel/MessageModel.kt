package com.kpiega.data.datamodel

/**
 * Created by kpiega on 23.07.2017.
 */

data class MessageModel(var id: Long = 0, var message: String = "", val priorityLevel: MessagePriorityLevel = MessagePriorityLevel.LOW)


