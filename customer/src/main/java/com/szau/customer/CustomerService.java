package com.szau.customer;


import java.net.URI;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final RestTemplate restTemplate;

  public void registerCustomer(CustomerRegistrationRequest req) {
    Customer customer = Customer.builder()
        .firstName(req.getFirstName())
        .lastName(req.getLastName())
        .email(req.getEmail()).
        build();

    customerRepository.saveAndFlush(customer);

    //todo: check ifFraudster
    FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
        "http://localhost:8081/api/v1/fraud/{customerId}",
        FraudCheckResponse.class, customer.getId());

   // assert fraudCheckResponse != null;
    if (fraudCheckResponse.getIsFraudster()) {
      throw new IllegalStateException("fraudster");
    }

    //todo: send Notification
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }
}
