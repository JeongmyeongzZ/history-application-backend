package application.history.endpoint.history.api;

import application.history.IntegrationTest;
import application.history.WithFaker;
import application.history.history.application.services.CreateHistoryService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CreateHistoryTest extends IntegrationTest implements WithFaker {

    @Autowired
    private CreateHistoryService service;

    @SneakyThrows
    @Test
    public void getAllHistories() {
    }
}
