package com.example.history.presentation.ui.api

import com.example.history.application.service.FindHistoryUseCase
import com.example.history.domain.entity.History
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/histories")
class GetHistoryController(private val service: FindHistoryUseCase) {

    @GetMapping("/{id}")
    fun getHistory(@PathVariable("id") id: String): ResponseEntity<History> {
        return ResponseEntity.ok(service.findById(id))
    }
}
