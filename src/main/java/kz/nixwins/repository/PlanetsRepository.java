package kz.nixwins.repository;

import kz.nixwins.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlanetsRepository  extends JpaRepository<Planet, Long> {
}
