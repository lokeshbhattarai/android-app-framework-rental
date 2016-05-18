package project.asd.rentalframework.core;

/**
 * Created by Audi on 5/18/2016.
 */
public interface ICustomer extends IPerson{
    public CustomerType getCustomerType();
    public ICreditCard getCreditCard();
}

enum CustomerType{
    LEVEL1, LEVEL2, LEVEL3;
}