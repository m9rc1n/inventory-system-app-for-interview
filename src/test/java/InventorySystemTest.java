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
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("School Uniform", 10, 20));
        items.add(new Item("Wine", 2, 0));
        items.add(new Item("Poultry", 5, 7));
        items.add(new Item("Gold", 0, 80));
        items.add(new Item("Concert Ticket", 15, 20));
        items.add(new Item("Chocolate Eclair", 3, 6));
        InventorySystem.setItems(items);
    }

    @Test
    public void testQualityShouldNotBeNeverNegative() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            InventorySystem.updateQuality();
        }
        for (Item item : InventorySystem.getItems()) {
            Assert.assertTrue(item.getQuality() >= 0);
        }
    }

    @Test
    public void testQualityShouldNotBeBiggerThanSpecified() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            InventorySystem.updateQuality();
        }
        for (Item item : InventorySystem.getItems()) {
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
            for (Item item : InventorySystem.getItems()) {
                if ("Wine".equals(item.getName())) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (Item item : InventorySystem.getItems()) {
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
            for (Item item : InventorySystem.getItems()) {
                if ("Gold".equals(item.getName())) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (Item item : InventorySystem.getItems()) {
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

            for (Item item : InventorySystem.getItems()) {
                if ("Concert Ticket".equals(item.getName())) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (Item item : InventorySystem.getItems()) {
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

            for (Item item : InventorySystem.getItems()) {
                if ("Freshly baked bread".equals(item.getName())) {
                    prevQuality = item.getQuality();
                    break;
                }
            }

            InventorySystem.updateQuality();

            for (Item item : InventorySystem.getItems()) {
                if ("Freshly baked bread".equals(item.getName())) {
                    Assert.assertTrue(item.getQuality() == prevQuality + 2);
                }
            }
        }
    }

    @Test
    public void testOnceTheSellByDateHasPassed() throws Exception {
        for (int i = 0; i < NIGHTS; i++) {
            List<Item> prevItems = new ArrayList<Item>();
            for (Item item : InventorySystem.getItems()) {
                prevItems.add(new Item(item.getName(), item.getSellIn(), item.getQuality()));
            }
            InventorySystem.updateQuality();
            for (Item item : InventorySystem.getItems()) {
                if ("Wine".equals(item.getName())) continue;
                if ("Gold".equals(item.getName())) continue;
                if ("Concert Ticket".equals(item.getName())) continue;
                if (item.getSellIn() < 0) {
                    for (Item prevItem : prevItems) {
                        if (item.getName().equals(prevItem.getName())) {
                            Assert.assertTrue(item.getQuality() == 0 || item.getQuality() == prevItem.getQuality() - 2);
                        }
                    }
                }
            }
        }
    }
}
