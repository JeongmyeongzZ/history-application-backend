package com.example.demo.history.application.input

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class CreateHistoryInput(
    val title: String,
    val content: String,
    val improvements: String?,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") val startDate: LocalDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") val endDate: LocalDate?
)
