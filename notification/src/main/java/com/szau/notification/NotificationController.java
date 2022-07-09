package com.szau.notification;

import com.szau.clients.NotificationRequest;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
@Slf4j
public class NotificationController {

  private final NotificationService notificationService;

  @PostMapping(path = "notification")
  public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
    log.info("New notification... {}", notificationRequest);
    notificationService.send(notificationRequest);
  }

  @GetMapping(path="notifications")
  public List<Notification> getNotifications(){
    return notificationService.getNotifications();
  }
}