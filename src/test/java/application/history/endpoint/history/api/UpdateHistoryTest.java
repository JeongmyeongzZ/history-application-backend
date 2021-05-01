package application.history.endpoint.history.api;

import application.history.IntegrationTest;
import application.history.WithFaker;
import application.history.history.application.services.UpdateHistoryContentService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class UpdateHistoryTest extends IntegrationTest implements WithFaker {

    @Autowired
    private UpdateHistoryContentService service;

    @SneakyThrows
    @Test
    public void getAllHistories() {
    }
}
