package kz.nixwins.repository;

import kz.nixwins.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PlanetsRepository  extends JpaRepository<Planet, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Planet AS p SET p.lordId= :lordId WHERE p.id = :id")
    void updateLordId(@Param(value = "id") long id,  @Param(value = "lordId") Long lordId);

    @Query(nativeQuery = true, value = "SELECT  \n" +
            "p.id, p.name, p.lord_id, l.name as lord_name, \n" +
            "FROM planets AS p \n" +
            "LEFT JOIN lords AS l\n" +
            "ON l.id=p.lord_id \n" +
            "WHERE p.lord_id IS NULL OR p.lord_id > 0")
    List<Planet> getLordsWithNull();

//    @Query(nativeQuery = true, value = "DELETE FROM planets WHERE id = :id")
//    void deleteByIdIgnoreLordName(@Param(value = "id") Long id);
}
