package com.example.history.application.input

import com.example.history.domain.entity.History
import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.util.*

data class CreateHistoryInput(
    val title: String,
    val content: String,
    val improvements: String?,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") val startDate: LocalDate,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") val endDate: LocalDate?
) {
    fun toEntity(): History {
        return History(
            UUID.randomUUID().toString(),
            this.title,
            this.content,
            this.improvements,
            this.startDate,
            this.endDate
        );
    }
}
