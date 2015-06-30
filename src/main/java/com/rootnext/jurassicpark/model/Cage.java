package com.rootnext.jurassicpark.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sanjoy on 6/29/15.
 */
@Entity
public class Cage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Integer maxCapacity;
    @Column(nullable = false)
    private PowerStatus powerStatus;
    @OneToMany(targetEntity = Dinosaur.class, mappedBy = "cage")
    @JsonIgnore
    private List<Dinosaur> dinosaurs;

    public Cage(){
        dinosaurs = new ArrayList<>();
    }

    public Cage(Integer maxCapacity, PowerStatus powerStatus) {
        this.maxCapacity = maxCapacity;
        this.powerStatus = powerStatus;
        dinosaurs = new ArrayList<Dinosaur>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }

    public void setDinosaurs(List<Dinosaur> dinosaurs) {
        this.dinosaurs = dinosaurs;
    }

    public Integer getDinosaurContained(){
        return dinosaurs.size();
    }
}
