package com.example.history.application.service

import com.example.history.domain.entity.History

interface FindHistoryUseCase {
    fun findById(id: String): History

    fun findAll(): Iterable<History>
}
