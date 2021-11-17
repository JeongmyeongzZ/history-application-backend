package com.example.history.domain.repositories

import com.example.history.domain.entities.History
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface HistoryRepository : CrudRepository<History, String> {
    fun findByDate(date: LocalDate): Optional<History>
    fun deleteByDate(date: LocalDate)
}
