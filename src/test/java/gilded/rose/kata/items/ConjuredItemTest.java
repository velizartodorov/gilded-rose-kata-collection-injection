package gilded.rose.kata.items;

import gilded.rose.kata.main.Item;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class ConjuredItemTest extends TestHelper {

  public static final String CONJURED = "Conjured Mana Cake";

  Item item = new Item(CONJURED, 5, 20);
  Item itemError = new Item(CONJURED, 10, -5);
  Item itemAboveLimitQuality = new Item(CONJURED, 10, 60);

  @Test
  @Order(1)
  void decrementQualityByTwoSuccess() {
    testItem(item, 2, 3, 16);
  }

  @Test
  @Order(2)
  void decrementQualityByFourSuccess() {
    testItem(item, 10, -5, 0);
  }

  @Test
  @Order(3)
  void negativeQualityFail() {
    testItemException(itemError);
  }

  @Test
  @Order(4)
  void QualityAboveLimitFail() {
    testItemQualityAboveLimitException(itemAboveLimitQuality);
  }
}
