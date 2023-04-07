package com.lakiprojects.vms.controller;

import com.lakiprojects.vms.DTO.request.RequestBillSaveDTO;
import com.lakiprojects.vms.service.BillService;
import com.lakiprojects.vms.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ap1/v1/bill")

public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveSport(@RequestBody RequestBillSaveDTO requestBillSaveDTO) {
        String id = billService.addBill(requestBillSaveDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Saved", id), HttpStatus.CREATED);
        return responseEntity;
    }
}
