package com.szau.fraud;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FraudCheckService {

  private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

  public boolean isFraudulentCustomer(Integer customerId){
    fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
            .customerId(customerId)
            .createdAt(LocalDateTime.now())
        .isFraudster(false)

        .build());
    return false;
  }



}
