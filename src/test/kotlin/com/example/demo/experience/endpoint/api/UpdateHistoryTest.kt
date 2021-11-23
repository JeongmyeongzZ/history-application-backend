package com.example.demo.experience.endpoint.api

import com.example.demo.experience.application.service.FindExperienceUseCase
import com.example.demo.experience.application.service.SaveExperienceUseCase
import com.example.demo.experience.domain.entity.Experience
import com.example.demo.experience.presentation.ui.api.UpdateExperienceController
import com.example.demo.util.getMockExperience
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


@WebMvcTest(controllers = [UpdateExperienceController::class])
@AutoConfigureMockMvc
class UpdateHistoryTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var findExperienceUseCase: FindExperienceUseCase

    @MockBean
    private lateinit var saveExperienceUseCase: SaveExperienceUseCase

    @Test
    fun updateExperience() {

        val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())

        val experience: Experience = mapper.readValue(getMockExperience())

        given(findExperienceUseCase.findById(anyString())).willReturn(experience)
        given(saveExperienceUseCase.save(experience)).willReturn(experience)

        mockMvc.perform(
            put("/api/experiences/${experience.id}")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{" +
                            "\"company\": \"some new company\",\n" +
                            "\"position\": \"some new position\",\n" +
                            "\"startDate\": \"2021-04-07\"\n" +
                            "}"
                )
        )
            .andExpect(status().isNoContent)
            .andDo(MockMvcResultHandlers.print())
    }
}
