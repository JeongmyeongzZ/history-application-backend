package com.example.demo.history.application.service

import com.example.demo.history.domain.entity.History

interface UpdateHistoryUseCase {
    fun update(id: String, history: History): History
}
