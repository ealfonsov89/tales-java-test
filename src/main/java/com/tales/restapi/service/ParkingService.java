package com.tales.restapi.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tales.restapi.dto.AddVehicleDto;
import com.tales.restapi.dto.LevelDto;
import com.tales.restapi.dto.ParkingCompleteStatusDto;
import com.tales.restapi.dto.ParkingDto;
import com.tales.restapi.dto.ParkingStatisticsDto;
import com.tales.restapi.dto.VehicleDto;
import com.tales.restapi.entity.Parking;
import com.tales.restapi.entity.ParkingLevel;
import com.tales.restapi.entity.ParkingLevelRow;
import com.tales.restapi.entity.ParkingLevelRowSpot;
import com.tales.restapi.entity.Vehicle;
import com.tales.restapi.repository.ParkingRepository;

@Service
public class ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ParkingCompleteStatusDto> getCompleteStatus(Long id) {
        Optional<Parking> parking = parkingRepository.findById(id);

        if (parking.isPresent()) {
            List<ParkingCompleteStatusDto> parkingCompleteStatusDtos = new LinkedList<ParkingCompleteStatusDto>();
            parking.get().getLevels().forEach(level -> {
                level.getParkingLevelRows().forEach(row -> {
                    row.getParkingLevelRowSpots().forEach(spot -> {
                        ParkingCompleteStatusDto parkingCompleteStatusDto = new ParkingCompleteStatusDto();
                        parkingCompleteStatusDto.setSpotId(spot.getId());
                        parkingCompleteStatusDto.setSpotSize(spot.getSpotSize());
                        parkingCompleteStatusDto.setOccupied(spot.isOccupied());
                        parkingCompleteStatusDto.setRowId(row.getId());
                        parkingCompleteStatusDto.setLevelId(level.getId());
                        parkingCompleteStatusDto.setVehicleId(spot.getVehicle().getId());
                        parkingCompleteStatusDto.setVehicleType(spot.getVehicle().getVehicleType());

                        parkingCompleteStatusDtos.add(parkingCompleteStatusDto);
                    });
                });
            });
            return parkingCompleteStatusDtos;
        } else {
            throw new UnsupportedOperationException("Parking not found");
        }
    }

    public ParkingStatisticsDto getStatistics(Long id) {
        Optional<Parking> parking = parkingRepository.findById(id);
        if (parking.isPresent()) {
            ParkingStatisticsDto parkingStatisticsDto = new ParkingStatisticsDto();

            List<VehicleDto> vehicleDtos = getVehicleDtos(parking);
            parkingStatisticsDto.setVehicles(vehicleDtos);

            List<LevelDto> levelDtos = getLevelsDtos(parking);
            parkingStatisticsDto.setLevels(levelDtos);
            return parkingStatisticsDto;
        } else {
            throw new UnsupportedOperationException("Parking not found");
        }
    }

    private List<LevelDto> getLevelsDtos(Optional<Parking> parking) {
        List<LevelDto> levelDtos = new LinkedList<LevelDto>();
        parking.get().getLevels().forEach(level -> {
            LevelDto levelDto = new LevelDto();
            levelDto.setId(level.getId());
            List<VehicleDto> vehicleDtos = getVehicleDtos(parking);
            levelDto.setVehicles(vehicleDtos);
            levelDtos.add(levelDto);
        });
        return levelDtos;

    }

    private List<VehicleDto> getVehicleDtos(Optional<Parking> parking) {
        List<VehicleDto> vehicleDtos = new LinkedList<VehicleDto>();
        parking.get().getLevels().forEach(level -> {
            getVehicleDtosByLevelRow(level.getParkingLevelRows());
        });
        return vehicleDtos;
    }

    private List<VehicleDto> getVehicleDtosByLevelRow(List<ParkingLevelRow> parkingLevelRow) {
        List<VehicleDto> vehicleDtos = new LinkedList<VehicleDto>();
        parkingLevelRow.forEach(row -> {
            row.getParkingLevelRowSpots().forEach(spot -> {
                if (spot.isOccupied()) {
                    VehicleDto vehicleDto = new VehicleDto();
                    vehicleDto.setId(spot.getVehicle().getId());
                    vehicleDto.setVehicleType(spot.getVehicle().getVehicleType());
                    vehicleDtos.add(vehicleDto);
                }
            });
        });
        return vehicleDtos;
    }

    public AddVehicleDto addVehicle(Vehicle vehicle, Long parkingId) {
        Optional<Parking> parking = parkingRepository.findById(parkingId);

        if (parking.isPresent()) {
            for (ParkingLevel parkingLevel : parking.get().getLevels()) {
                for (ParkingLevelRow parkingLevelRow : parkingLevel.getParkingLevelRows()) {
                    int spotsNeeded = vehicle.getSpotsNeeded();
                    List<ParkingLevelRowSpot> spots = new LinkedList<ParkingLevelRowSpot>();
                    for (ParkingLevelRowSpot spot : parkingLevelRow.getParkingLevelRowSpots()) {
                        if (!spot.isOccupied()) {
                            spots.add(spot);
                            spotsNeeded--;
                        }
                        if (spotsNeeded == 0) {
                            break;
                        }
                    }
                    if (spotsNeeded == 0) {
                        spots.forEach(spot -> {
                            spot.setVehicle(vehicle);
                            spot.setOccupied(true);
                        });
                        AddVehicleDto addVehicleDto = new AddVehicleDto();
                        addVehicleDto.setId(vehicle.getId());
                        addVehicleDto.setSpotIds(spots.stream().map(spot -> spot.getId()).toArray(Long[]::new));
                        return addVehicleDto;
                    }
                }
            }
        } else {
            throw new UnsupportedOperationException("Parking not found");
        }
        throw new UnsupportedOperationException("No spots available");
    }

    public String changeSpot(Vehicle vehicle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeSpot'");
    }

    public String removeVehicle(Long vehicleId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeVehicle'");
    }

    public ParkingDto add(Parking entity) {
        Parking parking = parkingRepository.save(entity);
        ParkingDto parkingItem = modelMapper.map(parking, ParkingDto.class);
        return parkingItem;
    }

}
