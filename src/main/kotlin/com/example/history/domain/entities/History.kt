package com.example.history.domain.entities

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "history")
data class History(
    @Column(columnDefinition = "VARCHAR(36)") @Id val id: String,
    @Column var title: String,
    @Column var content: String,
    @Column var improvements: String?,
    @Column(columnDefinition = "DATE") var startDate: LocalDate,
    @Column(columnDefinition = "DATE") var endDate: LocalDate?,
) {
    @Column(columnDefinition = "DATE")
    lateinit var createdDate: LocalDate

    @Column(columnDefinition = "DATE")
    lateinit var updatedDate: LocalDate

    fun updateContent(content: String) {
        this.content = content
    }

    @PrePersist
    fun prePersist() {
        this.createdDate = LocalDate.now()
        this.updatedDate = LocalDate.now()
    }

    @PreUpdate
    fun preUpdate() {
        this.updatedDate = LocalDate.now()
    }
}
