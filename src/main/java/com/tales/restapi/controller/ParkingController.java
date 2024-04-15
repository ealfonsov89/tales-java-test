package com.tales.restapi.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tales.restapi.dto.AddVehicleDto;
import com.tales.restapi.dto.ParkingCompleteStatusDto;
import com.tales.restapi.dto.ParkingDto;
import com.tales.restapi.dto.ParkingStatisticsDto;
import com.tales.restapi.entity.Parking;
import com.tales.restapi.entity.Vehicle;
import com.tales.restapi.service.ParkingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping("add")
    public ParkingDto postMethodName(@RequestBody Parking entity) {
        return parkingService.add(entity);
    }

    @GetMapping("complete-status/{id}")
    public List<ParkingCompleteStatusDto> getCompleteStatus(@PathVariable Long id) {
        return parkingService.getCompleteStatus(id);
    }

    @GetMapping("statistics/{id}")
    public ParkingStatisticsDto getStatistics(@PathVariable Long id) {
        return parkingService.getStatistics(id);
    }

    @PostMapping("add-vehicle/{id}")
    public AddVehicleDto addVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id) {

        return parkingService.addVehicle(vehicle, id);
    }

    @PutMapping("chenge-spot")
    public String postMethodName(@RequestBody Vehicle vehicle) {
        return parkingService.changeSpot(vehicle);
    }

    @DeleteMapping("remove-vehicle/{vehicleId}")
    public String removeVehicle(@PathVariable Long vehicleId) {
        return parkingService.removeVehicle(vehicleId);
    }

}
