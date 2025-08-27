package gilded.rose.kata.items;

import static gilded.rose.kata.items.ConjuredItem.CONJURED_MANA_CAKE;
import static java.lang.Math.max;

import gilded.rose.kata.item_helpers.ItemType;
import org.springframework.stereotype.Component;

@Component(CONJURED_MANA_CAKE)
@SuppressWarnings("unused")
public class ConjuredItem extends ItemType {

  static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

  @Override
  public String getName() {
    return CONJURED_MANA_CAKE;
  }

  @Override
  public String getParam() {
    return "Conjured";
  }

  @Override
  public void updateQuality() {
    decrementSellInDate();
    if (beforeSellInDate()) {
      decrementQualityBy2();
    } else {
      decrementQualityBy4();
    }
  }

  @Override
  public void validateQuality() {
    if (qualityIsNegative(item)) {
      throw new IllegalArgumentException(QUALITY_ERROR_MESSAGE + item.quality);
    } else if (qualityIsAboveLimit(item)) {
      throw new IllegalArgumentException(OUT_OF_BOUND_QUALITY_MESSAGE + item.quality);
    }
  }

  private void decrementSellInDate() {
    item.sellIn--;
  }

  private boolean beforeSellInDate() {
    return item.sellIn >= 0;
  }

  private void decrementQualityBy2() {
    item.quality = max(item.quality - 2, 0);
  }

  private void decrementQualityBy4() {
    item.quality = max(item.quality - 4, 0);
  }

}
