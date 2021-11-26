package com.example.demo.memory.application.service

import com.example.demo.memory.domain.entity.Memory

interface FindMemoryUseCase {
    fun findById(id: String): Memory

    fun findAll(): Iterable<Memory>
}
