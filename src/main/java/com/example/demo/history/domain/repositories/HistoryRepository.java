package com.example.demo.history.domain.repositories;

import com.example.demo.history.domain.entities.History;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, String> {
}
