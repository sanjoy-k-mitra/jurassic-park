package com.rootnext.jurassicpark.model;

/**
 * Created by sanjoy on 6/29/15.
 */
public class Cage {
    private Integer id;
    private Integer maxCapacity;
    private PowerStatus powerStatus;

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

    public PowerStatus getPowerStatus() {
        return powerStatus;
    }

    public void setPowerStatus(PowerStatus powerStatus) {
        this.powerStatus = powerStatus;
    }
}
