package com.tales.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ParkingLevelRowSpot {
    private @Id @GeneratedValue Long id;
    private SpotSize spotSize;
    private boolean isOccupied;
    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingLevelRowSpot() {
    }

    public ParkingLevelRowSpot(SpotSize spotSize, boolean isOccupied) {
        this.spotSize = spotSize;
        this.isOccupied = isOccupied;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SpotSize getSpotSize() {
        return spotSize;
    }

    public void setSpotSize(SpotSize spotSize) {
        this.spotSize = spotSize;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((spotSize == null) ? 0 : spotSize.hashCode());
        result = prime * result + (isOccupied ? 1231 : 1237);
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
        ParkingLevelRowSpot other = (ParkingLevelRowSpot) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (spotSize != other.spotSize)
            return false;
        if (isOccupied != other.isOccupied)
            return false;
        return true;
    }

}