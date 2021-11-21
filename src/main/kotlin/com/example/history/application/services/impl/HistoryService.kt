package com.example.history.application.services.impl

import com.example.history.application.exception.HistoryNotFoundException
import com.example.history.application.services.FindHistoryUseCase
import com.example.history.application.services.RemoveHistoryUseCase
import com.example.history.application.services.SaveHistoryUseCase
import com.example.history.domain.entities.History
import com.example.history.domain.repositories.HistoryRepository
import org.springframework.stereotype.Service

@Service
class HistoryService(private val repository: HistoryRepository) :
    FindHistoryUseCase, RemoveHistoryUseCase, SaveHistoryUseCase {
    override fun findById(id: String): History {
        return repository.findById(id).orElseThrow { HistoryNotFoundException("History not found") }
    }

    override fun findAll(): Iterable<History> {
        return repository.findAll()
    }

    override fun remove(history: History) {
        repository.delete(history)
    }

    override fun save(history: History): History {
        return repository.save(history)
    }
}
