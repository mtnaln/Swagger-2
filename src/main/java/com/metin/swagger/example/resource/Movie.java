package com.metin.swagger.example.resource;

import io.swagger.annotations.ApiModelProperty;

public class Movie {

    private Integer id;

    @ApiModelProperty(notes = "Point of IMDB")
    private double imdbPoint;

    private String movieName;

    public Movie() {

    }

    public Movie(Integer id, double imdbPoint, String movieName) {
        this.id = id;
        this.imdbPoint = imdbPoint;
        this.movieName = movieName;
    }

    public double getImdbPoint() {
        return imdbPoint;
    }

    public void setImdbPoint(double imdbPoint) {
        this.imdbPoint = imdbPoint;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
