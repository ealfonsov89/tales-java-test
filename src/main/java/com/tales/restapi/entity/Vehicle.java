package com.tales.restapi.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

    private @Id @GeneratedValue Long id;
    private VehicleType vehicleType;
    private SpotSize minimunSpotSize;
    private int spotsNeeded;

    private final List<ParkingLevelRowSpot> parkingLevelRowSpots = new ArrayList<ParkingLevelRowSpot>();

    public Vehicle() {
    }

    public Vehicle(VehicleType vehicleType, SpotSize minimunSpotSize, int spotsNeeded) {
        this.vehicleType = vehicleType;
        this.minimunSpotSize = minimunSpotSize;
        this.spotsNeeded = spotsNeeded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public SpotSize getMinimunSpotSize() {
        return minimunSpotSize;
    }

    public void setMinimunSpotSize(SpotSize minimunSpotSize) {
        this.minimunSpotSize = minimunSpotSize;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public void setSpotsNeeded(int spotsNeeded) {
        this.spotsNeeded = spotsNeeded;
    }

    public List<ParkingLevelRowSpot> getParkingLevelRowSpots() {
        return parkingLevelRowSpots;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((vehicleType == null) ? 0 : vehicleType.hashCode());
        result = prime * result + ((minimunSpotSize == null) ? 0 : minimunSpotSize.hashCode());
        result = prime * result + spotsNeeded;
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
        Vehicle other = (Vehicle) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (vehicleType != other.vehicleType)
            return false;
        if (minimunSpotSize != other.minimunSpotSize)
            return false;
        if (spotsNeeded != other.spotsNeeded)
            return false;
        if (parkingLevelRowSpots == null) {
            if (other.parkingLevelRowSpots != null)
                return false;
        } else if (!parkingLevelRowSpots.equals(other.parkingLevelRowSpots))
            return false;
        return true;
    }

}
