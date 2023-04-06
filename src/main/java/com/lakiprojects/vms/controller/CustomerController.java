package com.lakiprojects.vms.controller;

import com.lakiprojects.vms.DTO.CustomerDTO;
import com.lakiprojects.vms.DTO.VehicleDTO;
import com.lakiprojects.vms.service.CustomerService;
import com.lakiprojects.vms.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ap1/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Successfully Saved", customerDTO), HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping(params = "id",path = "/delete")
    public  ResponseEntity<StandardResponse> deleteCustomer(@RequestParam(value = "id") int customerId){
        customerService.deleteCustomer(customerId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted",customerId),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path = "/view-all")
    public ResponseEntity<StandardResponse> viewAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Customers viewed successfully",allCustomers),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(params = "id",path = "/search")
    public ResponseEntity<StandardResponse> searchCustomer(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.searchCustomer(customerId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted",customerDTO),HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping(path = "/update")
    public  ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted",customerDTO),HttpStatus.OK);
        return responseEntity;

    }

}
