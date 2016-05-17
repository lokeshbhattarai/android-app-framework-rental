package project.asd.rentalframework.checkin;

/**
 * Created by lokex on 5/17/16.
 */
public interface ICartPriceObserver {

    //get the updated total price from the cart and show it to UI
    public void updateCartPrice(double newTotalCartPrice);


}
