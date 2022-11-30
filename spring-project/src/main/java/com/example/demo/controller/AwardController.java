package com.example.demo.controller;

import com.example.demo.repository.AwardRepository;
import com.example.demo.modelo.Award;
import com.example.demo.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Marca como uma controladora REST ou como uma API
@RequestMapping("/award") //URL base dessa controladora
public class AwardController {

    /*
        CRUD          ->  Create, Read/Retrieve, Update and Delete
        GetMapping    ->  Traz dados do banco
        RequestMapping->  Traz dados do banco
        PostMapping   ->  Envia/cria dados para o banco
        DeleteMapping ->  Apaga dados do banco
        PutMapping    ->  Atualiza dados do banco
        Se não jogar contra os melhores é campeão do quê?
     */

    //Gerando uma instancia do Services
    @Autowired //Instância o Services para que possamos utilizar os seus métodos.
    private Services awardServices;

    @Autowired //Instância um novo Objeto esse em especifico conecta com o Banco de dados.
    AwardRepository awardBd;

    @CrossOrigin //@CrossOrigin(origins="http://localhost:3000")
    @PostMapping(value = "/create", produces = "application/json") // Criar um novo registro
    public Award create(@RequestBody Award example){
        awardBd.save(example);
        return example;
    }

    @CrossOrigin
    @GetMapping("/list")
    public List<Award> findAllRecords(){
        return awardBd.findAll();
    }

    //Encontrar um único elemento por nome
    @RequestMapping(value = "search/name/{name}", method = RequestMethod.GET)
    public Optional<Award> searchByName(@PathVariable String name) {
        return awardBd.findAwardByName(name);
    }

    //Encontrar um único elemento por id
    @RequestMapping(value = "search/id/{id}", method = RequestMethod.GET)
    public Optional<Award> searchById(@PathVariable int id) {
        return awardBd.findAwardByid(id);
    }


    // atualizando elementos
    @PutMapping("/update/id/{id}")
    public Award updateById(@PathVariable int id, @RequestBody Award movie) {

        Award award = awardBd.findAwardByid(id).get();

        award.setName(movie.getName());
        award.setYear_ceremony(movie.getYear_ceremony());
        award.setCeremony(movie.getCeremony());
        award.setCategory(movie.getCategory());
        award.setYear_film(movie.getYear_film());
        award.setFilm(movie.getFilm());

        awardBd.save(award);

        return award;
    }

    // apagando elementos
    @DeleteMapping("/delete/id/{id}") // APAGA UM DADO COM BASE NO NOME, NÃO ESQUEÇAM O GET
    public String deleteById(@PathVariable int id) {
        Award award = awardBd.findAwardByid(id).get();
        awardBd.delete(award);
        return "{deleted:"+id+"}";
    }

    /*
        @GetMapping("/nome/{nome}") // MOSTRA OS DADOS COM BASE NO NOME
        public Award buscarPorNome(@PathVariable String name) {
            return awardBd.findAwardByName(name).get();
        }
     */

    //////////////////////////////////////////////////////////////////////
    //////// UTILIZAR SERVICES
    //////////////////////////////////////////////////////////////////////

    // Atualizar um registro
    @PutMapping("/update_s/id/{id}")
    public String updateByIdServices(@PathVariable int id, @RequestBody Award movie) {
        Award exemplo = awardServices.findAwardByid(id).get();
        awardServices.updateAward(movie);
        return "Registro atualizado com sucesso";
    }

    //Encontrar todos os elemetos
    @DeleteMapping("/delete_s/id/{id}") //Utilizando Services
    public String deleteByIdServices(@PathVariable int id) {
        Award example = awardServices.findAwardByid(id).get();
        awardServices.deleteAward(example);
        return "Registro apagado com sucesso";
    }

}
