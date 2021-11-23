package com.example.demo.experience.application.service

import com.example.demo.experience.domain.entity.Experience

interface FindExperienceUseCase {
    fun findById(id: String): Experience

    fun findAll(): Iterable<Experience>
}
