package kz.nixwins.service;

import kz.nixwins.model.Planet;
import kz.nixwins.repository.PlanetsRepository;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        planetsRepository.deleteByIdIgnoreLordName(id);
    }

    public Planet save(Planet planet){
        planetsRepository.save(planet);
        return  planet;
    }


    public void updateLord(Planet planet){
        planetsRepository.updateLordId(planet.getId(), planet.getLordId());
    }

}
