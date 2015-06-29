package com.rootnext.jurassicpark.model;

import javax.persistence.*;

/**
 * Created by sanjoy on 6/29/15.
 */
@Entity
public class Dinosaur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @ManyToOne(targetEntity = Species.class)
    private Species species;
    @ManyToOne(targetEntity = Cage.class)
    private Cage cage;

    public Dinosaur(){

    }

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
