package com.tales.restapi.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Parking {
    private @Id @GeneratedValue Long id;
    private List<ParkingLevel> levels;

    public Parking() {
    }

    public Parking(List<ParkingLevel> levels) {
        this.levels = levels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ParkingLevel> getLevels() {
        return levels;
    }

    public void setLevels(List<ParkingLevel> levels) {
        this.levels = levels;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((levels == null) ? 0 : levels.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Parking other = (Parking) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (levels == null) {
            if (other.levels != null)
                return false;
        } else if (!levels.equals(other.levels))
            return false;
        return true;
    }
}
