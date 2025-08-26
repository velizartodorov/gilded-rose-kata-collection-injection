package gilded.rose.kata.controllers;

import gilded.rose.kata.item_helpers.ItemType;
import gilded.rose.kata.items.AgedBrieItem;
import gilded.rose.kata.items.BackstagePassItem;
import gilded.rose.kata.items.ConjuredItem;
import gilded.rose.kata.items.LegendaryItem;
import gilded.rose.kata.items.NormalItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

  @SuppressWarnings("unused")
  @GetMapping("/item")
  public String getItemByName(@RequestParam String name) {
    return "You requested item: " + getItem(name).getName();
  }

  @GetMapping
  public ItemType getItem(@RequestParam String item) {
    return switch (item) {
      case "AgedBrie" -> new AgedBrieItem();
      case "Sulfuras" -> new LegendaryItem();
      case "BackstagePass" -> new BackstagePassItem();
      case "Conjured" -> new ConjuredItem();
      default -> new NormalItem();
    };
  }
}