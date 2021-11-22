package com.example.history.domain.repository

import com.example.history.domain.entity.History
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HistoryRepository : CrudRepository<History, String> {
}
