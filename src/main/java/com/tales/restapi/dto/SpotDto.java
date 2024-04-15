package com.tales.restapi.dto;

import com.tales.restapi.entity.SpotSize;

public class SpotDto {
    private long id;
    private SpotSize spotSize;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public SpotSize getSpotSize() {
        return spotSize;
    }

    public void setSpotSize(SpotSize spotSize) {
        this.spotSize = spotSize;
    }
}
