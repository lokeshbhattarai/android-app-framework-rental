package project.asd.rentalframework.core;

import java.util.Date;

/**
 * Created by lokex on 5/17/16.
 * respresents the items that can be checkedout
 */
public abstract class AbstractProduct {
    boolean isAvailable;

    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    //return price for this product
    public abstract double getPrice();

    //return a clone to add in cart
    public abstract AbstractProduct clone();


    //set the state of product either available or checkedout
    public abstract void setCurrentState(ItemState state);

    public abstract void setCheckedoutState(ItemState state);

    public abstract ItemState getCheckedoutState();

    public abstract void setAvailableState(ItemState state);

    public abstract ItemState getAvailableState();

    public abstract AbstractFineStrategy getFineStrategy(Date checkedOutDate);

}
