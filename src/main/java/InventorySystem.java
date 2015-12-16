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

        for (int i = 0; i < items.size(); i++)
        {
            if ((!"Wine".equals(items.get(i).getName())) && !"Concert Ticket".equals(items.get(i).getName()))
            {
                if (items.get(i).getQuality() > 0)
                {
                    if (!"Gold".equals(items.get(i).getName()))
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                    }
                }
            }
            else
            {
                if (items.get(i).getQuality() < 50)
                {
                    items.get(i).setQuality(items.get(i).getQuality() + 1);

                    if ("Concert Ticket".equals(items.get(i).getName()))
                    {
                        if (items.get(i).getSellIn() < 11)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }

                        if (items.get(i).getSellIn() < 6)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Gold".equals(items.get(i).getName()))
            {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }

            if (items.get(i).getSellIn() < 0)
            {
                if (!"Wine".equals(items.get(i).getName()))
                {
                    if (!"Concert Ticket".equals(items.get(i).getName()))
                    {
                        if (items.get(i).getQuality() > 0)
                        {
                            if (!"Gold".equals(items.get(i).getName()))
                            {
                                items.get(i).setQuality(items.get(i).getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                }
                else
                {
                    if (items.get(i).getQuality() < 50)
                    {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
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
