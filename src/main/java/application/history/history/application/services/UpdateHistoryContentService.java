package application.history.history.application.services;

import application.history.history.application.inputs.UpdateHistoryInput;
import application.history.history.domain.entities.History;
import application.history.history.domain.repositories.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UpdateHistoryContentService {
    private final HistoryRepository repository;

    public UpdateHistoryContentService(HistoryRepository repository) {
        this.repository = repository;
    }

    public History run(Date date, UpdateHistoryInput request) {
        History history = this.repository.findByDate(date).orElseThrow();

        history.updateContent(request.getContent());
        return this.repository.save(history);
    }
}
