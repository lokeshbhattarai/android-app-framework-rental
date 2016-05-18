package project.asd.rentalframework.checkin;

/**
 * Created by Audi on 5/18/2016.
 */
public interface ICommand {
    public void execute(); //Check out or Settle
    public void undo();    //Cancel the order/booking
    public Transaction getTransaction();
}
