package com.example.demo.history.application.service

import com.example.demo.history.domain.entity.History

interface SaveHistoryUseCase {
    fun save(history: History): History
}
