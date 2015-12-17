/**
 * Created by Marcin on 2015-12-17.
 */
public class SimpleQualityStrategy implements QualityStrategy {

    @Override
    public int countNewQuality(int sellIn, int quality) {
        return quality - 1;
    }

    @Override
    public int countNewSellIn(int sellIn) {
        return sellIn - 1;
    }
}
