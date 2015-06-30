package com.rootnext.jurassicpark.model;

import javax.persistence.*;

/**
 * Created by sanjoy on 6/29/15.
 */
@Entity
public class Dinosaur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ManyToOne(targetEntity = Species.class, optional = false)
    private Species species;
    @ManyToOne(targetEntity = Cage.class)
    private Cage cage;

    public Dinosaur(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setCage(Cage cage) throws Exception{
        if(cage.getPowerStatus() == PowerStatus.DOWN){
            throw new Exception("Dinosaur can not be assigned to Power Down Cage");
        }
        if(cage.getMaxCapacity() <= cage.getDinosaurContained()){
            throw new Exception("Cage is Already Full");
        }
        if(cage.getDinosaurs().size() > 0 && (cage.getDinosaurs().get(0).getSpecies().getDinosaurType() == DinosaurType.Carnivores || this.species.getDinosaurType() == DinosaurType.Carnivores)){
            if(cage.getDinosaurs().get(0).species != this.species){
                throw new Exception("Incompatable DinosaurType");
            }
        }
        this.cage = cage;
    }
}
