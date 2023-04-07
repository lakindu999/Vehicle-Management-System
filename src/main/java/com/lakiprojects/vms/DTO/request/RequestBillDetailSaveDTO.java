package com.lakiprojects.vms.DTO.request;

import com.lakiprojects.vms.entity.Bill;
import com.lakiprojects.vms.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RequestBillDetailSaveDTO {

    private int billDetailID;
    private long vehicle;
    private String vehicleName;
    private Bill bill;
}


