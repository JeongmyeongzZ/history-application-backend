package com.example.demo.memory.application.service.impl

import com.example.demo.memory.application.service.SaveMemoryUseCase
import com.example.demo.memory.domain.entity.Memory
import com.example.demo.memory.application.exception.MemoryNotFoundException
import com.example.demo.memory.application.service.FindMemoryUseCase
import com.example.demo.memory.domain.repository.MemoryRepository
import org.springframework.stereotype.Service

@Service
class MemoryService(private val repository: MemoryRepository) : FindMemoryUseCase, SaveMemoryUseCase {
    override fun findById(id: String): Memory {
        return repository.findById(id).orElseThrow { MemoryNotFoundException("Memory not found") }
    }

    override fun findAll(): Iterable<Memory> {
        return repository.findAll()
    }

    override fun save(memory: Memory): Memory {
        return repository.save(memory)
    }
}
