package gilded.rose.kata.items;

import static gilded.rose.kata.items.AgedBrieItem.AGED_BRIE;
import static java.lang.Math.min;

import gilded.rose.kata.item_helpers.ItemType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component(AGED_BRIE)
@RequiredArgsConstructor
public class AgedBrieItem extends ItemType {

  static final String AGED_BRIE = "Aged Brie";

  @Override
  public String getName() {
    return AGED_BRIE;
  }

  @Override
  public void updateQuality() {
    decrementSellInDate();
    if (beforeSellInDate()) {
      incrementQuality();
    } else {
      incrementQualityBy2();
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

  private void incrementQuality() {
    item.quality = min(item.quality + 1, QUALITY_LIMIT);
  }

  private void incrementQualityBy2() {
    item.quality = min(item.quality + 2, QUALITY_LIMIT);
  }

  private void decrementSellInDate() {
    item.sellIn--;
  }

  private boolean beforeSellInDate() {
    return item.sellIn >= 0;
  }

}
