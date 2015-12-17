import java.util.ArrayList;
import java.util.List;

public class InventorySystem {

    private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        System.out.println("Starting the Inventory System");

        items = new ArrayList<Item>();
        items.add(new Item("School Uniform", 10, 20));
        items.add(new Item("Wine", 2, 0));
        items.add(new Item("Poultry", 5, 7));
        items.add(new Item("Gold", 0, 80));
        items.add(new Item("Concert Ticket", 15, 20));
        items.add(new Item("Chocolate Eclair", 3, 6));

        updateQuality();
    }

    public static void updateQuality() {

        for (Item item : items) {
            if ((!"Wine".equals(item.getName())) && !"Concert Ticket".equals(item.getName())) {
                if (item.getQuality() > 0) {
                    if (!"Gold".equals(item.getName())) {
                        item.setQuality(item.getQuality() - 1);
                    }
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if ("Concert Ticket".equals(item.getName())) {
                        if (item.getSellIn() < 11) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }

                        if (item.getSellIn() < 6) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }
                    }
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
                    } else {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }

    public static List<Item> getItems() {
        return items;
    }

    public static void setItems(List<Item> items) {
        InventorySystem.items = items;
    }
}
