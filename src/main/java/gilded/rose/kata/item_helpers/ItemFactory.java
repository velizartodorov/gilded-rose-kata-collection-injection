package gilded.rose.kata.item_helpers;

import gilded.rose.kata.items.NormalItem;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemFactory {

  private final Map<String, ItemType> itemTypes;

  public ItemType getItemType(String name) {
    return itemTypes.getOrDefault(name, new NormalItem());
  }
}