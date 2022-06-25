package com.szau.hashMapInterfaces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum Locator {

  LOCATOR1(LocatorElement.builder().name("locator-jeden").number(1).build()),
  LOCATOR2(LocatorElement.builder().name("locator-dwa").number(2).build()),
  LOCATOR3(LocatorElement.builder().name("locator-trzy").build());

  private final LocatorElement defaultLocatorElement;

}
