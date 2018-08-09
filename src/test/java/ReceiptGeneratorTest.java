import Model.Items;
import Model.MedicalItem;
import Model.NonMedicalItem;
import org.junit.Test;

public class ReceiptGeneratorTest {

    @Test
    public void TestReceiptGenerator() {
        Items items = new Items();
        items.add(new NonMedicalItem("bottle of wine", UniqueId.getId(), 20.00 , 1));
        items.add(new MedicalItem("box of tooth ache pills", UniqueId.getId(), 4.0, 1));
        items.add(new NonMedicalItem("box of pins",  UniqueId.getId(), 10.0, 1));
        items.add(new NonMedicalItem("book",  UniqueId.getId(), 30.0, 1));
        items.add(new NonMedicalItem("chocolate",  UniqueId.getId(),  1.0, 1));

        ReceiptGenerator receiptGenerator = new ReceiptGenerator(items);
        receiptGenerator.generateReceipt();
    }
}
