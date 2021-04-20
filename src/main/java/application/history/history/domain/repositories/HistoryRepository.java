package application.history.history.domain.repositories;

import application.history.history.domain.entities.History;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Repository
public interface HistoryRepository extends CrudRepository<History, String> {
    Optional<History> findByDate(Date date);

    @Transactional
    void deleteByDate(Date date);
}
