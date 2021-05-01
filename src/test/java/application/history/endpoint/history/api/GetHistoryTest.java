package application.history.endpoint.history.api;

import application.history.IntegrationTest;
import application.history.WithFaker;
import application.history.history.application.services.GetHistoryByDateService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class GetHistoryTest extends IntegrationTest implements WithFaker {

    @Autowired
    private GetHistoryByDateService service;

    @SneakyThrows
    @Test
    public void getAllHistories() {
    }
}
