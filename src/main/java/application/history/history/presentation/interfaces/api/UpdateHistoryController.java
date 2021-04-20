package application.history.history.presentation.interfaces.api;

import application.history.history.application.inputs.UpdateHistoryInput;
import application.history.history.application.services.UpdateHistoryContentService;
import application.history.history.domain.entities.History;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UpdateHistoryController {
    private final UpdateHistoryContentService service;

    public UpdateHistoryController(UpdateHistoryContentService updateHistoryContentService) {
        this.service = updateHistoryContentService;
    }

    @PutMapping("/histories/{date}")
    public History save(
        @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
        @RequestBody UpdateHistoryInput request
    ) {
        return this.service.run(date, request);
    }
}
