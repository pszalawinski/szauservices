package com.szau.hashMapInterfaces;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class Controller {

  LocatorElements locatorElements;
  LocatorElements locatorElementsWrapped;

  public LocatorElements wrapLocators() {
    locatorElementsWrapped.wrapLocator((locator, locatorElement) ->
        locatorElement.builder().wrap("wrapped").build());

    return locatorElementsWrapped;
  }

  @GetMapping
  public Map<Integer, String> getLocators() {

    String jeden = String.valueOf(locatorElements.getLocatorElement(Locator.LOCATOR1));
    String dwa = String.valueOf(wrapLocators().getLocatorElement(Locator.LOCATOR2));

    Map<Integer, String> lista = new HashMap<>();
    lista.put(1, jeden);
    lista.put(2, dwa);
    return lista;
  }


}
