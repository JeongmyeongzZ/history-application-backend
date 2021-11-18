package com.example.history.application.history.endpoint.history.api

import application.history.IntegrationTest
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType

class GetAllHistoriesTest : IntegrationTest(), WithFaker {
    @Autowired
    private val service: GetAllHistoriesService? = null
    //        var randomContent = faker.random().hex();
//        var randomDate = faker.date().future(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//        CreateHistoryInput request = new CreateHistoryInput(randomContent, randomDate);
//
//        History history = new History(UUID.randomUUID().toString(), randomContent, randomDate);
//
//        given(service.run(new CreateHistoryInput(randomContent, randomDate))).willReturn(history);

    //        .content(objectMapper.writeValueAsString(request))
    @get:Test
    @get:SneakyThrows
    val allHistories:
    //
//        resultActions.andExpect(status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.date").exists());
            Unit
        get() {
//        var randomContent = faker.random().hex();
//        var randomDate = faker.date().future(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//        CreateHistoryInput request = new CreateHistoryInput(randomContent, randomDate);
//
//        History history = new History(UUID.randomUUID().toString(), randomContent, randomDate);
//
//        given(service.run(new CreateHistoryInput(randomContent, randomDate))).willReturn(history);

//        .content(objectMapper.writeValueAsString(request))
            val resultActions: ResultActions = mvc.perform(
                MockMvcRequestBuilders.get("/histories")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            ).andExpect(MockMvcResultMatchers.status().isOk())
            val a = 1
            //
//        resultActions.andExpect(status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.date").exists());
        }
}
