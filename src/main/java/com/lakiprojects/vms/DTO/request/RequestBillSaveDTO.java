package com.lakiprojects.vms.DTO.request;

import com.lakiprojects.vms.entity.BillDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestBillSaveDTO {

    private int customer;
    private double totalPrice;
    private Date date;
    private List<RequestBillDetailSaveDTO> billDetails;
}
