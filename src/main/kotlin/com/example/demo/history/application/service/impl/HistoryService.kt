package com.example.demo.history.application.service.impl

import com.example.demo.history.application.exception.HistoryNotFoundException
import com.example.demo.history.application.service.FindHistoryUseCase
import com.example.demo.history.application.service.RemoveHistoryUseCase
import com.example.demo.history.application.service.SaveHistoryUseCase
import com.example.demo.history.domain.entity.History
import com.example.demo.history.domain.repository.HistoryRepository
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
