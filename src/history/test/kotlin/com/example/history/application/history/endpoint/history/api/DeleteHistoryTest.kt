package com.example.history.application.history.endpoint.history.api

import application.history.IntegrationTest
import org.junit.jupiter.api.Test

class DeleteHistoryTest : IntegrationTest(), WithFaker {
    @Autowired
    private val service: DeleteHistoryService? = null
    @SneakyThrows
    @Test
    fun deleteHistory() {
    }
}
