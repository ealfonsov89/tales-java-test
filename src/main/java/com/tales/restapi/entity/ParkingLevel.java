package com.tales.restapi.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ParkingLevel {
    private @Id @GeneratedValue Long id;
    private List<ParkingLevelRow> parkingLevelRows;

    public ParkingLevel() {
    }

    public ParkingLevel(List<ParkingLevelRow> parkingLevelRows) {
        this.parkingLevelRows = parkingLevelRows;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ParkingLevelRow> getParkingLevelRows() {
        return parkingLevelRows;
    }

    public void setParkingLevelRows(List<ParkingLevelRow> parkingLevelRows) {
        this.parkingLevelRows = parkingLevelRows;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((parkingLevelRows == null) ? 0 : parkingLevelRows.hashCode());
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
        ParkingLevel other = (ParkingLevel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (parkingLevelRows == null) {
            if (other.parkingLevelRows != null)
                return false;
        } else if (!parkingLevelRows.equals(other.parkingLevelRows))
            return false;
        return true;
    }

}
