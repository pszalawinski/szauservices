package com.szau.notification;

import com.szau.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.szau.notification", "com.szau.amqp"})
@EnableEurekaClient
public class NotificationApplication {

  public static void main(String[] args) {
    SpringApplication.run(NotificationApplication.class, args
    );
  }


/**  this allows to check if publishing to the chosen queue, with proper exchange and routing key works.
      It will send a message when the application will be starting up*/
//  @Bean
//  CommandLineRunner commandLineRunner(
//      RabbitMQMessageProducer producer,
//      NotificationConfig notificationConfig){
//    return args -> {
//      producer.publish(
//          "check check",
//          notificationConfig.getInternalExchange(),
//          notificationConfig.getInternalNotificationRoutingKey());
//    };
//  }
}