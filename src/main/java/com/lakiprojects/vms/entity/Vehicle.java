package com.lakiprojects.vms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Vehicle")

public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Vehicle_Id",length = 100)
    private long vehicleID;

    @Column(name = "Vehicle_Name",length = 100,nullable = false)
    private String vehicleName;

    @Column(name = "Vehicle_Brand",length = 100,nullable = false)
    private String vehicleBrand;

    @Column(name = "Vehicle_Type",length = 100,nullable = false)
    private String vehicleType;

    @Column(name = "Number_of_seats",length = 100,nullable = false)
    private int numberOfSeats;

}
