package com.example.demo.history.application.service

import com.example.demo.history.domain.entity.History

interface RemoveHistoryUseCase {
    fun remove(history: History)
}
