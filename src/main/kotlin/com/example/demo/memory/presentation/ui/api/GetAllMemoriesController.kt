package com.example.demo.memory.presentation.ui.api

import com.example.demo.memory.application.service.FindMemoryUseCase
import com.example.demo.memory.domain.entity.Memory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/memories")
class GetAllMemoriesController(private val service: FindMemoryUseCase) {

    @GetMapping
    fun getMemories(): ResponseEntity<Iterable<Memory>> {
        return ResponseEntity.ok(service.findAll())
    }
}
