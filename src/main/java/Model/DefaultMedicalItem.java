package Model;

public abstract class DefaultMedicalItem extends ItemComponent {

    public DefaultMedicalItem(String name, Long id, Double price, Integer quantity) {
        super(name, id, price, quantity);
    }

    @Override
    public Double getTaxRate() {
        return 0.0;
    }
}
