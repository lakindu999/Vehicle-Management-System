package com.lakiprojects.vms.service.Impl;

import com.lakiprojects.vms.DTO.VehicleDTO;
import com.lakiprojects.vms.entity.Vehicle;
import com.lakiprojects.vms.repository.VehicleRepo;
import com.lakiprojects.vms.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceIMPL implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = modelMapper.map(vehicleDTO,Vehicle.class);
        vehicleRepo.save(vehicle);
        return "Saved";
    }
}
