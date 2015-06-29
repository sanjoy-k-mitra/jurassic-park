package com.rootnext.jurassicpark.model;

/**
 * Created by sanjoy on 6/29/15.
 */
public class Dinosaur {
    private Integer id;
    private String name;
    private Species species;
    private Cage cage;

    public Dinosaur(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }
}
