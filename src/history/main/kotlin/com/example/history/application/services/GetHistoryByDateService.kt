package com.example.history.application.services

import com.example.history.domain.entities.History
import com.example.history.domain.repositories.HistoryRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class GetHistoryByDateService(repository: HistoryRepository) {
    private val repository: HistoryRepository

    fun run(date: LocalDate): Optional<History> {
        return repository.findByDate(date)
    }

    init {
        this.repository = repository
    }
}
