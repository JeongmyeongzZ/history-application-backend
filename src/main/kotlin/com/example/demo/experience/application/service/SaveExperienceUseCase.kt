package com.example.demo.experience.application.service

import com.example.demo.experience.domain.entity.Experience

interface SaveExperienceUseCase {
    fun save(experience: Experience): Experience
}
