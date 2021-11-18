package com.example.history.application.services

import com.example.history.domain.entities.History
import com.example.history.domain.repositories.HistoryRepository
import org.springframework.stereotype.Service

@Service
class GetAllHistoriesService(repository: HistoryRepository) {
    private val repository: HistoryRepository

    fun run(): Iterable<History> {
        return repository.findAll()
    }

    init {
        this.repository = repository
    }
}
