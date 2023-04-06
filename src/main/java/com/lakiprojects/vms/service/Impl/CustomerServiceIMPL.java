package com.lakiprojects.vms.service.Impl;

import com.lakiprojects.vms.DTO.CustomerDTO;
import com.lakiprojects.vms.entity.Customer;
import com.lakiprojects.vms.exception.NotFoundException;
import com.lakiprojects.vms.repository.CustomerRepo;
import com.lakiprojects.vms.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO,Customer.class);
        customerRepo.save(customer);
        return (customerDTO.getCustomerName() + "Saved as Customer");
    }

    @Override
    public void deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
        }
        else {
            throw new NotFoundException("No Customer Found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        if (customers.size()>0){
            List<CustomerDTO> listCustomerDTO = modelMapper.map(customers,new TypeToken<List<CustomerDTO>>(){}.getType());
        return listCustomerDTO;
        }
        else{
            throw new NotFoundException("No Customers Found");
        }
    }

    @Override
    public CustomerDTO searchCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
            return customerDTO;
        }
        else{
            throw new NotFoundException("No Customer for ID " + customerId);
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerID())){
            Customer customer = modelMapper.map(customerDTO,Customer.class);
            customerRepo.save(customer);
        }
        else {
            throw new NotFoundException("No Customer Found");
        }
    }

}
