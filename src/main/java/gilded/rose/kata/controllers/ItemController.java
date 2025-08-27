package gilded.rose.kata.controllers;

import gilded.rose.kata.item_helpers.ItemFactory;
import gilded.rose.kata.items.NormalItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

  @Autowired
  ItemFactory itemFactory;

  @GetMapping("/item")
  public String getItemByName(@RequestParam String name) {
    return "You requested item: " + itemFactory.getItemTypes()
        .filter(item -> item.getParam().equalsIgnoreCase(name))
        .findFirst()
        .orElse(new NormalItem())
        .getName();
  }

}