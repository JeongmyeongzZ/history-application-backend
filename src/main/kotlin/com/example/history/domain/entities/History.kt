package com.example.history.domain.entities

import java.text.SimpleDateFormat
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "history")
data class History(
    @field:Column(columnDefinition = "VARCHAR(36)") @field:Id private val id: String,
    @field:Column private var title: String,
    @field:Column private var content: String,
    @field:Column private var improvements: String?,
    @field:Column(columnDefinition = "DATE") private var startDate: LocalDate,
    @field:Column(columnDefinition = "DATE") private var endDate: LocalDate?,
    @field:Column(columnDefinition = "DATE") private var createdDate: LocalDate,
    @field:Column(columnDefinition = "DATE") private var updatedDate: LocalDate
) {
    // todo to util
//    fun getDateByFormat(format: String): String {
//        val simpleDateFormat = SimpleDateFormat(format)
//
//        return simpleDateFormat.format(date)
//    }

    fun updateContent(content: String) {
        this.content = content
    }
}
