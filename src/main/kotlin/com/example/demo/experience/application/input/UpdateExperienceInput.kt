package com.example.demo.experience.application.input

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate


data class UpdateExperienceInput(
    val company: String,
    val position: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") val startDate: LocalDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") val endDate: LocalDate?
)
