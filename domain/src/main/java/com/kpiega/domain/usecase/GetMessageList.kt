package com.kpiega.domain.usecase

import com.kpiega.domain.base.SingleUseCase
import com.kpiega.domain.model.Message
import com.kpiega.domain.repository.MessageRepository
import io.reactivex.Single

/**
 * Created by kpiega on 23.07.2017.
 */

class GetMessageList constructor(
        val messageRepository: MessageRepository
): SingleUseCase<Unit, List<Message>>() {

    override fun execute(input: Unit?): Single<List<Message>> = messageRepository.getMessagesList()

}