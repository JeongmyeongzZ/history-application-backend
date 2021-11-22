package com.example.demo.history.presentation.ui.api

import com.example.demo.history.application.input.CreateHistoryInput
import com.example.demo.history.application.service.SaveHistoryUseCase
import com.example.demo.history.domain.entity.History
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.*

@RestController
class CreateHistoryController(private val service: SaveHistoryUseCase) {

    @PostMapping("/api/experiences/{experienceId}/histories")
    fun save(
        @PathVariable("experienceId") experienceId: String,
        @Validated @RequestBody request: CreateHistoryInput
    ): ResponseEntity<History> {
        val history = service.save(
            History(
                UUID.randomUUID().toString(),
                experienceId,
                request.title,
                request.content,
                request.improvements,
                request.startDate,
                request.endDate
            )
        )

        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(history.id)
            .toUri()

        return ResponseEntity.created(location).body(history)
    }
}
