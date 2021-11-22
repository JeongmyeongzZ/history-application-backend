package com.example.history.endpoint.api

import com.example.history.any
import com.example.history.application.service.SaveHistoryUseCase
import com.example.history.domain.entity.History
import com.example.history.presentation.ui.api.CreateHistoryController
import com.example.util.getMockHistory
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(controllers = [CreateHistoryController::class])
@AutoConfigureMockMvc
class CreateHistoryTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var saveHistoryUseCase: SaveHistoryUseCase

    @Test
    fun createHistory() {

        val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())

        val history: History = mapper.readValue(getMockHistory())

        given(
            saveHistoryUseCase.save(
                any()
            )
        ).willReturn(history)

        mockMvc.perform(
            post("/api/experiences/f3415dc6-4b86-11ec-81d3-0242ac130003/histories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{" +
                            "\"title\": \"some new title\",\n" +
                            "\"content\": \"some new contents\",\n" +
                            "\"startDate\": \"2021-04-07\"\n" +
                            "}"
                )
        )
            .andExpect(status().isCreated)
            .andDo(MockMvcResultHandlers.print())
    }
}
