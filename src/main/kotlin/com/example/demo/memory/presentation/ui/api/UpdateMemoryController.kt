package com.example.demo.memory.presentation.ui.api

import com.example.demo.memory.application.input.UpdateMemoryInput
import com.example.demo.memory.application.service.FindMemoryUseCase
import com.example.demo.memory.application.service.SaveMemoryUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/memories")
class UpdateMemoryController(
    private val saveMemoryUseCase: SaveMemoryUseCase,
    private val findMemoryUseCase: FindMemoryUseCase
) {

    @PutMapping("/{id}")
    fun update(
        @PathVariable("id") id: String,
        @RequestBody request: UpdateMemoryInput
    ): ResponseEntity<Any> {
        val memory = findMemoryUseCase.findById(id)

        memory.description = request.description
        memory.date = request.date

        saveMemoryUseCase.save(memory)

        return ResponseEntity.noContent().build()
    }

}
