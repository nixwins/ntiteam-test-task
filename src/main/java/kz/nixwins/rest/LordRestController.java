package kz.nixwins.rest;

import kz.nixwins.model.Lord;
import kz.nixwins.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "https://dashboard.heroku.com/apps/ntiteam-front", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/lords")
public class LordRestController {

    @Autowired
    private LordService lordService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Lord>> getAllLords(){
        return  new ResponseEntity<>(lordService.getAllLords(), HttpStatus.OK);
    }

    @RequestMapping(value = "/free",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Lord>> getAllFreeLords(){
        return  new ResponseEntity<>(lordService.getAllFreeLords(), HttpStatus.OK );
    }

    @RequestMapping(value = "/create",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Lord> saveLord(@RequestBody @Validated Lord lord){
        HttpHeaders httpHeaders = new HttpHeaders();

        if(lord == null) return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        lordService.save(lord);
        return  new ResponseEntity<>(lord, httpHeaders, HttpStatus.CREATED );
    }

    @RequestMapping(value = "/yong",  method = RequestMethod.GET)
    public ResponseEntity<List<Lord>> getAllYongLords(){

        return  new ResponseEntity<>(lordService.getAllYongLords(), HttpStatus.OK);
    }
}
