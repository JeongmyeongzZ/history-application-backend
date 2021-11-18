package com.example.history.presentation.interfaces.api

import com.example.history.application.inputs.UpdateHistoryInput
import com.example.history.application.services.UpdateHistoryContentService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class UpdateHistoryController(updateHistoryContentService: UpdateHistoryContentService) {
    private val service: UpdateHistoryContentService

    @PutMapping("/histories/{date}")
    fun save(
        @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") date: LocalDate?,
        @RequestBody request: UpdateHistoryInput
    ): ResponseEntity<Any> {
        service.run(date, request)
        return ResponseEntity.noContent().build()
    }

    init {
        service = updateHistoryContentService
    }
}
