package gilded.rose.kata.items;

import static gilded.rose.kata.items.NormalItem.NORMAL;
import static java.lang.Math.max;

import gilded.rose.kata.item_helpers.ItemType;
import org.springframework.stereotype.Component;

@Component(NORMAL)
@SuppressWarnings("unused")
public class NormalItem extends ItemType {

  static final String NORMAL = "Normal";

  @Override
  public String getName() {
    return NORMAL;
  }

  @Override
  public String getParam() {
    return NORMAL;
  }

  @Override
  public void updateQuality() {
    decrementSellInDate();
    if (beforeSellInDate()) {
      decrementQuality();
    } else {
      decrementQualityBy2();
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

  private void decrementQuality() {
    item.quality = max(item.quality - 1, 0);
  }

  private void decrementQualityBy2() {
    item.quality = max(item.quality - 2, 0);
  }

}