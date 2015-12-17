package strategies;

/**
 * Created by Marcin on 2015-12-17.
 */
public interface QualityStrategy {

    int MINIMUM_QUALITY = 0;

    int MAXIMUM_QUALITY = 50;

    int countNewQuality(int sellIn, int quality);

    int countNewSellIn(int sellIn);
}
