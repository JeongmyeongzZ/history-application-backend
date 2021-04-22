package application.history.history.presentation.interfaces.api;

import application.history.history.application.services.DeleteHistoryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DeleteHistoryController {
    private final DeleteHistoryService service;

    public DeleteHistoryController(DeleteHistoryService deleteHistoryService) {
        this.service = deleteHistoryService;
    }

    @DeleteMapping("/histories/{date}")
    public ResponseEntity<Object> delete(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        this.service.run(date);

        return ResponseEntity.noContent().build();
    }
}
