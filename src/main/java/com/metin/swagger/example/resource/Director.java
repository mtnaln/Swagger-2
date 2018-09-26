package com.metin.swagger.example.resource;

import java.util.ArrayList;
import java.util.List;

public class Director {

    private Integer id;
    private String name;
    private String surname;
    private List<Movie> movieList = new ArrayList<>();

    public Director() {

    }

    public Director(Integer id, String name, String surname, List<Movie> movieList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.movieList = movieList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
