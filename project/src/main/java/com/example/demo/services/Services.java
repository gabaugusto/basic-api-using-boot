package com.example.demo.services;

import com.example.demo.modelo.Prize;
import com.example.demo.repository.PrizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

// A forma de trabalhar com Services é para gerar maior organização no projeto.

@Service
public class Services {

    @Autowired
    private PrizeRepository prizeRepository;

    public Optional<Prize> findPrizeByName(String name){
        return prizeRepository.findPrizeByName(name);
    }

    public Optional<Prize> findPrizeByid(int id){
        return prizeRepository.findPrizeByid(id);
    }

    @Transactional //A Anotação Transactional serve para conectar e interagir com o banco.
    public Prize addPrize(Prize prize){
        return prizeRepository.save(prize);
    }

    @Transactional
    public void deletePrize(Prize prize){
        prizeRepository.delete(prize);
    }

    public Prize updatePrize(Prize prize){
        return prizeRepository.save(prize);
    }


}
