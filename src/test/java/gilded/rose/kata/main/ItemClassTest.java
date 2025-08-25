package gilded.rose.kata.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ItemClassTest {

  private final Item item = new Item("foo", 5, 20);

  @Test
  void testItemSuccess() {
    assertEquals("foo", item.name);
    assertEquals(5, item.sellIn);
    assertEquals(20, item.quality);
    assertEquals("Item(name=foo, sellIn=5, quality=20)", item.toString());
  }

}
