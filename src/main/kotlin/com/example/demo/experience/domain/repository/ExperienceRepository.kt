package com.example.demo.experience.domain.repository

import com.example.demo.experience.domain.entity.Experience
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ExperienceRepository : CrudRepository<Experience, String> {
}
