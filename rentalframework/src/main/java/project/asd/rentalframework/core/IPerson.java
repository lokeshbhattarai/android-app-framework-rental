package project.asd.rentalframework.core;

import java.util.Date;

/**
 * Created by Audi on 5/18/2016.
 */
public interface IPerson {
    public String getFistname();
    public String getLastname();
    public String getPhoneNumber();
    public IAddress getAddress();
    public Date getDOB();
}
