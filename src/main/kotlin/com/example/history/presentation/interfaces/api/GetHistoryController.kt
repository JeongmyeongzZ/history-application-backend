package com.example.history.presentation.interfaces.api

import com.example.history.application.services.FindHistoryUseCase
import com.example.history.domain.entities.History
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GetHistoryController(private val service: FindHistoryUseCase) {

    @GetMapping("/histories/{id}")
    fun getHistory(@PathVariable("id") id: String): ResponseEntity<History> {
        return ResponseEntity.ok(service.findById(id))
    }
}
