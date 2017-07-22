package com.kpiega.domain.usecase

import com.kpiega.domain.BaseUseCase
import com.kpiega.domain.repository.MessageRepository
import io.reactivex.Scheduler

/**
 * Created by kpiega on 22.07.2017.
 */

class GetMessageFromSource(
        val worker: Scheduler, val main: Scheduler, val messageRepository: MessageRepository
): BaseUseCase(worker, main) {

    override fun buildUseCase() = messageRepository.getMessages()

}