package com.tales.restapi.dto;

import java.util.List;

import com.tales.restapi.entity.VehicleType;

public class AddVehicleDto {
    private long id;
    private VehicleType vehicleType;
    private Long parkingId;
    private Long levelId;
    private List<SpotDto> spots;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getParkingId() {
        return parkingId;
    }

    public void setParkingId(Long parkingId) {
        this.parkingId = parkingId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public List<SpotDto> getSpots() {
        return spots;
    }

    public void setSpots(List<SpotDto> spots) {
        this.spots = spots;
    }

}
