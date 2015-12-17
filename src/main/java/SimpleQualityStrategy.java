/**
 * Created by Marcin on 2015-12-17.
 */
public class SimpleQualityStrategy implements QualityStrategy {

    @Override
    public int countNewQuality(int sellIn, int quality) {
        return quality - 1;
    }
}
