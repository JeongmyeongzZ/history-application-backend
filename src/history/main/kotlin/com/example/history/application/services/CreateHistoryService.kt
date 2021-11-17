package com.example.history.application.services

import com.example.history.application.inputs.CreateHistoryInput
import com.example.history.domain.entities.History
import com.example.history.domain.repositories.HistoryRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreateHistoryService(repository: HistoryRepository) {
    private val repository: HistoryRepository
    fun run(request: CreateHistoryInput): History {
        return repository.save(
            History(
                UUID.randomUUID().toString(), request.getContent(), request.getDate()
            )
        )
    }

    init {
        this.repository = repository
    }
}
