package com.tales.restapi.dto;

import java.util.List;

public class LevelDto {
    private long id;
    private List<VehicleDto> vehicles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<VehicleDto> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDto> vehicles) {
        this.vehicles = vehicles;
    }

}
