package com.lakiprojects.vms.service;

import com.lakiprojects.vms.DTO.VehicleDTO;

import java.util.List;

public interface VehicleService {
    String saveVehicle(VehicleDTO vehicleDTO);

    void deleteVehicle(long vehicleId);

    VehicleDTO searchVehicle(long vehicleId);

    void updateVehicle(VehicleDTO vehicleDTO);

    List<VehicleDTO> getAllVehicles();
}
