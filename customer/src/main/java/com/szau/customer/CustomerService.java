package com.szau.customer;


import com.szau.amqp.RabbitMQConstants;
import com.szau.amqp.RabbitMQMessageProducer;
import com.szau.clients.FraudCheckResponse;
import com.szau.clients.FraudClient;
import com.szau.clients.NotificationClient;
import com.szau.clients.NotificationRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final FraudClient fraudClient;
  private final RabbitMQMessageProducer rabbitMQMessageProducer;

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

    NotificationRequest notificationRequest = new NotificationRequest(
        customer.getId(),
        customer.getEmail(),
        String.format("Hello %s !!!",
            customer.getFirstName()));

    rabbitMQMessageProducer.publish(
        notificationRequest, RabbitMQConstants.INTERNAL_EXCHANGE,
        RabbitMQConstants.NOTIFICATION_ROUTING_KEY);
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }
}
