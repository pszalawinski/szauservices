package com.szau.customer;


import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public record CustomerController(CustomerService customerService) {

  @PostMapping("/register")
  public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
    log.info("New customer registration {}", customerRegistrationRequest);
    customerService.registerCustomer(customerRegistrationRequest);
  }

  @GetMapping
  public List<Customer> getAllCustomers(){
    return customerService.getAllCustomers();
  }
}
