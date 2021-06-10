package kz.nixwins.service;

import kz.nixwins.model.Planet;
import kz.nixwins.repository.PlanetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlanetService {

    @Autowired
    private PlanetsRepository planetsRepository;

    public List<Planet> getAllPlanet(){
        return  planetsRepository.getLordsWithNull();
    }

    public Planet getById(Long id) {
        return planetsRepository.findById(id).get();
    }

    public void delete(Long id) {

        planetsRepository.deleteById(id);
    }

    public Planet save(Planet planet){
        planetsRepository.save(planet);
        return  planet;
    }

    public void updateLord(Planet planet){
        planetsRepository.updateLordId(planet.getId(), planet.getLordId());
    }

}
