package application.history.history.presentation.interfaces.api;

import application.history.history.application.inputs.CreateHistoryInput;
import application.history.history.application.services.CreateHistoryService;
import application.history.history.domain.entities.History;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CreateHistoryController {
    private final CreateHistoryService service;

    public CreateHistoryController(CreateHistoryService createHistoryService) {
        this.service = createHistoryService;
    }

    @PostMapping("/histories")
    public ResponseEntity<History> save(@Validated @RequestBody CreateHistoryInput request) {
        History history = this.service.run(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{date}")
                .buildAndExpand(history.getDateByFormat("yyyy-MM-dd"))
                .toUri();

        return ResponseEntity.created(location).body(history);
    }
}
