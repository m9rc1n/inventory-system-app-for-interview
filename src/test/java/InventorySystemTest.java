import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;


public class InventorySystemTest {


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
}
