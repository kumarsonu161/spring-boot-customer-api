package com.customer.customer.controller;

import com.customer.customer.dto.CustomerDTO;
import com.customer.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO dto) {
        return service.createCustomer(dto);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO dto) {
        return service.updateCustomer(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}