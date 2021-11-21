package com.example.history.application.services

import com.example.history.domain.entities.History

interface CreateHistoryUseCase {
    fun save(history: History): History
}
