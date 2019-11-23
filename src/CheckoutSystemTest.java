import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSystemTest {

    @Test
    void test() {
        ArrayList<String> items = new ArrayList<String >();
        items.add("Apple");
        items.add("Apple");
        items.add("Orange");
        items.add("Apple");

        assertEquals(205.0, new CheckoutSystem().doCheckout(items));
    }
}
