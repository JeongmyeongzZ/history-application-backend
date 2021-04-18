package application.history.history.domain.repositories;

import application.history.history.domain.entities.History;
import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, String> {
}
