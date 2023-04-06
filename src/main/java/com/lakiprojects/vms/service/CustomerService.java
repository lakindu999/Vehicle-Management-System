package com.lakiprojects.vms.service;

import com.lakiprojects.vms.DTO.CustomerDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);

    void deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomers();

    CustomerDTO searchCustomer(int customerId);

    void updateCustomer(CustomerDTO customerDTO);
}
