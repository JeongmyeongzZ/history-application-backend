package com.example.history.application.history.endpoint.history.api

import application.history.IntegrationTest
import org.junit.jupiter.api.Test

class CreateHistoryTest : IntegrationTest(), WithFaker {
    @Autowired
    private val service: CreateHistoryService? = null

    @get:Test
    @get:SneakyThrows
    val allHistories: Unit
        get() {}
}
