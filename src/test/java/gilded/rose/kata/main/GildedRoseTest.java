package gilded.rose.kata.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GildedRoseTest {

  @Autowired
  GildedRose gildedRose;

  @Test
  void foo() {
    Item[] items = new Item[]{new Item("foo", 0, 0)};
    gildedRose.loadItems(items);
    gildedRose.updateQuality();
    assertEquals("foo", gildedRose.items[0].name);
  }

}