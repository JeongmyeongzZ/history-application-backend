package com.example.history.application.services

import com.example.history.domain.repositories.HistoryRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@Service
@Transactional
class DeleteHistoryService(repository: HistoryRepository) {
    private val repository: HistoryRepository

    fun run(date: LocalDate?) {
        repository.deleteByDate(date)
    }

    init {
        this.repository = repository
    }
}
