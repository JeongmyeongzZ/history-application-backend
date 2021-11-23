package com.example.demo.experience.presentation.ui.api

import com.example.demo.experience.application.input.UpdateExperienceInput
import com.example.demo.experience.application.service.FindExperienceUseCase
import com.example.demo.experience.application.service.SaveExperienceUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/experiences")
class UpdateExperienceController(
    private val saveExperienceUseCase: SaveExperienceUseCase,
    private val findExperienceUseCase: FindExperienceUseCase
) {

    @PutMapping("/{id}")
    fun update(
        @PathVariable("id") id: String,
        @RequestBody request: UpdateExperienceInput
    ): ResponseEntity<Any> {
        val experience = findExperienceUseCase.findById(id)

        experience.company = request.company
        experience.position = request.position
        experience.startDate = request.startDate
        experience.endDate = request.endDate

        saveExperienceUseCase.save(experience)

        return ResponseEntity.noContent().build()
    }

}
