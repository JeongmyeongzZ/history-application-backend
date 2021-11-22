package com.example.history.application.service

import com.example.history.domain.entity.History

interface UpdateHistoryUseCase {
    fun update(id: String, history: History): History
}
