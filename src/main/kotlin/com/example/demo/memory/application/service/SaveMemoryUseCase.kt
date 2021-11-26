package com.example.demo.memory.application.service

import com.example.demo.memory.domain.entity.Memory

interface SaveMemoryUseCase {
    fun save(memory: Memory): Memory
}
