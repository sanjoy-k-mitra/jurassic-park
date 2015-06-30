package com.rootnext.jurassicpark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sanjoy on 6/29/15.
 */
@Entity
public class Cage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private Integer maxCapacity;
    @Column(nullable = false)
    private PowerStatus powerStatus;
    @OneToMany(targetEntity = Dinosaur.class, mappedBy = "cage")
    @JsonIgnore
    private Set<Dinosaur> dinosaurs;

    public Cage(){
        dinosaurs = new HashSet<Dinosaur>();
    }

    public Cage(Integer maxCapacity, PowerStatus powerStatus) {
        this.maxCapacity = maxCapacity;
        this.powerStatus = powerStatus;
        dinosaurs = new HashSet<Dinosaur>();
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

    public Integer getDinosaurContained(){
        return dinosaurs.size();
    }
}
