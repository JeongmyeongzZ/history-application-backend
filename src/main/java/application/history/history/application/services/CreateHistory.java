package application.history.history.application.services;

import application.history.history.domain.repositories.HistoryRepository;

public class CreateHistory {
    private final HistoryRepository repository;

    public CreateHistory(HistoryRepository repository) {
        this.repository = repository;
    }

//    public History run(CreateHistoryInput request) {
//        return this.repository.save(new History(
//            UUID.randomUUID().toString(), request.getTitle(), request.getArtworkUrl()
//        ));
//    }
}
