package Model;

public class MedicalItem extends DefaultMedicalItem {

    public MedicalItem(String name, Long id, Double price, Integer quantity) {
        super(name, id, price, quantity);
    }

    @Override
    public Double getPriceWithTax() {
        return super.getQuantity()*(super.getPrice() + (super.getPrice()*super.getTaxRate())/100);
    }

    @Override
    public Double getSalesTax() {
        return super.getQuantity()*(super.getPrice()*super.getTaxRate()/100);
    }
}
