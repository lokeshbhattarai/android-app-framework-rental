package project.asd.rentalframework.core;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lokex on 5/17/16.
 */
public abstract class ASettleProcessor extends AppCompatActivity{

    protected List<HashMap<AbstractProduct,Double>> itemsWithFine = new ArrayList<>();

    public final void settleTransaction(Transaction transaction){

        List<AbstractProduct> items = transaction.getCheckedOutItems();
        for (AbstractProduct item:items) {
            AbstractFineStrategy strategy = item.getFineStrategy(transaction.getCheckoutDate());

            HashMap<AbstractProduct, Double> map =new HashMap<AbstractProduct, Double>();
            if(strategy!=null) {
               double fine = strategy.apply();
                map.put(item, fine);
           }else{
                map.put(item, 0.0);
            }

            itemsWithFine.add(map);

        }

        boolean shouldGenerateBill = settle(itemsWithFine);
        printBill(shouldGenerateBill);
    }

    //make payments and all and return true to generate bill
    public abstract boolean settle(List<HashMap<AbstractProduct,Double>> abstractProducts);

    public abstract void printBill(boolean shouldGenerateBill);



}
