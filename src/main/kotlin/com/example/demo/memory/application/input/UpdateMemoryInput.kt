package com.example.demo.memory.application.input

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate


data class UpdateMemoryInput(
    val description: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") val date: LocalDate
)
