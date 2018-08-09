package Model;

public abstract class DefaultNonMedicalItem extends ItemComponent {

    public DefaultNonMedicalItem(String name, Long id, Double price, Integer quantity) {
        super(name, id, price, quantity);
    }

    public Double getTaxRate() {
            return 20.0;
        }
}
