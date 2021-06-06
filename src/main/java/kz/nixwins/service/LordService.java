package kz.nixwins.service;

import kz.nixwins.model.Lord;
import kz.nixwins.model.Planet;
import kz.nixwins.repository.LordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LordService {

    @Autowired
    private LordsRepository lordsRepository;

    public List<Lord> getAllLords(){

        return  lordsRepository.findAll();
    }

    public List<Lord> getAllFreeLords(){
        return  lordsRepository.findByStatus();
    }
    public Optional<Lord> getById(Long id) {
        return lordsRepository.findById(id);
    }

    public Lord save(Lord lord){
        lordsRepository.save(lord);
        return  lord;
    }

    public List<Lord> getAllYongLords(){
            return lordsRepository.findByAge(PageRequest.of(0, 10));
    }

    public void delete(Long id) {

        lordsRepository.deleteById(id);
    }
}
