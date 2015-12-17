package strategies;

/**
 * Created by Marcin on 2015-12-17.
 */
public class FreshBackedBreadQualityStrategy extends SimpleQualityStrategy {

    @Override
    public int countNewQuality(int sellIn, int quality) {
        if (quality > MAXIMUM_QUALITY) return MAXIMUM_QUALITY;
        int result;
        if (sellIn < 0) {
            result = quality - 4;
        } else {
            result = quality - 2;
        }
        return result > MINIMUM_QUALITY ? result : MINIMUM_QUALITY;
    }
}
