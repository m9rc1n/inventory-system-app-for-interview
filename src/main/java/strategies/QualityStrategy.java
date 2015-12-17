package strategies;

/**
 * Created by Marcin on 2015-12-17.
 */
public interface QualityStrategy {

    int countNewQuality(int sellIn, int quality);

    int countNewSellIn(int sellIn);
}
