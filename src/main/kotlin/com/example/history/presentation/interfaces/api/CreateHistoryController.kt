package com.example.history.presentation.interfaces.api

import com.example.history.application.inputs.CreateHistoryInput
import com.example.history.application.services.SaveHistoryUseCase
import com.example.history.domain.entities.History
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/api/histories")
class CreateHistoryController(private val service: SaveHistoryUseCase) {

    @PostMapping
    fun save(@Validated @RequestBody request: CreateHistoryInput): ResponseEntity<History> {
        val history: History = service.save(request.toEntity())

        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(history.id)
            .toUri()

        return ResponseEntity.created(location).body(history)
    }
}
