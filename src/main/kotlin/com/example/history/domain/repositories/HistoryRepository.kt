package com.example.history.domain.repositories

import com.example.history.domain.entities.History
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HistoryRepository : CrudRepository<History, String> {
}
