package project.asd.rentalframework.core;

/**
 * Created by lokex on 5/17/16.
 * item state whether it is checkedout or settled/ available .
 *
 * An item is available for checkout only after it is settled.
 */
public interface ItemState {
   // CHECKED_OUT,,AVAILABLE;

 //   public void checkout();
 //   public void settle();
 //   public void cancel();
    public void proceed();
}
