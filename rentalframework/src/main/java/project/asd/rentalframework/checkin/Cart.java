package project.asd.rentalframework.checkin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lokex on 5/17/16.
 */
public class Cart {

    private static List<AbstractProduct> items ;
    private double totalPrice =0;

    private static List<ICartPriceObserver> observers;

    private static final Cart cart = new Cart();

    private Cart(){}

    public static Cart getInstance(){
        items = new ArrayList<AbstractProduct>();
        observers = new ArrayList<>();
        return cart;
    }


    public void addItem(AbstractProduct item){
        items.add(item);
        totalPrice += item.getPrice();
        notifyPriceChange(totalPrice);

    }

    public void attachObserver(ICartPriceObserver observer){
        observers.add(observer);
    }



    public void detachObserver(ICartPriceObserver observer) {

        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(index);
        }
    }

        public void notifyPriceChange(double newPrice){

            for (ICartPriceObserver observer:observers) {
                observer.updateCartPrice(newPrice);
            }


        }


}
