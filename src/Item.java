import java.text.DecimalFormat;

public class Item {
    String name;
    String description;
    int quantity;
    double price;
    DecimalFormat priceFormat = new DecimalFormat("$#,##0.00");

    public Item(String name, String description, int quantity, double price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public String toString() {
        return "%s - %s - %s (x%d)".formatted(
                this.getName(),
                this.getDescription(),
                priceFormat.format(this.getPrice()),
                this.getQuantity()
        );
    }
}
