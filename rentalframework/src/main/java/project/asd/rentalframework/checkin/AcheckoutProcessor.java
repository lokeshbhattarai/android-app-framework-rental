package project.asd.rentalframework.checkin;

import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by lokex on 5/17/16.
 */
public abstract class AcheckoutProcessor extends AppCompatActivity implements ICartPriceObserver{


    public final void proceedCheckout(){

        List<AbstractProduct> abstractProducts = getItemsForCheckout();
        double amount = calculatePrice(abstractProducts);
        confirmCheckout(amount);
    }


    //display ui for product selection and return the selected ones
    public abstract List<AbstractProduct> getItemsForCheckout();



    public abstract double calculatePrice(List<AbstractProduct> abstractProducts);


    // display ui with checkout item and price
    public abstract boolean confirmCheckout(double price);


    //make payments and all and return true to generate bill
    public abstract boolean checkout(List<AbstractProduct> abstractProducts);

    public abstract void printBill(boolean shouldGenerateBill);


}