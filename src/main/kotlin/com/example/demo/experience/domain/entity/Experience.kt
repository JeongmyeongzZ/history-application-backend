package com.example.demo.experience.domain.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "experience")
data class Experience(
    @Column(columnDefinition = "VARCHAR(36)") @Id val id: String,
    @Column var company: String,
    @Column var position: String,
    @Column(columnDefinition = "DATE") var startDate: LocalDate,
    @Column(columnDefinition = "DATE") var endDate: LocalDate?,
)
