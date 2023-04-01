package com.lakiprojects.vms.service.Impl;

import com.lakiprojects.vms.DTO.VehicleDTO;
import com.lakiprojects.vms.entity.Vehicle;
import com.lakiprojects.vms.exception.NotFoundException;
import com.lakiprojects.vms.repository.VehicleRepo;
import com.lakiprojects.vms.service.VehicleService;
import com.lakiprojects.vms.util.mappers.VehicleMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceIMPL implements VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public String saveVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = modelMapper.map(vehicleDTO,Vehicle.class);
        vehicleRepo.save(vehicle);
        return "Vehicle Saved";
    }

    @Override
    public void deleteVehicle(long vehicleId) {
        if (vehicleRepo.existsById(vehicleId)) {
            vehicleRepo.deleteById(vehicleId);
        }
        else {
            throw new RuntimeException("Deleted Successfully");
        }
    }

    @Override
    public VehicleDTO searchVehicle(long vehicleId) {
        if (vehicleRepo.existsById(vehicleId)){
            Vehicle vehicle = vehicleRepo.getReferenceById(vehicleId);
            VehicleDTO vehicleDTO = modelMapper.map(vehicle,VehicleDTO.class);
            return vehicleDTO;
        }
        else {
            throw new NotFoundException("No Vehicle for ID " + vehicleId);
        }
    }

    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicleID())){
            Vehicle vehicle = modelMapper.map(vehicleDTO,Vehicle.class);
            vehicleRepo.save(vehicle);
        }
        else {
            throw new NotFoundException("No Vehicle Found");
        }

    }



    @Override
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepo.findAll();
        if (vehicles.size()>0){
            List<VehicleDTO> getAllVehicles = vehicleMapper.entityListToDTOList(vehicles);
            return getAllVehicles;
        }
        else {
            throw new NotFoundException("No Vehicles");
        }
    }
}
