package project.asd.rentalframework.checkin;

import java.util.List;

/**
 * Created by lokex on 5/17/16.
 */
public interface Priceable {

    public double getDiscountAmount(List<AbstractProduct> products);
    public double getFineAmount();

//    public double computePayableAmount()
}
