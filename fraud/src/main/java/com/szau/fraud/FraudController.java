package com.szau.fraud;

import com.szau.clients.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud/")
@AllArgsConstructor
@Slf4j
public class FraudController {

  private final FraudCheckService fraudCheckService;

  @GetMapping(path = "{customerId}")
  public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
    log.info("begginig checking if customer with id: " + customerId + " is fraud.");
    return new FraudCheckResponse(fraudCheckService.isFraudulentCustomer(customerId));

  }

}
