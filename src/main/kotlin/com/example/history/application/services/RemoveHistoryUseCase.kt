package com.example.history.application.services

import com.example.history.domain.entities.History

interface RemoveHistoryUseCase {
    fun remove(history: History)
}
