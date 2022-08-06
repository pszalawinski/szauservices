package com.szau.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
    name = "notification",
    url= "${clients.notification.url}"
)
public interface NotificationClient {

  @PostMapping()
  void sendNotification(NotificationRequest notificationRequest);
}