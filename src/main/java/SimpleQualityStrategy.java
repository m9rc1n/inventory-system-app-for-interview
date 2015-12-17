/**
 * Created by Marcin on 2015-12-17.
 */
public class SimpleQualityStrategy implements QualityStrategy {

    @Override
    public int countNewQuality(int sellIn, int quality) {
        int result;
        if (sellIn < 0) {
            result = quality - 2;
        } else {
            result = quality - 1;
        }
        return result > 0 ? result : 0;
    }

    @Override
    public int countNewSellIn(int sellIn) {
        return sellIn - 1;
    }
}
