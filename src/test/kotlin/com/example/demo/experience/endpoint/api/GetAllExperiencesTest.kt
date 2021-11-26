package com.example.demo.experience.endpoint.api

import com.example.demo.experience.application.service.FindExperienceUseCase
import com.example.demo.experience.presentation.ui.api.GetAllExperiencesController
import com.example.demo.util.getMockExperiences
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


@WebMvcTest(controllers = [GetAllExperiencesController::class])
@AutoConfigureMockMvc
class GetAllExperiencesTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var findExperienceUseCase: FindExperienceUseCase

    @Test
    fun getHistories() {

        val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())

        given(findExperienceUseCase.findAll()).willReturn(mapper.readValue(getMockExperiences()))

        mockMvc.perform(get("/api/experiences"))
            .andExpect(status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }
}
