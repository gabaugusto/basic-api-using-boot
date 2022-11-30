package com.example.demo.controller;

import com.example.demo.repository.PrizeRepository;
import com.example.demo.modelo.Prize;
import com.example.demo.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Marca como uma controladora REST ou como uma API
@RequestMapping("/prize") //URL base dessa controladora
public class PrizeController {

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
    private Services prizeServices;

    @Autowired //Instância um novo Objeto esse em especifico conecta com o Banco de dados.
    PrizeRepository prizeBd;

    @CrossOrigin //@CrossOrigin(origins="http://localhost:3000")
    @PostMapping(value = "/criar", produces = "application/json") // Criar um novo registro
    public Prize criar(@RequestBody Prize exemplo){
        prizeBd.save(exemplo);
        return exemplo;
    }

    @CrossOrigin
    @GetMapping("/listar")
    public List<Prize> encontrarTodosRegistros(){
        return prizeBd.findAll();
    }

    //Encontrar um único elemento por nome
    @RequestMapping(value = "buscar/nome/{name}", method = RequestMethod.GET)
    public Optional<Prize> buscarPorNome(@PathVariable String name) {
        return prizeBd.findPrizeByName(name);
    }

    //Encontrar um único elemento por id
    @RequestMapping(value = "buscar/id/{id}", method = RequestMethod.GET)
    public Optional<Prize> buscarPorid(@PathVariable int id) {
        return prizeBd.findPrizeByid(id);
    }


    // atualizando elementos
    @PutMapping("/atualizar/id/{id}")
    public Prize atualizaPorID(@PathVariable int id, @RequestBody Prize movie) {

        Prize prize = prizeBd.findPrizeByid(id).get();

        prize.setName(movie.getName());
        prize.setYear_ceremony(movie.getYear_ceremony());
        prize.setCeremony(movie.getCeremony());
        prize.setCategory(movie.getCategory());
        prize.setYear_film(movie.getYear_film());
        prize.setFilm(movie.getFilm());

        prizeBd.save(prize);

        return prize;
    }

    // apagando elementos
    @DeleteMapping("/apagar/id/{id}") // APAGA UM DADO COM BASE NO NOME, NÃO ESQUEÇAM O GET
    public String deletarPorid(@PathVariable int id) {
        Prize prize = prizeBd.findPrizeByid(id).get();
        prizeBd.delete(prize);
        return "{deleted:"+id+"}";
    }

    /*
        @GetMapping("/nome/{nome}") // MOSTRA OS DADOS COM BASE NO NOME
        public Prize buscarPorNome(@PathVariable String name) {
            return prizeBd.findPrizeByName(name).get();
        }
     */

    //////////////////////////////////////////////////////////////////////
    //////// UTILIZAR SERVICES
    //////////////////////////////////////////////////////////////////////

    // Atualizar um registro
    @PutMapping("/atualizar_s/id/{id}")
    public String atualizaPorIDServices(@PathVariable int id, @RequestBody Prize movie) {
        Prize exemplo = prizeServices.findPrizeByid(id).get();
        prizeServices.updatePrize(movie);
        return "Registro atualizado com sucesso";
    }

    //Encontrar todos os elemetos
    @DeleteMapping("/apagar_s/id/{id}") //Utilizando Services
    public String deletarPorIdServices(@PathVariable int id) {
        Prize exemplo = prizeServices.findPrizeByid(id).get();
        prizeServices.deletePrize(exemplo);
        return "Registro apagado com sucesso";
    }

}
