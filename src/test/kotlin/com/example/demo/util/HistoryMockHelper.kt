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
