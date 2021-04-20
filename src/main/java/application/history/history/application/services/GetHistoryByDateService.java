package application.history.history.application.services;

import application.history.history.domain.entities.History;
import application.history.history.domain.repositories.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GetHistoryByDateService {
    private final HistoryRepository repository;

    public GetHistoryByDateService(HistoryRepository repository) {
        this.repository = repository;
    }

    public Optional<History> run(Date date) {
        return this.repository.findByDate(date);
    }
}
