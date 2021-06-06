package kz.nixwins.rest;

import kz.nixwins.model.Lord;
import kz.nixwins.model.Planet;
import kz.nixwins.service.LordService;
import kz.nixwins.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/planets")
public class PlanetRestController {

    @Autowired
    private PlanetService planetService;
//    @Autowired
//    private LordService lordService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Planet>> getAllPlanets(){

        return  new ResponseEntity<>(planetService.getAllPlanet(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planet> savePlanet(@RequestBody @Validated Planet planet){
        planetService.save(planet);
        return new ResponseEntity<>(planet, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Planet> deletePlanet(@PathVariable("id") Long id){
        Optional<Planet> planet = planetService.getById(id);
        if(planet == null) return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        planetService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
