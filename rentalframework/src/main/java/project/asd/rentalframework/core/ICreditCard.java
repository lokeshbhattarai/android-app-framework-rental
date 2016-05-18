package project.asd.rentalframework.core;

import java.util.Date;

/**
 * Created by Audi on 5/18/2016.
 */
public interface ICreditCard {
    public String getNameOnCard();

    public String getCardNumber();

    public Date getExpiredDate();

    public CreditCardType creditCardType();

    public Long getBalance();

}

enum CreditCardType{
    VISA, MASTERCARD, AMERICANEXPRESS, DISCOVERY;
}