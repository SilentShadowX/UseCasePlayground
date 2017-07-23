package com.kpiega.domain.model

/**
 * Created by kpiega on 22.07.2017.
 */

data class Message(var id: Long = 0, var message: String = "", var priority: MessagePriority = MessagePriority.LOW)