package com.example.history.presentation.interfaces.api

import com.example.history.application.inputs.CreateHistoryInput
import com.example.history.application.services.CreateHistoryService
import com.example.history.domain.entities.History
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
class CreateHistoryController(createHistoryService: CreateHistoryService) {
    private val service: CreateHistoryService

    @PostMapping("/histories")
    fun save(@Validated @RequestBody request: CreateHistoryInput): ResponseEntity<History> {
        val history: History = service.run(request)
        val location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{date}")
            .buildAndExpand(history.getDateByFormat("yyyy-MM-dd"))
            .toUri()
        return ResponseEntity.created(location).body<History>(history)
    }

    init {
        service = createHistoryService
    }
}
