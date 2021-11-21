package com.example.history.endpoint.api

import com.example.history.application.services.FindHistoryUseCase
import com.example.history.application.services.RemoveHistoryUseCase
import com.example.history.domain.entities.History
import com.example.history.presentation.interfaces.api.DeleteHistoryController
import com.example.util.getMockHistory
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(controllers = [DeleteHistoryController::class])
@AutoConfigureMockMvc
class DeleteHistoryTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var removeHistoryUseCase: RemoveHistoryUseCase

    @MockBean
    private lateinit var findHistoryUseCase: FindHistoryUseCase

    @Test
    fun deleteHistory() {

        val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())

        val history: History = mapper.readValue(getMockHistory())

        given(findHistoryUseCase.findById(BDDMockito.anyString())).willReturn(history)

        mockMvc.perform(delete("/api/histories/${history.id}"))
            .andExpect(status().isNoContent)
            .andDo(MockMvcResultHandlers.print())
    }

    /**
     * @link {https://withhamit.tistory.com/138}
     */
    private fun <T> any(java: Class<History>): T {
        Mockito.any<T>()
        return null as T
    }
}
