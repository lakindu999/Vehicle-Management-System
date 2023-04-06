package com.lakiprojects.vms.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class VehicleUpdateDTO {

    private long vehicleID;
    private String vehicleName;
    private String vehicleBrand;
    private String fuelType;
    private String transmissionType;
    private String vehicleType;
    private int numberOfSeats;

}
