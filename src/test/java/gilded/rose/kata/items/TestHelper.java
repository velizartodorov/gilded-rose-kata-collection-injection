package gilded.rose.kata.items;

import static gilded.rose.kata.item_helpers.ItemType.OUT_OF_BOUND_QUALITY_MESSAGE;
import static gilded.rose.kata.item_helpers.ItemType.QUALITY_ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gilded.rose.kata.main.GildedRose;
import gilded.rose.kata.main.Item;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class TestHelper {

  @Autowired
  protected GildedRose gildedRose;

  void testItem
      (Item item,
          int daysToPass,
          int expectedSellIn,
          int expectedQuality
      ) {
    Item[] items = new Item[1];
    items[0] = item;
    gildedRose.loadItems(items);
    for (int i = 0; i < daysToPass; i++) {
      gildedRose.updateQuality();
    }
    assertEquals(expectedSellIn, item.sellIn);
    assertEquals(expectedQuality, item.quality);
  }

  void testItemException(Item item) {
    checkItemForExceptionMessage(item, QUALITY_ERROR_MESSAGE);
  }

  void testItemQualityAboveLimitException(Item item) {
    checkItemForExceptionMessage(item, OUT_OF_BOUND_QUALITY_MESSAGE);
  }

  void checkItemForExceptionMessage(Item item, String message) {
    Item[] items = new Item[1];
    items[0] = item;
    gildedRose.loadItems(items);
    Exception exception = assertThrows(IllegalArgumentException.class, gildedRose::updateQuality);
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(message));
  }

}
