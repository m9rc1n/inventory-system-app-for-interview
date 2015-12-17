package strategies;

/**
 * Created by Marcin on 2015-12-17.
 */
public class GoldQualityStrategy extends SimpleQualityStrategy {

    public static final int GOLD_MAXIMUM_QUALITY = 80;

    @Override
    public int countNewQuality(int sellIn, int quality) {
        if (quality < MINIMUM_QUALITY) {
            return MINIMUM_QUALITY;
        } else if (quality < GOLD_MAXIMUM_QUALITY) {
            return quality;
        } else {
            return GOLD_MAXIMUM_QUALITY;
        }
    }

    @Override
    public int countNewSellIn(int sellIn) {
        return sellIn;
    }
}
