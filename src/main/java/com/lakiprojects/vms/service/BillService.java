package com.lakiprojects.vms.service;

import com.lakiprojects.vms.DTO.request.RequestBillSaveDTO;

public interface BillService {
    String addBill(RequestBillSaveDTO requestBillSaveDTO);
}
