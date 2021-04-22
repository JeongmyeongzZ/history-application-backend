package application.history.history.presentation.interfaces.api;

import application.history.history.application.inputs.UpdateHistoryInput;
import application.history.history.application.services.UpdateHistoryContentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class UpdateHistoryController {
    private final UpdateHistoryContentService service;

    public UpdateHistoryController(UpdateHistoryContentService updateHistoryContentService) {
        this.service = updateHistoryContentService;
    }

    @PutMapping("/histories/{date}")
    public ResponseEntity<Object> save(
        @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
        @RequestBody UpdateHistoryInput request
    ) {
        this.service.run(date, request);

        return ResponseEntity.noContent().build();
    }
}
