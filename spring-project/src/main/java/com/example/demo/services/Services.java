package com.example.demo.services;

import com.example.demo.modelo.Award;
import com.example.demo.repository.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

// A forma de trabalhar com Services é para gerar maior organização no projeto.

@Service
public class Services {

    @Autowired
    private AwardRepository awardRepository;

    public Optional<Award> findAwardByName(String name){
        return awardRepository.findAwardByName(name);
    }

    public Optional<Award> findAwardByid(int id){
        return awardRepository.findAwardByid(id);
    }

    @Transactional //A Anotação Transactional serve para conectar e interagir com o banco.
    public Award addAward(Award prize){
        return awardRepository.save(prize);
    }

    @Transactional
    public void deleteAward(Award prize){
        awardRepository.delete(prize);
    }

    public Award updateAward(Award prize){
        return awardRepository.save(prize);
    }


}
