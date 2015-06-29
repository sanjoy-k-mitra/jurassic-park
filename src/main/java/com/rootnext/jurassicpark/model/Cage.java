package com.rootnext.jurassicpark.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by sanjoy on 6/29/15.
 */
@Entity
public class Cage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer maxCapacity;
    private PowerStatus powerStatus;
    @OneToMany(targetEntity = Dinosaur.class)
    private Set<Dinosaur> dinosaurs;

    public Cage(){

    }

    public Cage(Integer id, Integer maxCapacity, PowerStatus powerStatus) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.powerStatus = powerStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Enumerated(EnumType.STRING)
    public PowerStatus getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(PowerStatus powerStatus) {
        this.powerStatus = powerStatus;
    }

    public Set<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public void setDinosaurs(Set<Dinosaur> dinosaurs) {
        this.dinosaurs = dinosaurs;
    }
}
