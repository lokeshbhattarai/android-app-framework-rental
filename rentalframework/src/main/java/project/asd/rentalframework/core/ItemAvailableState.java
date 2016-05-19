package project.asd.rentalframework.core;

import android.util.Log;

/**
 * Created by lokex on 5/17/16.
 */
public class ItemAvailableState implements ItemState{

    AbstractProduct product;
    public ItemAvailableState(AbstractProduct product){

        this.product = product;
    }


    @Override
    public boolean settle() {
        Log.i("ItemAvailableState", "Item should be checkedout first to settle");
        return false;
    }

    @Override
    public boolean checkout(){
        product.setCurrentState(product.getCheckedoutState());
        return true; //checkout successfully
    }

    @Override
    public boolean cancel(){
        Log.i("ItemAvailableState", "Item is available");
        return true;
    }
}