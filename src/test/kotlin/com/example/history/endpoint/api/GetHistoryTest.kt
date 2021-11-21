package com.example.history.endpoint.api

import com.example.history.application.services.FindHistoryUseCase
import com.example.history.domain.entities.History
import com.example.history.presentation.interfaces.api.GetHistoryController
import com.example.util.getMockHistory
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.anyString
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(controllers = [GetHistoryController::class])
@AutoConfigureMockMvc
class GetHistoryTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var findHistoryUseCase: FindHistoryUseCase

    @Test
    fun getHistory() {

        val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())

        val history: History = mapper.readValue(getMockHistory())

        given(findHistoryUseCase.findById(anyString())).willReturn(history)

        mockMvc.perform(get("/api/histories/${history.id}"))
            .andExpect(status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }
}
