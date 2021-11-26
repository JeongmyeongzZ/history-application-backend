package com.example.demo.memory.endpoint.api

import com.example.demo.memory.application.service.FindMemoryUseCase
import com.example.demo.memory.application.service.SaveMemoryUseCase
import com.example.demo.memory.domain.entity.Memory
import com.example.demo.memory.presentation.ui.api.UpdateMemoryController
import com.example.demo.util.getMockMemory
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


@WebMvcTest(controllers = [UpdateMemoryController::class])
@AutoConfigureMockMvc
class UpdateHistoryTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var findMemoryUseCase: FindMemoryUseCase

    @MockBean
    private lateinit var saveMemoryUseCase: SaveMemoryUseCase

    @Test
    fun updateMemory() {

        val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())

        val memory: Memory = mapper.readValue(getMockMemory())

        given(findMemoryUseCase.findById(anyString())).willReturn(memory)
        given(saveMemoryUseCase.save(memory)).willReturn(memory)

        mockMvc.perform(
            put("/api/memories/${memory.id}")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{" +
                            "\"description\": \"some new description\",\n" +
                            "\"date\": \"2021-04-07\"\n" +
                            "}"
                )
        )
            .andExpect(status().isNoContent)
            .andDo(MockMvcResultHandlers.print())
    }
}
