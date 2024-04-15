package com.tales.restapi.dto;

import java.util.List;

public class ParkingStatisticsDto {
    private List<VehicleDto> Vehicles;
    private List<LevelDto> levels;

    public List<VehicleDto> getVehicles() {
        return Vehicles;
    }

    public void setVehicles(List<VehicleDto> vehicleAmount) {
        Vehicles = vehicleAmount;
    }

    public List<LevelDto> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelDto> levels) {
        this.levels = levels;
    }

}
