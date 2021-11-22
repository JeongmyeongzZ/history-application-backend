package com.example.history.application.service

import com.example.history.domain.entity.History

interface SaveHistoryUseCase {
    fun save(history: History): History
}
