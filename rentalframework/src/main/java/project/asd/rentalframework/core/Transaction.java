package project.asd.rentalframework.core;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by lokex on 5/17/16.
 * holds the record for the product checkout by user from AcheckoutProcessor
 */
public class Transaction {

    private UUID id;
    private List<AbstractProduct> checkedOutItems;
    private Date checkedOutDate;
    private ICustomer customer;

    public Transaction(List<AbstractProduct> checkedOutItems, ICustomer customer){
        id = UUID.randomUUID();
        this.checkedOutItems = checkedOutItems;
        checkedOutDate = new Date();
        this.customer = customer;
    }

    public UUID getTransactionId(){
        return id;
    }

    public List<AbstractProduct> getCheckedOutItems() {
        return checkedOutItems;
    }

    public Date getCheckoutDate(){
        return checkedOutDate;
    }
    public void setCheckedOutItems(List<AbstractProduct> checkedOutItems) {
        this.checkedOutItems = checkedOutItems;
    }

    public void cancelTransaction(){
        for(AbstractProduct product : checkedOutItems){
            ItemState availableState = new ItemAvailableState(product);
            availableState.cancel();
        }
    }

    public void finalizeTransaction(){
        for(AbstractProduct product : checkedOutItems){
            ItemState availableState = new ItemAvailableState(product);
            availableState.settle();
        }
    }
}
