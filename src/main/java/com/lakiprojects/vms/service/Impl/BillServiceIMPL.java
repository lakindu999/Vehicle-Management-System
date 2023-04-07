package com.lakiprojects.vms.service.Impl;

import com.lakiprojects.vms.DTO.request.RequestBillSaveDTO;
import com.lakiprojects.vms.entity.Bill;
import com.lakiprojects.vms.entity.BillDetail;
import com.lakiprojects.vms.repository.BillDetailRepo;
import com.lakiprojects.vms.repository.BillRepo;
import com.lakiprojects.vms.repository.CustomerRepo;
import com.lakiprojects.vms.repository.VehicleRepo;
import com.lakiprojects.vms.service.BillService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BillServiceIMPL implements BillService {

    @Autowired
    private BillRepo billRepo;

    @Autowired
    private BillDetailRepo billDetailRepo;

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public String addBill(RequestBillSaveDTO requestBillSaveDTO) {
        Bill bill = new Bill(
                customerRepo.getReferenceById(requestBillSaveDTO.getCustomer()),
                requestBillSaveDTO.getTotalPrice(),
                requestBillSaveDTO.getDate()
        );
        billRepo.save(bill);

        if (billRepo.existsById(bill.getBillId())){
            List<BillDetail> billDetails =  modelMapper.map(requestBillSaveDTO,new TypeToken<List<BillDetail>>(){}.getType());
            for (int i=0;i<billDetails.size();i++){
                billDetails.get(i).setBill(bill);
                billDetails.get(i).setVehicle(vehicleRepo.getReferenceById(requestBillSaveDTO.getBillDetails().get(i).getVehicle()));
            }
            if (billDetails.size()>0){
                billDetailRepo.saveAll(billDetails);
            }
            return "Saved";

        }
        return null;
    }

}
