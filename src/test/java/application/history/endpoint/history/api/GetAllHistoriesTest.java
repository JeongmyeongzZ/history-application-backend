package application.history.endpoint.history.api;

import application.history.IntegrationTest;
import application.history.WithFaker;
import application.history.history.application.services.GetAllHistoriesService;
import application.history.history.presentation.interfaces.api.GetAllHistoriesController;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class GetAllHistoriesTest extends IntegrationTest implements WithFaker {

    @Autowired
    private GetAllHistoriesService service;

    @SneakyThrows
    @Test
    public void getAllHistories() {
//        var randomContent = faker.random().hex();
//        var randomDate = faker.date().future(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//        CreateHistoryInput request = new CreateHistoryInput(randomContent, randomDate);
//
//        History history = new History(UUID.randomUUID().toString(), randomContent, randomDate);
//
//        given(service.run(new CreateHistoryInput(randomContent, randomDate))).willReturn(history);

//        .content(objectMapper.writeValueAsString(request))

        ResultActions resultActions = mvc.perform(
                get("/histories")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        var a = 1;
//
//        resultActions.andExpect(status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.date").exists());
    }
}
