package com.example.history.application.inputs

import com.fasterxml.jackson.annotation.JsonFormat
import com.sun.istack.NotNull
import java.time.LocalDate

class CreateHistoryInput(@field:NotNull private val content: String, date: LocalDate) {
    fun getContent(): String {
        return this.content;
    }

    fun getDate(): LocalDate {
        return this.date;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull
    private val date: LocalDate

    init {
        this.date = date
    }
}
