package com.example.history.presentation.ui.api

import com.example.history.application.input.UpdateHistoryInput
import com.example.history.application.service.FindHistoryUseCase
import com.example.history.application.service.SaveHistoryUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/histories")
class UpdateHistoryController(
    private val updateHistoryService: SaveHistoryUseCase,
    private val findHistoryService: FindHistoryUseCase
) {

    @PutMapping("/{id}")
    fun update(
        @PathVariable("id") id: String,
        @RequestBody request: UpdateHistoryInput
    ): ResponseEntity<Any> {
        val history = findHistoryService.findById(id);

        history.content = request.content;
        history.title = request.title;
        history.improvements = request.improvements;
        history.startDate = request.startDate;
        history.endDate = request.endDate;

        updateHistoryService.save(history)

        return ResponseEntity.noContent().build()
    }

}
