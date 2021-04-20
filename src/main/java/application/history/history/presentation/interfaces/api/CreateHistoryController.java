package application.history.history.presentation.interfaces.api;

import application.history.history.application.inputs.CreateHistoryInput;
import application.history.history.application.services.CreateHistoryService;
import application.history.history.domain.entities.History;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateHistoryController {
    private final CreateHistoryService service;

    public CreateHistoryController(CreateHistoryService createHistoryService) {
        this.service = createHistoryService;
    }

    @PostMapping("/histories")
    public History save(@Validated @RequestBody CreateHistoryInput request) {
        return this.service.run(request);
    }
}
