package com.codingdojo.studentroster1n.services;

import com.codingdojo.studentroster1n.models.Dorm;
import com.codingdojo.studentroster1n.repositories.DormRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DormService {
    private DormRepository dormRepository;

    public DormService(DormRepository dormRepository) {
        this.dormRepository = dormRepository;
    }

    public List<Dorm> getAllDorms(){
        return dormRepository.findAll();
    }

    public Dorm addDorm(Dorm dorm){
        return dormRepository.save(dorm);
    }

    public Dorm findDorm(Long id){
        Optional<Dorm> optionalDorm = dormRepository.findById(id);
        if(optionalDorm.isPresent()){
            return optionalDorm.get();
        } else {
            return null;
        }
    }
}
