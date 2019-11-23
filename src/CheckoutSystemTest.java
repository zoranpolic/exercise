import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSystemTest {

    @Test
    void testNoOffer() {
        ArrayList<String> items = new ArrayList<String >();
        items.add("Apple");
        items.add("Apple");
        items.add("Orange");
        items.add("Apple");

        assertEquals(205.0, new CheckoutSystem().doCheckout(items));
    }

    @Test
    void testOfferApples() {
        ArrayList<String> items = new ArrayList<String >();
        items.add("Apple");
        items.add("Apple");
        items.add("Orange");
        items.add("Apple");
        items.add("offer_apples");

        assertEquals(115.0, new CheckoutSystem().doCheckout(items));
    }

    @Test
    void testOfferOranges() {
        ArrayList<String> items = new ArrayList<String >();
        items.add("Apple");
        items.add("Apple");
        items.add("Orange");
        items.add("Apple");
        items.add("offer_oranges");

        assertEquals(196.67, new CheckoutSystem().doCheckout(items), .005);
    }
}
