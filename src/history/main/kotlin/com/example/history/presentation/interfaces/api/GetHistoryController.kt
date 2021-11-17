package com.example.history.presentation.interfaces.api

import com.example.history.application.services.GetHistoryByDateService
import com.example.history.domain.entities.History
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.util.*

@RestController
class GetHistoryController(getHistoryService: GetHistoryByDateService) {
    private val service: GetHistoryByDateService
    @GetMapping("/histories/{date}")
    fun getHistory(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") date: LocalDate?): ResponseEntity<Optional<History>> {
        return ResponseEntity.ok(service.run(date))
    }

    init {
        service = getHistoryService
    }
}
