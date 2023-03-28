package com.lakiprojects.vms.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class VehicleDTO {

    private long vehicleID;
    private String vehicleName;
    private String vehicleBrand;
    private String vehicleType;
    private int numberOfSeats;
}
