import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import strategies.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static strategies.GoldQualityStrategy.GOLD_MAXIMUM_QUALITY;
import static strategies.QualityStrategy.MAXIMUM_QUALITY;
import static strategies.QualityStrategy.MINIMUM_QUALITY;

public class InventorySystemTest {

    public static final int NIGHTS = 100;

    @Before
    public void setUp() throws Exception {
        ArrayList<StrategyItem> items = new ArrayList<StrategyItem>();
        items.add(new StrategyItem("School Uniform", 10, 20, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Wine", 2, 0, new WineQualityStrategy()));
        items.add(new StrategyItem("Poultry", 5, 7, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Gold", 0, 80, new GoldQualityStrategy()));
        items.add(new StrategyItem("Concert Ticket", 15, 20, new ConcertTicketQualityStrategy()));
        items.add(new StrategyItem("Chocolate Eclair", 3, 6, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Fresh Baked Bread", 12, 32, new FreshBackedBreadQualityStrategy()));
        InventorySystem.setItems(items);
    }

    @Test
    public void testQualityShouldNotBeNeverNegative() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            InventorySystem.updateQuality();
        }
        for (StrategyItem item : InventorySystem.getItems()) {
            Assert.assertTrue(item.getQuality() >= MINIMUM_QUALITY);
        }
    }

    @Test
    public void testQualityShouldNotBeBiggerThanSpecified() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            InventorySystem.updateQuality();
        }
        for (StrategyItem item : InventorySystem.getItems()) {
            if (item.getStrategy() instanceof GoldQualityStrategy) {
                Assert.assertTrue(item.getQuality() <= GOLD_MAXIMUM_QUALITY);
            } else {
                Assert.assertTrue(item.getQuality() <= MAXIMUM_QUALITY);
            }
        }
    }

    @Test
    public void testWineShouldIncreaseInQualityTheOlderItIs() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            int prevQuality = 0;
            for (StrategyItem item : InventorySystem.getItems()) {
                if (item.getStrategy() instanceof WineQualityStrategy) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (StrategyItem item : InventorySystem.getItems()) {
                if (item.getStrategy() instanceof WineQualityStrategy) {
                    Assert.assertTrue(prevQuality < item.getQuality() || item.getQuality() == MAXIMUM_QUALITY);
                    break;
                }
            }
        }
    }

    @Test
    public void testGoldShouldNotDecreaseInQualityAndNeverHasToBeSold() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            int prevQuality = 0;
            for (StrategyItem item : InventorySystem.getItems()) {
                if (item.getStrategy() instanceof GoldQualityStrategy) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (StrategyItem item : InventorySystem.getItems()) {
                if (item.getStrategy() instanceof GoldQualityStrategy) {
                    Assert.assertTrue(item.getQuality() >= prevQuality);
                    Assert.assertTrue(0 == item.getSellIn());
                    break;
                }
            }
        }
    }

    @Test
    public void testConcertTicketShouldIncreaseInQuality() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            int prevQuality = 0;

            for (StrategyItem item : InventorySystem.getItems()) {
                if (item.getStrategy() instanceof ConcertTicketQualityStrategy) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (StrategyItem item : InventorySystem.getItems()) {
                if (item.getStrategy() instanceof ConcertTicketQualityStrategy) {
                    if (item.getSellIn() < 0) {
                        Assert.assertTrue(item.getQuality() == MINIMUM_QUALITY);
                    } else if (item.getSellIn() < 5) {
                        Assert.assertTrue(item.getQuality() == prevQuality + 3);
                    } else if (item.getSellIn() < 10) {
                        Assert.assertTrue(item.getQuality() == prevQuality + 2);
                    } else {
                        Assert.assertTrue(item.getQuality() == prevQuality + 1);
                    }
                }
            }
        }
    }

    @Test
    public void testFreshBakedBreadShouldDecreaseInQuality() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            int prevQuality = 0;

            for (StrategyItem item : InventorySystem.getItems()) {
                if (item.getStrategy() instanceof FreshBackedBreadQualityStrategy) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (StrategyItem item : InventorySystem.getItems()) {
                if (item.getStrategy() instanceof FreshBackedBreadQualityStrategy) {
                    if (item.getSellIn() < 0) {
                        Assert.assertTrue(item.getQuality() == MINIMUM_QUALITY || item.getQuality() == prevQuality - 4);
                    } else {
                        Assert.assertTrue(item.getQuality() == MINIMUM_QUALITY || item.getQuality() == prevQuality - 2);
                    }
                }
            }
        }
    }

    @Test
    public void testOnceTheSellByDateHasPassed() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            List<StrategyItem> prevItems = new ArrayList<StrategyItem>();
            for (StrategyItem item : InventorySystem.getItems()) {
                try {
                    prevItems.add(item.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
            InventorySystem.updateQuality();
            for (StrategyItem item : InventorySystem.getItems()) {
                if (item.getStrategy().getClass().equals(SimpleQualityStrategy.class) && item.getSellIn() < 0) {
                    for (StrategyItem prevItem : prevItems) {
                        if (item.getName().equals(prevItem.getName())) {
                            Assert.assertTrue(item.getQuality() == MINIMUM_QUALITY
                                || item.getQuality() == prevItem.getQuality() - 2);
                        }
                    }
                }
            }
        }
    }
}
