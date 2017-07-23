package com.kpiega.domain.usecase

import com.kpiega.domain.base.SingleUseCase
import com.kpiega.domain.model.Message
import com.kpiega.domain.repository.MessageRepository
import io.reactivex.Single

/**
 * Created by kpiega on 22.07.2017.
 */

class GetMessageRandom constructor(
        val messageRepository: MessageRepository
): SingleUseCase<Unit, Message>() {

    override fun execute(input: Unit?): Single<Message> = messageRepository.getRandomMessage()

}