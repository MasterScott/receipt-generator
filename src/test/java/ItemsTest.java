import Model.ItemComponent;
import Model.Items;
import Model.MedicalItem;
import Model.NonMedicalItem;
import javafx.util.Pair;
import org.junit.Test;

import java.util.List;

public class ItemsTest {

    @Test
    public void add() throws Exception {
        final Items items = new Items();
        final Long bookId = UniqueId.getId();
        final Long toothpasteId = UniqueId.getId();
        items.add(new MedicalItem("toothpaste", toothpasteId,1.0, 1));
        items.add(new NonMedicalItem("book", bookId,20.0, 2));
        ItemComponent item = items.getItem(bookId);
        assert(item.getName().equals("book"));
        assert(item.getPrice() == 20.0);
        assert(item.getSalesTax() == 8.0);
        assert(item.getPriceWithTax() == 48.0);
        item = items.getItem(toothpasteId);
        assert(item.getName().equals("toothpaste"));
        assert(item.getPrice() == 1.0);
        assert(item.getSalesTax() == 0.0);
        assert(item.getPriceWithTax() == 1.0);
    }

    @Test(expected = RuntimeException.class)
    public void remove() throws Exception {
        final Items items = new Items();
        final Long bookId = UniqueId.getId();
        items.add(new NonMedicalItem("book", bookId, 20.0, 2));
        final ItemComponent item = items.getItem(bookId);
        assert(item.getName().equals("book"));
        assert(item.getPrice() == 20.0);
        assert(item.getSalesTax() == 8.0);
        assert(item.getPriceWithTax() == 48.0);
        items.remove(item);
        items.getItem(bookId);
    }

    @Test
    public void removeNonExistingItem() throws Exception {
        Items items = new Items();
        final ItemComponent item = new NonMedicalItem("book", UniqueId.getId(), 20.0, 2);
        items.remove(item);
    }

    @Test
    public void getItem() throws Exception {
        final Items items = new Items();
        final Long bookId = UniqueId.getId();
        items.add(new NonMedicalItem("book", bookId, 20.0, 2));
        final ItemComponent item = items.getItem(bookId);
        assert(item.getName().equals("book"));
        assert(item.getPrice() == 20.0);
        assert(item.getSalesTax() == 8.0);
        assert(item.getPriceWithTax() == 48.0);
    }

    @Test
    public void getItemWithName() throws Exception {
        Items items = new Items();
        final ItemComponent itemComponent1 = new NonMedicalItem("book", UniqueId.getId(), 20.0, 2);
        final ItemComponent itemComponent2 = new NonMedicalItem("book", UniqueId.getId(), 20.0, 2);
        final ItemComponent itemComponent3 = new NonMedicalItem("book", UniqueId.getId(), 20.0, 2);
        final ItemComponent itemComponent4 = new NonMedicalItem("book", UniqueId.getId(), 20.0, 2);
        items.add(itemComponent1);
        items.add(itemComponent2);
        items.add(itemComponent3);
        items.add(itemComponent4);
        final List<ItemComponent> itemList = items.getItem("book");
        assert (itemList.size() == 4);
        assert(itemList.contains(itemComponent1));
        assert(itemList.contains(itemComponent2));
        assert(itemList.contains(itemComponent3));
        assert(itemList.contains(itemComponent4));
    }

    @Test(expected = RuntimeException.class)
    public void getItemWithException() {
        final Items items = new Items();
        final Long bookId = UniqueId.getId();
        items.add(new NonMedicalItem("book", bookId, 20.0, 2));
        ItemComponent preItem = items.getItem(bookId);
        items.remove(preItem);
        items.getItem(bookId);
    }

    @Test
    public void getSalesTaxAndPriceWithTax() {
        final Items items = new Items();
        items.add(new NonMedicalItem("book", UniqueId.getId(), 20.0, 2));
        items.add(new MedicalItem("toothpaste", UniqueId.getId(),1.0, 1));
        final Pair<Double, Double> saleTaxAndPriceAfterTax = items.getSalesTaxAndPriceWithTax();
        assert (saleTaxAndPriceAfterTax.getKey() == 8);
        assert (saleTaxAndPriceAfterTax.getValue() == 49);
    }
}
