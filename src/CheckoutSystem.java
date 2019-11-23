import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Checkout system for a shop which only sells apples and oranges
 */
public class CheckoutSystem {
    int oranges, apples;
    double total;
    boolean offerApples, offerOranges;

    final int APPLE_PRICE = 60;
    final int ORANGE_PRICE = 25;
    final double PENCE_TO_POUND = (double) 1/100;
    final String POUND_UNICODE = "\u00A3";
    final double OFFER_APPLES = (double) 1/2;
    final double OFFER_ORANGES = (double) 2/3;

    /**
     * Executes checkout for provided state of shopping cart
     * @param inputList is list of string values representing shopping cart items
     * @return total is final price value in pence
     */
    double doCheckout(ArrayList<String> inputList){
        init();

        for(String item: inputList){
            if(item.equalsIgnoreCase("orange"))
                oranges++;
            else if(item.equalsIgnoreCase("apple"))
                apples++;
            else if(item.equalsIgnoreCase("offer_apples"))
                offerApples = true;
            else if(item.equalsIgnoreCase("offer_oranges"))
                offerOranges = true;
        }

        double applesPrice = offerApples ? apples*APPLE_PRICE*OFFER_APPLES : apples*APPLE_PRICE;
        double orangesPrice = offerOranges ? oranges*ORANGE_PRICE*OFFER_ORANGES : oranges*ORANGE_PRICE;
        total = total + applesPrice + orangesPrice;

        print();
        return total;
    }

    /**
     * Prints final price in pounds with two decimals
     */
    private void print() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        System.out.println(POUND_UNICODE + df.format(total*PENCE_TO_POUND));
    }

    /**
     * Initializes variables where item counts, final price, and presence of offers are stored
     */
    private void init() {
        oranges = apples = 0;
        total = 0;
        offerApples = offerOranges = false;
    }

}
