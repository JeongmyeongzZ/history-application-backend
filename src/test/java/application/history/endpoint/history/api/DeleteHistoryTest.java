package application.history.endpoint.history.api;

import application.history.IntegrationTest;
import application.history.WithFaker;
import application.history.history.application.services.DeleteHistoryService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class DeleteHistoryTest extends IntegrationTest implements WithFaker {

    @Autowired
    private DeleteHistoryService service;

    @SneakyThrows
    @Test
    public void deleteHistory() {

    }
}
