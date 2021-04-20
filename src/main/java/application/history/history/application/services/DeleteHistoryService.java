package application.history.history.application.services;

import application.history.history.domain.repositories.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DeleteHistoryService {
    private final HistoryRepository repository;

    public DeleteHistoryService(HistoryRepository repository) {
        this.repository = repository;
    }

    public void run(Date date) {
        this.repository.deleteByDate(date);
    }
}
