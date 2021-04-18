package application.history.history.presentation.interfaces.api;

import application.history.history.application.inputs.CreateHistoryInput;
import application.history.history.application.services.CreateHistoryService;
import application.history.history.application.services.GetAllHistoryService;
import application.history.history.domain.entities.History;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoriesController {
    private final CreateHistoryService createService;
    private final GetAllHistoryService getAllService;

    public HistoriesController(CreateHistoryService createHistory, GetAllHistoryService getAllHistory) {
        this.createService = createHistory;
        this.getAllService = getAllHistory;
    }

    @GetMapping("/histories")
    public Iterable<History> getAllHistories() {
        return getAllService.run();
    }

    @PostMapping("/histories")
    public History save(@Validated @RequestBody CreateHistoryInput request) {
        return this.createService.run(request);
    }
}
