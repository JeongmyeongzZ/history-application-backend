package application.history.history.application.services;

import application.history.history.application.inputs.CreateHistoryInput;
import application.history.history.domain.entities.History;
import application.history.history.domain.repositories.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllHistoryService {
    private final HistoryRepository repository;

    public GetAllHistoryService(HistoryRepository repository) {
        this.repository = repository;
    }

    public Iterable<History> run() {
        return this.repository.findAll();
    }
}
