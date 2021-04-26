package application.history.endpoint.history.api;

import application.history.WithFaker;
import application.history.history.application.inputs.CreateHistoryInput;
import application.history.history.application.services.CreateHistoryService;
import application.history.history.presentation.interfaces.api.CreateHistoryController;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class CreateHistoryTest implements WithFaker {

    @Autowired
    MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @SneakyThrows
    @Test
    public void createHistory() {
        var randomContent = faker.random().hex();
        var randomDate = faker.date().future(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        CreateHistoryInput request = new CreateHistoryInput(randomContent, randomDate);
//
//        History history = new History(UUID.randomUUID().toString(), randomContent, randomDate);
//
//        given(service.run(new CreateHistoryInput(randomContent, randomDate))).willReturn(history);

        mvc.perform(
            MockMvcRequestBuilders
                .post("/histories")
                .content(objectMapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").exists());
    }
}
