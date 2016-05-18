package project.asd.rentalframework.core;

/**
 * Created by lokex on 5/17/16.
 */
public class ItemCheckoutState implements  ItemState{

    AbstractProduct product;
    public ItemCheckoutState(AbstractProduct product){

        this.product = product;
    }

    @Override
    public void proceed() {
        product.setAvailable(false);
    }

    /*
    @Override
    public boolean checkout() {
        Log.d("","Item already checked out can not checkout now");
        return false;
    }

    @Override
    public boolean settle() {
        product.setCurrentState(product.getAvailableState());
        return true;//settled successfully

    }*/
}
