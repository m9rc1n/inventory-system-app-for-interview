/**
 * Created by Marcin on 2015-12-17.
 */
public class StrategyItem extends Item {

    private QualityStrategy strategy;

    public StrategyItem(String name, int sellIn, int quality, QualityStrategy strategy) {
        super(name, sellIn, quality);
        this.strategy = strategy;
    }

    public QualityStrategy getStrategy() {
        return strategy;
    }
}
