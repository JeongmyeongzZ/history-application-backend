package com.example.history.presentation.interfaces.api

import com.example.history.application.services.FindHistoryUseCase
import com.example.history.application.services.RemoveHistoryUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/histories")
class DeleteHistoryController(private val findHistoryService: FindHistoryUseCase, private val removeHistoryService: RemoveHistoryUseCase) {

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String): ResponseEntity<Any> {
        removeHistoryService.remove(findHistoryService.findById(id))

        return ResponseEntity.noContent().build()
    }
}
