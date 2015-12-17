import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class InventorySystemTest {

    public static final int NIGHTS = 100;

    @Test
    public void testJunit() {
        assertTrue(true);
    }

    @Before
    public void setUp() throws Exception {
        ArrayList<StrategyItem> items = new ArrayList<StrategyItem>();
        items.add(new StrategyItem("School Uniform", 10, 20, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Wine", 2, 0, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Poultry", 5, 7, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Gold", 0, 80, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Concert Ticket", 15, 20, new ConcertTicketQualityStrategy()));
        items.add(new StrategyItem("Chocolate Eclair", 3, 6, new SimpleQualityStrategy()));
        InventorySystem.setItems(items);
    }

    @Test
    public void testQualityShouldNotBeNeverNegative() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            InventorySystem.updateQuality();
        }
        for (StrategyItem item : InventorySystem.getItems()) {
            Assert.assertTrue(item.getQuality() >= 0);
        }
    }

    @Test
    public void testQualityShouldNotBeBiggerThanSpecified() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            InventorySystem.updateQuality();
        }
        for (StrategyItem item : InventorySystem.getItems()) {
            if ("Gold".equals(item.getName())) {
                Assert.assertTrue(item.getQuality() <= 80);
            } else {
                Assert.assertTrue(item.getQuality() <= 50);
            }
        }
    }

    @Test
    public void testWineShouldIncreaseInQualityTheOlderItIs() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            int prevQuality = 0;
            for (StrategyItem item : InventorySystem.getItems()) {
                if ("Wine".equals(item.getName())) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (StrategyItem item : InventorySystem.getItems()) {
                if ("Wine".equals(item.getName())) {
                    Assert.assertTrue(prevQuality < item.getQuality() || item.getQuality() == 50);
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
                if ("Gold".equals(item.getName())) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (StrategyItem item : InventorySystem.getItems()) {
                if ("Gold".equals(item.getName())) {
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
                if ("Concert Ticket".equals(item.getName())) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (StrategyItem item : InventorySystem.getItems()) {
                if ("Concert Ticket".equals(item.getName())) {
                    if (item.getSellIn() < 0) {
                        Assert.assertTrue(item.getQuality() == 0);
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
                if ("Freshly baked bread".equals(item.getName())) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (StrategyItem item : InventorySystem.getItems()) {
                if ("Freshly baked bread".equals(item.getName())) {
                    Assert.assertTrue(item.getQuality() == prevQuality + 2);
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
                if ("Wine".equals(item.getName())) continue;
                if ("Gold".equals(item.getName())) continue;
                if ("Concert Ticket".equals(item.getName())) continue;
                if (item.getSellIn() < 0) {
                    for (StrategyItem prevItem : prevItems) {
                        if (item.getName().equals(prevItem.getName())) {
                            Assert.assertTrue(item.getQuality() == 0 || item.getQuality() == prevItem.getQuality() - 2);
                        }
                    }
                }
            }
        }
    }
}
