package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import java.util.UUID;

/*
    As entidades são nossas tabelas no banco de dados, chamadas tambem de objetos, tudo que tem aqui é
criado da mesma forma em nosso banco.
*/


@Entity //Mostra ao SPRING que é uma tabela
@Table(schema = "movies") //Da nome a uma tabela ou utiliza uma table existente, caso seja existente todos os campos - devem ser identicos (classe e tabela)
public class Award {

    @Id //NECESSÁRIO MARCAR COMO ID (CHAVE PRIMARIA)
    //@GeneratedValue(strategy = GenerationType.AUTO) //GERADOR AUTOMATICO DE ID
    private int id;

    private int year_film;

    private int year_ceremony;

    private int ceremony;

    private String category;
    private String name;

    private String film ;
    private int winner;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getYear_film() {
        return year_film;
    }

    public void setYear_film(int year_film) {
        this.year_film = year_film;
    }

    public int getYear_ceremony() {
        return year_ceremony;
    }

    public void setYear_ceremony(int year_ceremony) {
        this.year_ceremony = year_ceremony;
    }

    public int getCeremony() {
        return ceremony;
    }

    public void setCeremony(int ceremony) {
        this.ceremony = ceremony;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public int getWinner() { return winner; }

    public void setWinner(int winner) {
        this.winner = winner;
    }
}
