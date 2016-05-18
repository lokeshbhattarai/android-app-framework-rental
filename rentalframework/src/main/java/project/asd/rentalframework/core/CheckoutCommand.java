package project.asd.rentalframework.core;

import java.util.List;
import java.util.UUID;

/**
 * Created by Audi on 5/18/2016.
 */
public class CheckoutCommand implements ICommand {

    private Transaction transaction;
    private List<AbstractProduct> products;
    private ICustomer customer;

    public CheckoutCommand(ICustomer customer, List<AbstractProduct> products){
        this.products = products;
        this.customer = customer;
    }

    public UUID getTransactionId(){
        if(transaction == null) return null;
        return transaction.getTransactionId();
    }
    @Override
    public void execute() {
        transaction = new Transaction(products, customer);
    }

    @Override
    public void undo() {
        transaction.cancelTransaction();
    }

    @Override
    public Transaction getTransaction() {
        return transaction;
    }
}
