package kz.nixwins.repository;

import kz.nixwins.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PlanetsRepository  extends JpaRepository<Planet, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Planet AS p SET p.lordId= :lordId WHERE p.id = :id")
    void updateLordId(@Param(value = "id") long id,  @Param(value = "lordId") Long lordId);
}
