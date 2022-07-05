package com.szau.customer;


import com.szau.clients.FraudCheckResponse;
import com.szau.clients.FraudClient;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final RestTemplate restTemplate;
  private final FraudClient fraudClient;

  public void registerCustomer(CustomerRegistrationRequest req) {
    Customer customer = Customer.builder()
        .firstName(req.getFirstName())
        .lastName(req.getLastName())
        .email(req.getEmail()).
        build();

    customerRepository.saveAndFlush(customer);

    FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

    if (fraudCheckResponse.isFraudster()) {
      throw new IllegalStateException("fraudster");
    }

    //todo: send Notification
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }
}
