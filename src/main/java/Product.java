import java.util.Objects;

public class Product {

    private String name;

    private Long quantity;

    private Double unitPrice;

    public Product(String name, Long quantity, Double unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName()) &&
                Objects.equals(getQuantity(), product.getQuantity()) &&
                Objects.equals(getUnitPrice(), product.getUnitPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQuantity(), getUnitPrice());
    }
}
