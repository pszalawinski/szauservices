package com.szau.fraud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi/fraud-check")
@AllArgsConstructor
public class FraudController {

  private final FraudCheckService fraudCheckService;

  @GetMapping(path = "{customerId}")
  public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {

    return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));

  }

}
