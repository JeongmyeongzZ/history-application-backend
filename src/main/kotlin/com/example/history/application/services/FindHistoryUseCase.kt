package com.example.history.application.services

import com.example.history.domain.entities.History

interface FindHistoryUseCase {
    fun findById(id: String): History

    fun findAll(): Iterable<History>
}
