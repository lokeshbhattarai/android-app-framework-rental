package project.asd.rentalframework.checkin;

import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by lokex on 5/17/16.
 */
public abstract class AcheckoutProcessor extends AppCompatActivity implements ICartPriceObserver{

    private Transaction transaction;
    private List<AbstractProduct> itemsForCheckout;

    public AcheckoutProcessor(Transaction transaction){
        this.itemsForCheckout = setItemsForCheckout();
        this.transaction = transaction;
        this.transaction.setCheckedOutItems(itemsForCheckout);
    }
    public final void proceedCheckout(Transaction transaction){
        double amount = calculatePrice();
        confirmCheckout(amount);
    }

    //display ui for product selection and return the selected ones
    public abstract List<AbstractProduct> setItemsForCheckout();

    public abstract double calculatePrice();

    // display ui with checkout item and price
    public abstract Transaction confirmCheckout(double totalPriceofTransaction);

    //make payments and all and return true to generate bill
    public abstract boolean checkout();

    public abstract void returnPayment();

    public abstract void printBill(boolean shouldGenerateBill);

}
