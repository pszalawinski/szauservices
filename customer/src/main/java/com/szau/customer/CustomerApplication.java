package com.szau.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.szau.customer", "com.szau.amqp"})
@EnableEurekaClient
@EnableFeignClients(
    basePackages = "com.szau.clients"
)
public class CustomerApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerApplication.class,args);
  }

}
