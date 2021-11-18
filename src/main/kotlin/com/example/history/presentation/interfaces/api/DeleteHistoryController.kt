package com.example.history.presentation.interfaces.api

import com.example.history.application.services.DeleteHistoryService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class DeleteHistoryController(deleteHistoryService: DeleteHistoryService) {
    private val service: DeleteHistoryService
    @DeleteMapping("/histories/{date}")
    fun delete(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") date: LocalDate?): ResponseEntity<Any> {
        service.run(date)
        return ResponseEntity.noContent().build()
    }

    init {
        service = deleteHistoryService
    }
}
