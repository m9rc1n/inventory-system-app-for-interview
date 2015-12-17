package strategies;

/**
 * Created by Marcin on 2015-12-17.
 */
public class GoldQualityStrategy extends SimpleQualityStrategy {

    @Override
    public int countNewQuality(int sellIn, int quality) {
        if (quality < 0) {
            return 0;
        } else if (quality < 80) {
            return quality;
        } else {
            return 80;
        }
    }

    @Override
    public int countNewSellIn(int sellIn) {
        return sellIn;
    }
}
