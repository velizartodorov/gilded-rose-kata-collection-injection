package gilded.rose.kata.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gilded.rose.kata.item_helpers.ItemFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

  @Test
  void itemFactoryTestFail() {
    Exception exception = assertThrows(InvocationTargetException.class, () -> {
      Constructor<ItemFactory> constructor = ItemFactory.class.getDeclaredConstructor();
      constructor.setAccessible(true);
      constructor.newInstance();
    });
    String expectedMessage = "This is a utility class and cannot be instantiated";
    String actualMessage = exception.getCause().getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
  }

}