import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class ShoppingCartTest {

    @Test
    public void returnsZeroWhenCartIsEmpty() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Double total = shoppingCart.getTotal();
        assertThat(total, is(0.0));
    }

    @Test
    public void returnsTotalWhenCartIsHasFiveDoveSoaps() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Product("Dove Soap", 5L, 39.99));
        Double total = shoppingCart.getTotal();
        assertThat(shoppingCart.getProductList(), hasItems(new Product("Dove Soap", 5L, 39.99)));
        assertThat(total, is(199.95));
    }

    @Test
    public void returnsTotalWhenCartIsHasEightDoveSoaps() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Product("Dove Soap", 8L, 39.99));
        Double total = shoppingCart.getTotal();
        assertThat(shoppingCart.getProductList(), hasItems(new Product("Dove Soap", 8L, 39.99)));
        assertThat(total, is(319.92));
    }

    @Test
    public void returnsTotalWhenCartIsHasMultipleProducts() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.add(new Product("Dove Soap", 2L, 39.99));
        shoppingCart.add(new Product("Axe Deo", 2L, 99.99));

        List<Product> expectedArray = new ArrayList<Product>();
        expectedArray.add(new Product("Dove Soap", 2L, 39.99));
        expectedArray.add(new Product("Axe Deo", 2L, 99.99));
        assertThat(shoppingCart.getProductList(), is(expectedArray));
        Double salesTax = shoppingCart.calculateSalesTax(shoppingCart.getTotal());
        // A conflict in the requirement, where the round off should happen to the nth digit and it equates to 34.99
        assertThat(salesTax, is(34.99));
        Double payableAmount = shoppingCart.getTaxedTotal(shoppingCart.getTotal(), salesTax);

        assertThat(payableAmount, is(314.95));

    }
}
