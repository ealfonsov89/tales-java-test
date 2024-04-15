package com.tales.restapi.dto;

import com.tales.restapi.entity.VehicleType;

public class VehicleDto {
    private long id;
    private VehicleType vehicleType;

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
}
