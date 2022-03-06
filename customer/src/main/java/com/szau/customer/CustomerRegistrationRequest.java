package com.szau.customer;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email

) {

}
