package project.asd.rentalframework.checkin;

import java.util.Date;
import java.util.List;

/**
 * Created by lokex on 5/17/16.
 * holds the record for the product checkout by user from AcheckoutProcessor
 */
public class Transaction {

    List<AbstractProduct> checkedOutItems;
    Date checkedOutDate;

    public Transaction(List<AbstractProduct> checkedOutItems){
        this.checkedOutItems = checkedOutItems;
    }

    public List<AbstractProduct> getCheckedOutItems() {
        return checkedOutItems;
    }

    public void setCheckedOutItems(List<AbstractProduct> checkedOutItems) {
        this.checkedOutItems = checkedOutItems;
    }
}
