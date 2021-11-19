package com.example.history.endpoint.api

import com.example.history.application.services.FindHistoryUseCase
import com.example.history.domain.entities.History
import com.example.history.presentation.interfaces.api.GetAllHistoriesController
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.anyString
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.time.LocalDate
import java.util.*

@WebMvcTest(controllers = [GetAllHistoriesController::class])
@AutoConfigureMockMvc
class GetAllHistoriesTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var findHistoryUseCase: FindHistoryUseCase;

    @Test
    fun getHistories() {
        var history = History(
            "123", "123", "!!@#", "@!3123", LocalDate.now(), LocalDate.now()
        )
        history.createdDate = LocalDate.now();
        history.updatedDate = LocalDate.now();

        given(findHistoryUseCase.findAll()).willReturn(listOf(history))

        val a = mockMvc.perform(get("/api/histories").contentType(MediaType.APPLICATION_JSON))

        a.andExpect(status().isOk)
            .andDo(MockMvcResultHandlers.print())
    }

}
