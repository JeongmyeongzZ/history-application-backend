package com.example.demo.memory.endpoint.api

import com.example.demo.memory.application.service.FindMemoryUseCase
import com.example.demo.memory.presentation.ui.api.GetAllMemoriesController
import com.example.demo.util.getMockMemories
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(controllers = [GetAllMemoriesController::class])
@AutoConfigureMockMvc
class GetAllMemoriesTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var findMemoryUseCase: FindMemoryUseCase

    @Test
    fun getHistories() {

        val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())

        given(findMemoryUseCase.findAll()).willReturn(mapper.readValue(getMockMemories()))

        mockMvc.perform(get("/api/memories"))
            .andExpect(status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }
}
