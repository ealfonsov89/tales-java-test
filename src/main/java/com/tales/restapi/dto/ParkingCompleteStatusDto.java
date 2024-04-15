package com.tales.restapi.dto;

import com.tales.restapi.entity.SpotSize;
import com.tales.restapi.entity.VehicleType;

public class ParkingCompleteStatusDto {
    private long spotId;
    private SpotSize spotSize;
    private boolean isOccupied;
    private long rowId;
    private long levelId;
    private long vehicleId;
    private VehicleType vehicleType;

    public long getSpotId() {
        return spotId;
    }

    public void setSpotId(long spotId) {
        this.spotId = spotId;
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

    public long getRowId() {
        return rowId;
    }

    public void setRowId(long rowId) {
        this.rowId = rowId;
    }

    public long getLevelId() {
        return levelId;
    }

    public void setLevelId(long levelId) {
        this.levelId = levelId;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
