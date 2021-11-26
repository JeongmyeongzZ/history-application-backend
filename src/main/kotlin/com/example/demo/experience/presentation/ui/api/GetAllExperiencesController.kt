package com.example.demo.experience.presentation.ui.api

import com.example.demo.experience.application.service.FindExperienceUseCase
import com.example.demo.experience.domain.entity.Experience
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/experiences")
class GetAllExperiencesController(private val service: FindExperienceUseCase) {

    @GetMapping
    fun getExperiences(): ResponseEntity<Iterable<Experience>> {
        return ResponseEntity.ok(service.findAll())
    }
}
