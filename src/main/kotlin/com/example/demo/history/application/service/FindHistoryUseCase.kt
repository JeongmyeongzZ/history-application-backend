package com.example.demo.history.application.service

import com.example.demo.history.domain.entity.History

interface FindHistoryUseCase {
    fun findById(id: String): History

    fun findAll(): Iterable<History>
}
