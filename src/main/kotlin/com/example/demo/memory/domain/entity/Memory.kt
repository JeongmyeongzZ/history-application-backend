package com.example.demo.memory.domain.entity

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "memory")
data class Memory(
    @Column(columnDefinition = "VARCHAR(36)") @Id val id: String,
    @Column var imageUrl: String,
    @Column var description: String,
    @Column(columnDefinition = "DATE") var date: LocalDate
)
