package project.asd.rentalframework.checkin;

import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by lokex on 5/17/16.
 */
public abstract class AcheckoutProcessor extends AppCompatActivity implements ICartPriceObserver{

    public final void proceedCheckout(Transaction transaction){
    //    List<AbstractProduct> abstractProducts = setItemsForCheckout();
        double amount = calculatePrice(transaction.getCheckedOutItems());
        confirmCheckout(amount);
    }

    //display ui for product selection and return the selected ones
 //   public abstract List<AbstractProduct> setItemsForCheckout();

    public abstract double calculatePrice(List<AbstractProduct> abstractProducts);


    // display ui with checkout item and price
    public abstract Transaction confirmCheckout(double totalPriceofTransaction);

    //make payments and all and return true to generate bill
    public abstract boolean checkout(List<AbstractProduct> abstractProducts);

    public abstract void returnPayment();

    public abstract void printBill(boolean shouldGenerateBill);

}
