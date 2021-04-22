package application.history.history.application.services;

import application.history.history.domain.repositories.HistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DeleteHistoryService {
    private final HistoryRepository repository;

    public DeleteHistoryService(HistoryRepository repository) {
        this.repository = repository;
    }

    public void run(LocalDate date) {
        this.repository.deleteByDate(date);
    }
}
