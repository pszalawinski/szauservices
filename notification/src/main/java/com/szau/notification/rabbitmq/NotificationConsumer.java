package com.szau.notification.rabbitmq;

import com.szau.clients.NotificationRequest;
import com.szau.notification.Notification;
import com.szau.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationConsumer {

  private NotificationService notificationService;

  @RabbitListener(queues = "${rabbitmq.queue.notification}")
  public void consumer(NotificationRequest notificationRequest){
    log.info("Consumed {} from queue", notificationRequest);
    notificationService.send(notificationRequest);
  }

}
