import Model.ItemComponent;
import Model.Items;
import javafx.util.Pair;

import java.text.DecimalFormat;
import java.util.Map;

public class ReceiptGenerator {
    final private static DecimalFormat df = new DecimalFormat("#.00");

    private final Items allItems;

    public ReceiptGenerator(Items allItems) {
        this.allItems = allItems;
    }

    public void generateReceipt() {
        final Map<Long, ItemComponent> items = allItems.getAllItems();
        items.keySet().stream().forEach(itemKey -> {
            final ItemComponent itemComponent = items.get(itemKey);
            System.out.println(itemComponent.getQuantity() + " " + itemComponent.getName() + ": " + df.format(itemComponent.getPriceWithTax()));

        });
        Pair<Double, Double> taxAndPrices = allItems.getSalesTaxAndPriceWithTax();
        System.out.println("Sales Tax: " + df.format(taxAndPrices.getKey()));
        System.out.println("Total: " + df.format(taxAndPrices.getValue()));
    }
}
