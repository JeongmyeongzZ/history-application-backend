package application.history.history.presentation.interfaces.api;

import application.history.history.application.services.GetHistoryByDateService;
import application.history.history.domain.entities.History;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class GetHistoryController {
    private final GetHistoryByDateService service;

    public GetHistoryController(GetHistoryByDateService getHistoryService) {
        this.service = getHistoryService;
    }

    @GetMapping("/histories/{date}")
    public Optional<History> getHistory(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return this.service.run(date);
    }
}
