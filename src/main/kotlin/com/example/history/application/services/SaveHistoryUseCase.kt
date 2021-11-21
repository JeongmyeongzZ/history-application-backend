package com.example.history.application.services

import com.example.history.domain.entities.History

interface SaveHistoryUseCase {
    fun save(history: History): History
}
