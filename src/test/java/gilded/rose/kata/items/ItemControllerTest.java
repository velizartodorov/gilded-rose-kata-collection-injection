package gilded.rose.kata.items;

import static org.junit.jupiter.api.Assertions.assertEquals;

import gilded.rose.kata.controllers.ItemController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ItemControllerTest {

  @Autowired
  ItemController controller;

  @Test
  void returnsNormal_whenUnknown() {
    assertEquals("You requested item: Normal",
        controller.getItemByName("Backstage"));
  }

  @Test
  void returnsBackstagePass() {
    assertEquals("You requested item: Backstage passes to a TAFKAL80ETC concert",
        controller.getItemByName("BackstagePass"));
  }

  @Test
  void returnsSulfuras() {
    assertEquals("You requested item: Sulfuras, Hand of Ragnaros",
        controller.getItemByName("Sulfuras"));
  }

  @Test
  void returnsAgedBrie() {
    assertEquals("You requested item: Aged Brie",
        controller.getItemByName("AgedBrie"));
  }

  @Test
  void returnsConjured() {
    assertEquals("You requested item: Conjured Mana Cake",
        controller.getItemByName("Conjured"));
  }

  @Test
  void returnsNormal() {
    assertEquals("You requested item: Normal",
        controller.getItemByName("Normal"));
  }

  @Test
  void matchingIsCaseInsensitive() {
    assertEquals("You requested item: Sulfuras, Hand of Ragnaros",
        controller.getItemByName("sulfuras"));
    assertEquals("You requested item: Aged Brie",
        controller.getItemByName("AGEDBRIE"));
    assertEquals("You requested item: Conjured Mana Cake",
        controller.getItemByName("conjured"));
  }

  @Test
  void unknownFallsBackToCurrentNormalItemName() {
    String expected = "You requested item: " + new NormalItem().getName();
    assertEquals(expected, controller.getItemByName("FooBarBaz"));
  }
}