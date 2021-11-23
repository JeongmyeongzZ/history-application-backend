package com.example.demo.experience.application.service.impl

import com.example.demo.experience.application.service.SaveExperienceUseCase
import com.example.demo.experience.domain.entity.Experience
import com.example.demo.experience.application.exception.ExperienceNotFoundException
import com.example.demo.experience.application.service.FindExperienceUseCase
import com.example.demo.experience.domain.repository.ExperienceRepository
import org.springframework.stereotype.Service

@Service
class ExperienceService(private val repository: ExperienceRepository) : FindExperienceUseCase, SaveExperienceUseCase {
    override fun findById(id: String): Experience {
        return repository.findById(id).orElseThrow { ExperienceNotFoundException("Experience not found") }
    }

    override fun findAll(): Iterable<Experience> {
        return repository.findAll()
    }

    override fun save(experience: Experience): Experience {
        return repository.save(experience)
    }
}
