package com.example.demo.util

import org.springframework.core.io.ClassPathResource
import java.nio.file.Files
import java.nio.file.Paths

fun getMockHistory(): String {
    return Files.readString(Paths.get(ClassPathResource("stub/history.json").uri))
}

fun getMockHistories(): String {
    return Files.readString(Paths.get(ClassPathResource("stub/histories.json").uri))
}

fun getMockExperience(): String {
    return Files.readString(Paths.get(ClassPathResource("stub/experience.json").uri))
}

fun getMockExperiences(): String {
    return Files.readString(Paths.get(ClassPathResource("stub/experiences.json").uri))
}

fun getMockMemory(): String {
    return Files.readString(Paths.get(ClassPathResource("stub/memory.json").uri))
}

fun getMockMemories(): String {
    return Files.readString(Paths.get(ClassPathResource("stub/memories.json").uri))
}
