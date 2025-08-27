package gilded.rose.kata.controllers;

import gilded.rose.kata.item_helpers.ItemType;
import gilded.rose.kata.items.NormalItem;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

  private final List<ItemType> items;

  @GetMapping("/item")
  public String getItemByName(@RequestParam String name) {
    return "You requested item: " + items.stream()
        .filter(item -> item.getParam().equalsIgnoreCase(name))
        .findFirst()
        .orElse(new NormalItem())
        .getName();
  }

}