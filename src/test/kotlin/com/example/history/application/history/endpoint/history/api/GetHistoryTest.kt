package com.example.history.application.history.endpoint.history.api

import application.history.IntegrationTest
import org.junit.jupiter.api.Test

class GetHistoryTest : IntegrationTest(), WithFaker {
    @Autowired
    private val service: GetHistoryByDateService? = null

    @get:Test
    @get:SneakyThrows
    val allHistories: Unit
        get() {}
}
