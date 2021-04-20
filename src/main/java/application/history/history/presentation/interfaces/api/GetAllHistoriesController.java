package application.history.history.presentation.interfaces.api;

import application.history.history.application.services.GetAllHistoriesService;
import application.history.history.domain.entities.History;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAllHistoriesController {
    private final GetAllHistoriesService service;

    public GetAllHistoriesController(GetAllHistoriesService getAllHistory) {
        this.service = getAllHistory;
    }

    @GetMapping("/histories")
    public Iterable<History> getAllHistories() {
        return service.run();
    }
}
