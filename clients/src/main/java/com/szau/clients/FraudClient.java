package com.szau.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
   name = "fraud",
    path ="api/v1/fraud/",
    url= "${clients.fraud.url}"
)
public interface FraudClient {

  @GetMapping(path = "{customerId}")
  FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);

  }

