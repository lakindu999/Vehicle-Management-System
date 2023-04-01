package com.lakiprojects.vms.util.mappers;

import com.lakiprojects.vms.DTO.VehicleDTO;
import com.lakiprojects.vms.entity.Vehicle;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    List<VehicleDTO> entityListToDTOList(List<Vehicle> vehicles);

}

