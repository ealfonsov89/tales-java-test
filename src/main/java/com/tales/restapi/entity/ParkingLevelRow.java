package com.tales.restapi.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ParkingLevelRow {
    private @Id @GeneratedValue Long id;
    private List<ParkingLevelRowSpot> parkingLevelRowSpots;

    public ParkingLevelRow() {
    }

    public ParkingLevelRow(List<ParkingLevelRowSpot> parkingLevelRowSpots) {
        this.parkingLevelRowSpots = parkingLevelRowSpots;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ParkingLevelRowSpot> getParkingLevelRowSpots() {
        return parkingLevelRowSpots;
    }

    public void setParkingLevelRowSpots(List<ParkingLevelRowSpot> parkingLevelRowSpots) {
        this.parkingLevelRowSpots = parkingLevelRowSpots;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((parkingLevelRowSpots == null) ? 0 : parkingLevelRowSpots.hashCode());
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
        ParkingLevelRow other = (ParkingLevelRow) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (parkingLevelRowSpots == null) {
            if (other.parkingLevelRowSpots != null)
                return false;
        } else if (!parkingLevelRowSpots.equals(other.parkingLevelRowSpots))
            return false;
        return true;
    }

}
