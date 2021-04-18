package application.history.history.application.services;

import application.history.history.application.inputs.CreateHistoryInput;
import application.history.history.domain.entities.History;
import application.history.history.domain.repositories.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateHistoryService {
    private final HistoryRepository repository;

    public CreateHistoryService(HistoryRepository repository) {
        this.repository = repository;
    }

    public History run(CreateHistoryInput request) {
        return this.repository.save(new History(
            UUID.randomUUID().toString(), request.getContent(), request.getDate()
        ));
    }
}
