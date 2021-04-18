package com.example.demo.history.application.services;

import com.example.demo.history.application.inputs.CreateHistoryInput;
import com.example.demo.history.domain.entities.History;
import com.example.demo.history.domain.repositories.HistoryRepository;

import java.util.UUID;

public class CreateHistory {
    private final HistoryRepository repository;

    public CreateHistory(HistoryRepository repository) {
        this.repository = repository;
    }

    public History run(CreateHistoryInput request) {
        return this.repository.save(new History(
            UUID.randomUUID().toString(), request.getTitle(), request.getArtworkUrl()
        ));
    }
}
