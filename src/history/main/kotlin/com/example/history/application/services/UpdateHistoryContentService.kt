package com.example.history.application.services

import com.example.history.application.inputs.UpdateHistoryInput
import com.example.history.domain.entities.History
import com.example.history.domain.repositories.HistoryRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class UpdateHistoryContentService(repository: HistoryRepository) {
    private val repository: HistoryRepository

    fun run(date: LocalDate, request: UpdateHistoryInput): History {
        val history: History = repository.findByDate(date).orElseThrow()
        history.updateContent(request.getContent())
        return repository.save(history)
    }

    init {
        this.repository = repository
    }
}
