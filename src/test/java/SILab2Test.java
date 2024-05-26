import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
public class SILab2Test {

    @Test
    public void testEveryBranch() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 0));
        assertEquals("allItems list can't be null!", e.getMessage());
        List<Item> items = new ArrayList<>();
        items.add(new Item(null, null, 12, 5.4));
        List<Item> finalItems = items;
        e = assertThrows(RuntimeException.class, () -> SILab2.checkCart(finalItems, 200));
        assertEquals("No barcode!", e.getMessage());
        items = new ArrayList<>();
        //), (beer, 0222, 301, 0.1), (milk, 123a, 12, 5.4)}, 20000
        items.add(new Item("shampoo", "223", 20, 0));
        items.add(new Item("beer", "0222", 301, 0.1));
        items.add(new Item("milk", "123a", 12, 5.4));
        assertTrue(SILab2.checkCart(items, 20000));
        items = new ArrayList<>();
        items.add(new Item("water", "122223", 2000000, 0.1));
        assertFalse((SILab2.checkCart(items, 20)));
    }

    @Test
    public void testMultipleCondition() {
        //{(fish, 123, 300, 0)}, 100
        List<Item> items = new ArrayList<>();
        items.add(new Item("fish", "123", 300, 0.0));
        assertTrue(SILab2.checkCart(items, 271)); // 300 - 300 * 0.0 - 30 = 270
        items = new ArrayList<>();
        items.add(new Item("wine", "123", 301, 0.0));
        assertTrue(SILab2.checkCart(items, 1231));
        items = new ArrayList<>();
        items.add(new Item("ice cream", "23124", 3001, 0.1));
        assertTrue(SILab2.checkCart(items, 10000));
        items = new ArrayList<>();
        items.add(new Item("gun", "007", 3000, 0.07));
        assertFalse(SILab2.checkCart(items, 1000));
    }
}