package com.szau.notification;

import com.szau.clients.NotificationRequest;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {

  private final NotificationRepository notificationRepository;

  public void send(NotificationRequest notificationRequest){

    Notification notification = Notification.builder()
        .toCustomerId(notificationRequest.toCustomerId())
        .toCustomerEmail(notificationRequest.toCustomerName())
        .sender("Szau")
        .message(notificationRequest.message())
        .sentAt(LocalDateTime.now())
        .build();

    notificationRepository.save(notification);
    log.info("[LOGGING of NOTIFICATION]: \n" + notification.toString());
  }

  public List<Notification> getNotifications() {
   return notificationRepository.findAll();
  }
}
