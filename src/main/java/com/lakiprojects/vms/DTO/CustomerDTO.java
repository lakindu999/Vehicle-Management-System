package com.lakiprojects.vms.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerDTO {

    private int customerID;
    private String customerName;
    private String customerAddress;
    private ArrayList contactNumber;
    private boolean activeStatus;
}
