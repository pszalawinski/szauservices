package com.szau.hashMapInterfaces;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class LocatorElements {

  private Map<Locator, LocatorElement> locatorElementMap = new HashMap<>();

  public LocatorElement getLocatorElement(Locator locator) {
    return locatorElementMap.get(locator);
  }

  public Map<Locator, LocatorElement> wrapLocator(BiFunction<Locator, LocatorElement, LocatorElement> locatorFunction) {
    return locatorElementMap.entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey,
            entry -> locatorFunction.apply(entry.getKey(), entry.getValue())));
  }

  public LocatorElements() {
    Stream.of(Locator.values())
        .forEach(locator -> locatorElementMap.put(locator, locator.getDefaultLocatorElement()));
  }

}
