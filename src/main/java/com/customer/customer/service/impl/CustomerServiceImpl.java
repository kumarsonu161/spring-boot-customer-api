package com.customer.customer.service.impl;

import com.customer.customer.dto.CustomerDTO;
import com.customer.customer.entity.Customer;
import com.customer.customer.repository.CustomerRepository;
import com.customer.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        return convertToDTO(customer);
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO dto) {
        Customer customer = new Customer(dto.getName(), dto.getEmail(), dto.getPhone(), dto.getCity());
        Customer saved = repository.save(customer);
        return convertToDTO(saved);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO dto) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setCity(dto.getCity());
        Customer updated = repository.save(customer);
        return convertToDTO(updated);
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    private CustomerDTO convertToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setCity(customer.getCity());
        return dto;
    }
}