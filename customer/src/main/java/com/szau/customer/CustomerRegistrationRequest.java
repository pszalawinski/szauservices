package com.szau.customer;

import javax.persistence.Entity;
import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class CustomerRegistrationRequest {


  String firstName;
  String lastName;
  String email;

}
