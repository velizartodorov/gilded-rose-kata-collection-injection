package gilded.rose.kata.items;

import static gilded.rose.kata.items.BackstagePassItem.BACKSTAGE_PASS;
import static java.lang.Math.min;

import gilded.rose.kata.item_helpers.ItemType;
import org.springframework.stereotype.Component;

@Component(BACKSTAGE_PASS)
@SuppressWarnings("unused")
public class BackstagePassItem extends ItemType {

  public static final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

  @Override
  public String getName() {
    return BACKSTAGE_PASS;
  }

  @Override
  public String getParam() {
    return "BackstagePass";
  }

  @Override
  public void updateQuality() {
    decrementSellInDate();
    if (moreThan10DaysToSellIn()) {
      incrementQuality();
    } else if (lessThan10DaysToSellIn()) {
      incrementQualityBy2();
    } else if (lessThan5DaysToSellIn()) {
      incrementQualityBy3();
    } else {
      makeQualityZero();
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

  private boolean lessThan5DaysToSellIn() {
    return item.sellIn >= 0 && item.sellIn <= 5;
  }

  private boolean lessThan10DaysToSellIn() {
    return item.sellIn >= 5 && item.sellIn <= 10;
  }

  private boolean moreThan10DaysToSellIn() {
    return item.sellIn >= 10;
  }

  private void makeQualityZero() {
    item.quality = 0;
  }

  private void incrementQuality() {
    item.quality = min(item.quality + 1, QUALITY_LIMIT);
  }

  private void incrementQualityBy2() {
    item.quality = min(item.quality + 2, QUALITY_LIMIT);
  }

  private void incrementQualityBy3() {
    item.quality = min(item.quality + 3, QUALITY_LIMIT);
  }

}
