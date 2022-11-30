package com.example.demo.repository;

import com.example.demo.modelo.Award;
import org.springframework.data.jpa.repository.JpaRepository; //Vivo
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

    /*
        Classe responsavel por se comunicar com o banco de dados: SALVAR, LER, ATUALIZAR E DELETAR
    */

@Repository
public interface AwardRepository extends JpaRepository<Award, UUID> {
    /*
    A CLASSE DEVE SER ESCRITA DESSA MESMA FORMA E ESSA CLASSE JA POSSUI METODOS EXISTENTES MAS CASO VOCE
    QUEIRA CRIAR ALGO ESPECIFICO BASTA FAZER IGUAL A LINHA 24 SEGUE DOCUMENTAÇÃO DE APOIO
    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
     */
    Optional<Award> findAwardByName(String name);

    Optional<Award> findAwardByid(int id);


}
