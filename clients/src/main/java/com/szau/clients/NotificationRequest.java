package com.szau.clients;

public record NotificationRequest (Integer toCustomerId,
    String toCustomerName,
    String message
) {
    }