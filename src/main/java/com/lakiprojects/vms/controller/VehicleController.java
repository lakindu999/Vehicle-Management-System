package com.lakiprojects.vms.controller;

import com.lakiprojects.vms.DTO.VehicleDTO;
import com.lakiprojects.vms.service.VehicleService;
import com.lakiprojects.vms.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ap1/v1/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveVehicle(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.saveVehicle(vehicleDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Successfully Saved",vehicleDTO), HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping(params = "id",path = "/delete")
    public  ResponseEntity<StandardResponse> deleteVehicle(@RequestParam(value = "id") long vehicleId){
        vehicleService.deleteVehicle(vehicleId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted",vehicleId),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(params = "id",path = "/search")
    public ResponseEntity<StandardResponse> searchVehicle(@RequestParam(value = "id") long vehicleId){
        VehicleDTO vehicleDTO = vehicleService.searchVehicle(vehicleId);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted",vehicleDTO),HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(path = "/view-all")
    public ResponseEntity<StandardResponse> viewAllVehicles(){
        List<VehicleDTO> allVehicles = vehicleService.getAllVehicles();
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Vehicles viewed successfully",allVehicles),HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping(path = "/update")
    public  ResponseEntity<StandardResponse> updateVehicle(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.updateVehicle(vehicleDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted",vehicleDTO),HttpStatus.OK);
        return responseEntity;

    }
}
