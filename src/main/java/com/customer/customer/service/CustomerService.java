package com.customer.customer.service;

import com.customer.customer.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createCustomer(CustomerDTO dto);
    CustomerDTO updateCustomer(Long id, CustomerDTO dto);
    void deleteCustomer(Long id);
}