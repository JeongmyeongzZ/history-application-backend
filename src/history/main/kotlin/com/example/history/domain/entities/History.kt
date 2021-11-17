package com.example.history.domain.entities

import java.text.SimpleDateFormat
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "history")
class History(
    @field:Column(columnDefinition = "VARCHAR(36)") @field:Id private val id: String,
    @field:Column private var content: String,
    date: LocalDate
) {
    @Column(columnDefinition = "DATE")
    private val date: LocalDate
    fun getDateByFormat(format: String?): String {
        val simpleDateFormat = SimpleDateFormat(format)
        return simpleDateFormat.format(date)
    }

    fun updateContent(content: String) {
        this.content = content
    }

    init {
        this.date = date
    }
}
