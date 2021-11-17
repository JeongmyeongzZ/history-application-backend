package com.example.history.presentation.interfaces.api

import com.example.history.application.services.GetAllHistoriesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GetAllHistoriesController(getAllHistory: GetAllHistoriesService) {
    private val service: GetAllHistoriesService

    @get:GetMapping("/histories")
    val allHistories: ResponseEntity<Iterable<Any>>
        get() = ResponseEntity.ok(service.run())

    init {
        service = getAllHistory
    }
}
