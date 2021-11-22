package com.example.history.application.service

import com.example.history.domain.entity.History

interface RemoveHistoryUseCase {
    fun remove(history: History)
}
