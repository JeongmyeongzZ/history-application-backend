package com.example.demo.history.presentation.interfaces.api;

import com.example.demo.history.domain.entities.History;
import com.example.demo.history.domain.repositories.HistoryRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoriesController {
    @GetMapping("/histories")
    public List<History> getAllHistories() {
        return HistoryRepository.findAll();
    }
    @PostMapping("/histories")
    public History run(@Validated @RequestBody History history) {
        return HistoryRepository.save(history);
    }
}
