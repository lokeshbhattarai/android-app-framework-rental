package project.asd.rentalframework.checkin;

import android.util.Log;

import com.lokex.apiconnector.AppLogger;

/**
 * Created by lokex on 5/17/16.
 */
public class ItemAvailableState implements ItemState{

    AbstractProduct product;
    public ItemAvailableState(AbstractProduct product){

        this.product = product;
    }

    @Override
    public void proceed() {
        product.setAvailable(true);
    }
/*
    @Override
    public void settle() {
        product.setAvailable(true);
        AppLogger.showLog("", "Item should be checkedout first to settle");
    }

    @Override
    public void cancel(){
        product.setAvailable(false);
    }
    */
}