package com.example.demo.history.domain.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "history")
data class History(
    @Column(columnDefinition = "VARCHAR(36)") @Id val id: String,
    @Column(columnDefinition = "VARCHAR(36)") @Id val experienceId: String,
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
