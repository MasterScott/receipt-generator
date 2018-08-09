package Model;

import javafx.util.Pair;

import java.util.*;

public class Items {
    private final Map<Long, ItemComponent> items = new LinkedHashMap<>();

    public void add(ItemComponent itemComponent) {
        try {
            if (!items.containsKey(itemComponent.getItemId())) {
                items.put(itemComponent.getItemId(), itemComponent);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void remove(ItemComponent itemComponent) {
        try {
            if (items.containsKey(itemComponent.getItemId())) {
                items.remove(itemComponent.getItemId());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public Map<Long, ItemComponent> getAllItems() {
        return items;
    }

    public ItemComponent getItem(Long id) {
        try {
            if (items.containsKey(id)) {
                return items.get(id);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        throw new RuntimeException("Item does not exists");
    }

    public List<ItemComponent> getItem(String name) {
        try {
            Iterator<ItemComponent> iterator = items.values().iterator();
            List<ItemComponent> itemComponentList = new ArrayList<>();
            while (iterator.hasNext()) {
                ItemComponent itemComponent = iterator.next();
                if (itemComponent.getName().equals(name)) {
                    itemComponentList.add(itemComponent);
                }
            }
            return itemComponentList;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        throw new RuntimeException("Item does not exists");
    }

    public Pair<Double, Double> getSalesTaxAndPriceWithTax() {
        Iterator<ItemComponent> iterator = items.values().iterator();
        Double totalSalesTax = 0.0;
        Double totalPriceWithTax = 0.0;
        while (iterator.hasNext()) {
            ItemComponent itemComponent = iterator.next();
            totalSalesTax += itemComponent.getSalesTax();
            totalPriceWithTax += itemComponent.getPriceWithTax();
        }
        return new Pair<>(totalSalesTax, totalPriceWithTax);
    }
}
