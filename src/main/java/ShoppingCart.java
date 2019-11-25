import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final static Double salesTaxPercentage = 12.5;

    List<Product> productDB = new ArrayList<Product>();

    public List<Product> getProductList(){
        return productDB;
    }

    public Double getTotal() {
        Double total = new Double(0.0);
        for (Product product : productDB) {
            total = total + product.getQuantity() * product.getUnitPrice();
        }
        total = format(total);
        return total;
    }

    public Double getTaxedTotal(Double total, Double salesTax){
        return total + salesTax;
    }

    public void add(Product product) {
        productDB.add(product);
    }

    private Double format(Double total) {
        Double formattedTotal = Math.round(total * 100.0) / 100.0;
        return formattedTotal;
    }

    public Double calculateSalesTax(Double total) {
        Double salesAmount = (salesTaxPercentage / 100) * total;
        salesAmount = format(salesAmount);
        return salesAmount;
    }

}
