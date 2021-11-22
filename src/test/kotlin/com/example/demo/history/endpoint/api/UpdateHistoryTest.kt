package com.example.demo.history.endpoint.api

import com.example.demo.history.application.service.SaveHistoryUseCase
import com.example.demo.history.application.service.FindHistoryUseCase
import com.example.demo.history.domain.entity.History
import com.example.demo.history.presentation.ui.api.UpdateHistoryController
import com.example.demo.util.getMockHistory
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
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(controllers = [UpdateHistoryController::class])
@AutoConfigureMockMvc
class UpdateHistoryTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var findHistoryUseCase: FindHistoryUseCase

    @MockBean
    private lateinit var saveHistoryUseCase: SaveHistoryUseCase

    @Test
    fun updateHistory() {

        val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())

        val history: History = mapper.readValue(getMockHistory())

        given(findHistoryUseCase.findById(anyString())).willReturn(history)
        given(saveHistoryUseCase.save(history)).willReturn(history)

        mockMvc.perform(
            put("/api/histories/${history.id}")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{" +
                            "\"title\": \"some new title\",\n" +
                            "\"content\": \"some new contents\",\n" +
                            "\"startDate\": \"2021-04-07\"\n" +
                            "}"
                )
        )
            .andExpect(status().isNoContent)
            .andDo(MockMvcResultHandlers.print())
    }
}
