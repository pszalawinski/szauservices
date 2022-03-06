package com.szau.customer;


import java.util.List;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {


  public void registerCustomer(CustomerRegistrationRequest req) {
    Customer customer = Customer.builder()
        .firstName(req.firstName())
        .lastName(req.lastName())
            .email(req.email()).
        build();

    customerRepository.save(customer);
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }
}
