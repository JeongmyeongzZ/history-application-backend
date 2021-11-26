package com.example.demo.memory.domain.repository

import com.example.demo.memory.domain.entity.Memory
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemoryRepository : CrudRepository<Memory, String> {
}
