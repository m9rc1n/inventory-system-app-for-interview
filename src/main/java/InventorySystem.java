import strategies.*;

import java.util.ArrayList;
import java.util.List;

public class InventorySystem {

    private static List<StrategyItem> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        System.out.println("Starting the Inventory System");

        items = new ArrayList<StrategyItem>();
        items.add(new StrategyItem("School Uniform", 10, 20, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Wine", 2, 0, new WineQualityStrategy()));
        items.add(new StrategyItem("Poultry", 5, 7, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Gold", 0, 80, new GoldQualityStrategy()));
        items.add(new StrategyItem("Concert Ticket", 15, 20, new ConcertTicketQualityStrategy()));
        items.add(new StrategyItem("Chocolate Eclair", 3, 6, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Fresh Baked Bread", 12, 32, new FreshBackedBreadQualityStrategy()));

        updateQuality();
    }

    public static void updateQuality() {

        for (StrategyItem item : items) {
            item.updateQuality();
        }
    }

    public static List<StrategyItem> getItems() {
        return items;
    }

    public static void setItems(List<StrategyItem> items) {
        InventorySystem.items = items;
    }
}
