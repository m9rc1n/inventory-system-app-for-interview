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
        items.add(new StrategyItem("Wine", 2, 0, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Poultry", 5, 7, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Gold", 0, 80, new SimpleQualityStrategy()));
        items.add(new StrategyItem("Concert Ticket", 15, 20, new ConcertTicketQualityStrategy()));
        items.add(new StrategyItem("Chocolate Eclair", 3, 6, new SimpleQualityStrategy()));

        updateQuality();
    }

    public static void updateQuality() {

        for (StrategyItem item : items) {
            if ("Concert Ticket".equals(item.getName())) {
                item.updateQuality();
                continue;
            }
            if ((!"Wine".equals(item.getName())) && !"Concert Ticket".equals(item.getName())) {
                if (item.getQuality() > 0) {
                    if (!"Gold".equals(item.getName())) {
                        item.updateQuality();
                    }
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }

            if (!"Gold".equals(item.getName())) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                if (!"Wine".equals(item.getName())) {
                    if (!"Concert Ticket".equals(item.getName())) {
                        if (item.getQuality() > 0) {
                            if (!"Gold".equals(item.getName())) {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }

    public static List<StrategyItem> getItems() {
        return items;
    }

    public static void setItems(List<StrategyItem> items) {
        InventorySystem.items = items;
    }
}
