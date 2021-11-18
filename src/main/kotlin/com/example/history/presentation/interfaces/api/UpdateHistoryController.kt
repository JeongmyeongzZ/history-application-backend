package com.example.history.presentation.interfaces.api

import com.example.history.application.inputs.UpdateHistoryInput
import com.example.history.application.services.FindHistoryUseCase
import com.example.history.application.services.SaveHistoryUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdateHistoryController(private val updateHistoryService: SaveHistoryUseCase, private val findHistoryService: FindHistoryUseCase) {

    @PutMapping("/histories/{id}")
    fun save(
        @PathVariable("id") id: String,
        @RequestBody request: UpdateHistoryInput
    ): ResponseEntity<Any> {
        updateHistoryService.save(findHistoryService.findById(id))

        return ResponseEntity.noContent().build()
    }

}
