package com.example.history.application.services

import com.example.history.domain.entities.History

interface UpdateHistoryUseCase {
    fun update(id: String, history: History): History
}
