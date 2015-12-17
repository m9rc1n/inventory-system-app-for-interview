/**
 * Created by Marcin on 2015-12-17.
 */
public class ConcertTicketQualityStrategy implements QualityStrategy {

    @Override
    public int countNewQuality(int sellIn, int quality) {
        if (sellIn < 0) {
            return 0;
        } else if (sellIn < 5) {
            return quality + 3;
        } else if (sellIn < 10) {
            return quality + 2;
        } else if (quality < 50) {
            return quality + 1;
        } else {
            return quality;
        }
    }
}
