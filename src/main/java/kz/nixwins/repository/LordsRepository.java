package kz.nixwins.repository;

import kz.nixwins.model.Lord;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LordsRepository extends JpaRepository<Lord, Long> {
    @Query(value = "SELECT  new kz.nixwins.model.Lord (l.id, l.name, l.age) FROM Lord AS l LEFT JOIN Planet AS p ON l.id=p.lordId WHERE p.lordId IS NULL")
    List<Lord> findByStatus();

    @Query(value = "SELECT new kz.nixwins.model.Lord (id, name, age) FROM Lord ORDER BY age")
    List<Lord> findByAge(Pageable pageable);
}
