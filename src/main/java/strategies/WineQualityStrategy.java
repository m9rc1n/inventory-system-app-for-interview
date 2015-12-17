package strategies;

/**
 * Created by Marcin on 2015-12-17.
 */
public class WineQualityStrategy extends SimpleQualityStrategy {

    @Override
    public int countNewQuality(int sellIn, int quality) {
        if (quality < MAXIMUM_QUALITY) {
            return quality + 1;
        } else {
            return quality;
        }
    }
}
