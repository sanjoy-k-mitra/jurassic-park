package com.rootnext.jurassicpark.model;

/**
 * Created by sanjoy on 6/29/15.
 */
public class Species {
    private Integer id;
    private String name;
    private DinosaurType dinosaurType;

    public Species(Integer id, String name, DinosaurType dinosaurType) {
        this.id = id;
        this.name = name;
        this.dinosaurType = dinosaurType;
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

    public DinosaurType getDinosaurType() {
        return dinosaurType;
    }

    public void setDinosaurType(DinosaurType dinosaurType) {
        this.dinosaurType = dinosaurType;
    }
}
