package project.asd.rentalframework.checkin;

import android.util.Log;

import com.lokex.apiconnector.AppLogger;

/**
 * Created by lokex on 5/17/16.
 */
public class ItemAvailableState  implements  ItemState{

    AbstractProduct product;
    public ItemAvailableState(AbstractProduct product){

        this.product = product;
    }

    @Override
    public boolean checkout() {
        product.setCurrentState(product.getCheckedoutState());
        //checkedout successfully
        return true;
    }

    @Override
    public boolean settle() {
        AppLogger.showLog("", "Item should be checkedout first to settle");
        return false;

    }
}