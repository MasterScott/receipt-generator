package Model;

public abstract class ItemComponent {
    final private String name;
    final private Long id;
    final private Double price;
    final private Integer quantity;

    public ItemComponent(String name, Long id, Double price, Integer quantity) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getTaxRate() {
        throw new UnsupportedOperationException();
    }

    public Double getPriceWithTax() {
        throw new UnsupportedOperationException();
    }

    public Double getSalesTax() {
        throw new UnsupportedOperationException();
    }

    public Long getItemId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "ItemComponent{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
